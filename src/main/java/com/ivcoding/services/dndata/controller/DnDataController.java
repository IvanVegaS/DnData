package com.ivcoding.services.dndata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ivcoding.services.dndata.domain.CreateRaceRequest;
import com.ivcoding.services.dndata.domain.CreateRaceResponse;
import com.ivcoding.services.dndata.domain.GetRacesResponse;
import com.ivcoding.services.dndata.domain.UpdateRaceRequest;
import com.ivcoding.services.dndata.domain.UpdateRaceResponse;
import com.ivcoding.services.dndata.service.RacesService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/dndata")
public class DnDataController {

	@Autowired
	private RacesService racesService;

	@GetMapping(value = "/races/{id}", produces = "application/json")
	public GetRacesResponse getRace(@PathVariable String id) throws Exception {
		log.info("Getting race with id: " + id);
		return racesService.getRaceById(id);
	}

	@GetMapping(value = "/races", produces = "application/json")
	public List<GetRacesResponse> getRaces(@RequestParam MultiValueMap<String, String> queryMap) throws Exception {
		log.info("Getting races with filters: " + queryMap.toString());
		return racesService.getRaces(queryMap);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/races", consumes = "application/json", produces = "application/json")
	public CreateRaceResponse postRace(@RequestBody CreateRaceRequest request) {
		log.info("Creating race...");
		log.debug("Creating race using request: " + request);
		return racesService.postRace(request);
	}

	@ResponseStatus(HttpStatus.ACCEPTED)
	@PutMapping(value = "/races/{id}", consumes = "application/json", produces = "application/json")
	public UpdateRaceResponse putRace(@RequestBody UpdateRaceRequest request, @PathVariable String id)
			throws Exception {
		log.info("Updating race with id: " + id);
		log.debug("Updating race with id: " + id + " and request: " + request);
		return racesService.putRace(request, id);
	}

	@ResponseStatus(HttpStatus.ACCEPTED)
	@DeleteMapping(value = "/races/{id}")
	public void deleteRace(@PathVariable String id) throws Exception {
		log.info("Deleting race with id: " + id);
		racesService.deleteRace(id);
	}
}
