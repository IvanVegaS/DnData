package com.ivcoding.services.dndata.service;

import java.util.List;

import org.springframework.util.MultiValueMap;

import com.ivcoding.services.dndata.domain.CreateRaceRequest;
import com.ivcoding.services.dndata.domain.CreateRaceResponse;
import com.ivcoding.services.dndata.domain.GetRacesResponse;
import com.ivcoding.services.dndata.domain.UpdateRaceRequest;
import com.ivcoding.services.dndata.domain.UpdateRaceResponse;

public interface RacesService {
	GetRacesResponse getRaceById(String id) throws Exception;

	List<GetRacesResponse> getRaces(MultiValueMap<String, String> queryMap) throws Exception;

	CreateRaceResponse postRace(CreateRaceRequest request);

	UpdateRaceResponse putRace(UpdateRaceRequest request, String id) throws Exception;

	void deleteRace(String id) throws Exception;
}
