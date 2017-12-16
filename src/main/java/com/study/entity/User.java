package com.study.entity;

import java.util.Date;

public class User {
	private Integer userId;

	private String account;

	private String password;

	private Date loginTime;

	public User() {
		super();
	}

	public User(Integer userId, String account, String password, Date loginTime) {
		super();
		this.userId = userId;
		this.account = account;
		this.password = password;
		this.loginTime = loginTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account == null ? null : account.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
}