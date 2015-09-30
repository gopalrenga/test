package com.verizon.vzforum.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.verizon.vzforum.dao.LoginDao;
import com.verizon.vzforum.model.Login;
import com.verizon.vzforum.model.Queries;

@Repository
public class LoginDaoImpl implements LoginDao {
	
@Autowired
private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}


	@Override
	public String doLoginCheck(Login login) {
		String status= "failure";
		
		String sql = "Select count(1) from appuser " +
				"where username =? and password = ?";
		Connection conn = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		System.out.println("login.getUserName()"+login.getUserName());
		System.out.println("login.getPassword()"+login.getPassword());
		try {
			conn = dataSource.getConnection();

			 ps = conn.prepareStatement(sql);
			ps.setString(1, login.getUserName());
			ps.setString(2,login.getPassword());
			
		  rs =	ps.executeQuery();
		  
		  while(rs.next()){
			  status = rs.getString(1).equals("1")?"success":"failure"; 
		  }
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
			
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {}
				
			}
		}
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {}
			
		}

		return status;
	}


	@Override
	public String saveQueries(Queries queries) throws Exception {
		String status= "failure";
		
		String sql = "insert into forumqueries( question, technologyid,createdby,createdon)values " +
				"(?,?,?,?)";
		Connection conn = null;
		PreparedStatement ps=null;
		
		try {
			conn = dataSource.getConnection();

			 ps = conn.prepareStatement(sql);
			ps.setString(1, queries.getQuestion());
			ps.setInt(2,Integer.parseInt(queries.getTechnologyId()));
			ps.setString(3,queries.getCreatedBy());
			ps.setString(4,queries.getCreatedOn());
			
		 int flag  = ps.executeUpdate();
		  
		 status= (flag==0)?"failure":"success";
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
			
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {}
				
			}
		}
		

		return status;
	}

}
