package com.verizon.vzforum.dao;

import com.verizon.vzforum.model.Login;
import com.verizon.vzforum.model.Queries;

public interface LoginDao {

	public String doLoginCheck(Login login);
	
	public String saveQueries(Queries queries) throws Exception;
}
