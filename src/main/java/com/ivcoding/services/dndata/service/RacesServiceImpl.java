package com.ivcoding.services.dndata.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.MultiValueMap;

import com.ivcoding.services.dndata.domain.CreateRaceRequest;
import com.ivcoding.services.dndata.domain.CreateRaceResponse;
import com.ivcoding.services.dndata.domain.GetRacesResponse;
import com.ivcoding.services.dndata.domain.UpdateRaceRequest;
import com.ivcoding.services.dndata.domain.UpdateRaceResponse;
import com.ivcoding.services.dndata.exception.EntityNotFoundException;
import com.ivcoding.services.dndata.model.RaceCollection;
import com.ivcoding.services.dndata.repository.RacesRepository;

import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;

@Slf4j
@Service
public class RacesServiceImpl implements RacesService {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private MapperFacade orikaMapperFacade;

	@Autowired
	private RacesRepository raceRepository;

	@Override
	public GetRacesResponse getRaceById(String id) throws Exception {
		Optional<RaceCollection> raceFound = raceRepository.findById(id);
		if (raceFound.isPresent()) {
			GetRacesResponse race = new GetRacesResponse();
			race = orikaMapperFacade.map(raceFound.get(), GetRacesResponse.class);
			return race;
		} else
			throw new EntityNotFoundException("Race with the given id was not found.", RaceCollection.class);
	}

	@Override
	public List<GetRacesResponse> getRaces(MultiValueMap<String, String> queryMap) throws Exception {
		Query query = new Query();
		Set<String> attributes = queryMap.keySet();
		attributes.stream().forEach(key -> {
			List<String> values = queryMap.get(key);
			values.stream().forEach(value -> {
				query.addCriteria(Criteria.where(key).is(value).regex("^" + value + "$", "i"));
			});
		});
		log.debug("getRaces query - " + query.toString());
		List<RaceCollection> racesFound = mongoTemplate.find(query, RaceCollection.class);
		if (CollectionUtils.isEmpty(racesFound))
			throw new EntityNotFoundException("Races witht the provided attribute were not found.",
					RaceCollection.class);
		return orikaMapperFacade.mapAsList(racesFound, GetRacesResponse.class);
	}

	@Override
	public CreateRaceResponse postRace(CreateRaceRequest request) {
		CreateRaceResponse response = new CreateRaceResponse();
		RaceCollection raceEntity = new RaceCollection();
		raceEntity = orikaMapperFacade.map(request, RaceCollection.class);
		RaceCollection savedRace = raceRepository.save(raceEntity);
		response = orikaMapperFacade.map(savedRace, CreateRaceResponse.class);
		return response;
	}

	@Override
	public UpdateRaceResponse putRace(UpdateRaceRequest request, String id) throws Exception {
		UpdateRaceResponse response = new UpdateRaceResponse();
		GetRacesResponse getRace = getRaceById(id);
		orikaMapperFacade.map(request, getRace);
		RaceCollection raceEntity = orikaMapperFacade.map(getRace, RaceCollection.class);
		log.debug("Mapped found race to new entity: " + raceEntity);
		RaceCollection savedEntity = raceRepository.save(raceEntity);
		log.debug("Saved entity: " + savedEntity);
		response = orikaMapperFacade.map(savedEntity, UpdateRaceResponse.class);
		return response;
	}

	@Override
	public void deleteRace(String id) throws Exception {
		if (!raceRepository.existsById(id))
			throw new EntityNotFoundException("Race with the given id was not found.", RaceCollection.class);
		raceRepository.deleteById(id);
	}

}
