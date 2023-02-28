package com.exfscm.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.exfscm.model.UserModel;

public interface AuthRepository extends MongoRepository<UserModel, String>
{
	
}
