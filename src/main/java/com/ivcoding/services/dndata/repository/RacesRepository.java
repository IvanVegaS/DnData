package com.ivcoding.services.dndata.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ivcoding.services.dndata.model.RaceCollection;

@Repository
public interface RacesRepository extends MongoRepository<RaceCollection, String> {

}
