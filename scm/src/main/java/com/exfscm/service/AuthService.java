package com.exfscm.service;

import com.exfscm.model.UserModel;

public interface AuthService 
{
	String save(UserModel userModel);
	String login(UserModel userModel);
}
