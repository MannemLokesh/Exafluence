package com.exfscm.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.exfscm.model.UserModel;
import com.exfscm.repository.AuthRepository;
import com.exfscm.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService
{
	@Autowired
	private AuthRepository repository;

	
	//Service Implementation method to save User Details in DB
	@Override
	public String save(UserModel userModel) 
	{
		Optional<UserModel> userDetalis=repository.findById(userModel.getEmail());
		
		//If the above Object userDetails is empty, that means there is no User with that Email and hence we can save it to DB
		if(userDetalis.isEmpty())
		{
			//Encrypting the password
			BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
			String hashedPassword = encoder.encode(userModel.getPassword());
			userModel.setPassword(hashedPassword); //Setting Encrypted password
			repository.save(userModel);
			return "Registration Successful";
		}
		//If the above Object userDetails is not empty, that means there is a User with that Email.
		else
		{
			return "already exist";
		}
	}
	
	//Service Implementation method to Validate User Details in DB
	@Override
	public String login(UserModel userModel)
	{
		Optional<UserModel> userDetails=repository.findById(userModel.getEmail());
		
		//If the above Object userDetails is empty, that means there is no User exist with that Email.
		if(userDetails.isEmpty())
		{
			return "Username not valid!";
		}
		//If the above Object userDetails is not empty, that means there is User exist with that Email in DB.
		else
		{
			//Creating Object of UserModel to get All the fields from DB.
			UserModel loginModel=userDetails.get();
			
			//Checking whether the password entered by the user and the password in DB is Matched or Not
			BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
			boolean isMatched = encoder.matches(userModel.getPassword(), loginModel.getPassword());
			
			//If the Password Entered by the User is Matched with Password in DB, Login Success.
			if(isMatched)
			{
				return "login success";
			}
			//If the Password Entered by the User is not Matched with Password in DB, Password is Incorrect.
			else
			{
				return "Password Incorrect!";
			}
		}
	}

}
