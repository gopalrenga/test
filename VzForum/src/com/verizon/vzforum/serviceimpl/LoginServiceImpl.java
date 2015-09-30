package com.verizon.vzforum.serviceimpl;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.verizon.vzforum.dao.LoginDao;
import com.verizon.vzforum.model.Login;
import com.verizon.vzforum.model.Queries;
import com.verizon.vzforum.service.LoginService;
import com.verizon.vzforum.vo.BaseMessage;
import com.verizon.vzforum.vo.LoginVO;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao loginDao;

	@Override
	public JSONObject doLoginCheck(Login login) {

		Gson gson = new Gson();
		LoginVO loginvo = new LoginVO();
		BaseMessage baseMessage = new BaseMessage();
		String status = loginDao.doLoginCheck(login);
		baseMessage.setSuccessCode("00");
		baseMessage.setSuccessMsg("Success");
		loginvo.setLoginStatus(status);
		loginvo.setMessages(baseMessage);
		gson.toJson(loginvo);
		
		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(gson.toJson(loginvo));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return jsonObject;
	}

	@Override
	public JSONObject saveQueries(Queries queries) {
		Gson gson = new Gson();
		LoginVO loginvo = new LoginVO();
		BaseMessage baseMessage = new BaseMessage();
		String status= "failure";
		JSONObject jsonObject = null;
		try {
			
			
			
			
			 status = loginDao.saveQueries(queries);
			baseMessage.setSuccessCode("00");
			baseMessage.setSuccessMsg("Success");
			loginvo.setLoginStatus(status);
			loginvo.setMessages(baseMessage);
			gson.toJson(loginvo);
			
			
			try {
				jsonObject = new JSONObject(gson.toJson(loginvo));
			} catch (JSONException e) {
				baseMessage.setSuccessCode("00");
				baseMessage.setSuccessMsg("Success");
				loginvo.setLoginStatus(status);
				loginvo.setMessages(baseMessage);
				jsonObject = new JSONObject(gson.toJson(loginvo));
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

}
