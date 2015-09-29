package com.verizon.vzforum.vo;

public class LoginVO {
	private String loginStatus;
	private BaseMessage messages;

	public BaseMessage getMessages() {
		return messages;
	}

	public void setMessages(BaseMessage messages) {
		this.messages = messages;
	}

	public String getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

}
