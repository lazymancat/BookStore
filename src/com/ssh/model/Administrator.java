package com.ssh.model;

public class Administrator {
	private int id; //管理员编号
	private String name;  //管理员名称
	private String password;  //管理员密码
	
	public Administrator(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
