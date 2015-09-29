package com.verizon.vzforum.service;

import org.json.JSONObject;

import com.verizon.vzforum.model.Login;

public interface LoginService {
	
	public JSONObject doLoginCheck(Login login);

}
