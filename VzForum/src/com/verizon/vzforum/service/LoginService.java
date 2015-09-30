package com.verizon.vzforum.service;

import org.json.JSONObject;

import com.verizon.vzforum.model.Login;
import com.verizon.vzforum.model.Queries;

public interface LoginService {
	
	public JSONObject doLoginCheck(Login login);
	
	public JSONObject saveQueries(Queries queries);

}
