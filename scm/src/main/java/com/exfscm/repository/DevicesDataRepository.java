package com.exfscm.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.exfscm.model.Devices;

public interface DevicesDataRepository extends MongoRepository<Devices, String> 
{

}
