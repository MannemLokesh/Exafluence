package com.exfscm.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.exfscm.model.CreateShipmentModel;

public interface CreateShipmentRepository extends MongoRepository<CreateShipmentModel, Integer>
{

}
