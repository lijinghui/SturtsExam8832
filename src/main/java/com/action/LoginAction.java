package com.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.struts2.ServletActionContext;

import com.hand.util.ConnectionFactory;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private String username;
	private String password;

	@Override
	public String execute() throws Exception {

		Connection conn = ConnectionFactory.getInstance().makeConnextion();
		try{
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM customer WHERE first_name = ? AND last_name = ?");
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs = 	ps.executeQuery();
		System.out.println(username+password);
		while(rs.next()){
			ServletActionContext.getRequest().getSession().setAttribute("username", username);
			return SUCCESS;
		}
		
		}catch(Exception e){
			e.printStackTrace();
			return ERROR;
		}finally {
			conn.close();
		}
		return ERROR;
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
