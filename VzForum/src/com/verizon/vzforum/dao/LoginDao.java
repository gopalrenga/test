package com.verizon.vzforum.dao;

import com.verizon.vzforum.model.Login;

public interface LoginDao {

	public String doLoginCheck(Login login);
}
