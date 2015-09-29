package com.verizon.vzforum.daoimpl;

import javax.sql.DataSource;

import com.verizon.vzforum.dao.LoginDao;

public class LoginDaoImpl implements LoginDao {
	
	
private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}


	@Override
	public boolean doLoginCheck() {
		// TODO Auto-generated method stub
		return false;
	}

}
