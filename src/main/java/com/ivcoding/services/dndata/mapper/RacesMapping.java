package com.ivcoding.services.dndata.mapper;

import org.springframework.stereotype.Component;

import com.ivcoding.services.dndata.domain.CreateRaceRequest;
import com.ivcoding.services.dndata.domain.CreateRaceResponse;
import com.ivcoding.services.dndata.domain.GetRacesResponse;
import com.ivcoding.services.dndata.domain.UpdateRaceRequest;
import com.ivcoding.services.dndata.domain.UpdateRaceResponse;
import com.ivcoding.services.dndata.model.RaceCollection;

import ma.glasnost.orika.MapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;

@Component
public class RacesMapping implements OrikaMapperFactoryConfigurer {

	@Override
	public void configure(MapperFactory orikaMapperFactory) {
		orikaMapperFactory.classMap(RaceCollection.class, GetRacesResponse.class).mapNulls(false).byDefault()
				.register();
		orikaMapperFactory.classMap(RaceCollection.class, UpdateRaceResponse.class).mapNulls(false).byDefault()
				.register();
		orikaMapperFactory.classMap(RaceCollection.class, CreateRaceResponse.class).mapNulls(false).byDefault()
				.register();
		orikaMapperFactory.classMap(GetRacesResponse.class, RaceCollection.class).mapNulls(false).byDefault()
				.register();
		orikaMapperFactory.classMap(CreateRaceRequest.class, RaceCollection.class).mapNulls(false).byDefault()
				.register();
		orikaMapperFactory.classMap(UpdateRaceRequest.class, RaceCollection.class).mapNulls(false).byDefault()
				.register();
		orikaMapperFactory.classMap(UpdateRaceRequest.class, GetRacesResponse.class).mapNulls(false).byDefault()
				.register();
	}

}