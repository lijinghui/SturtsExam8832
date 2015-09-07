package com.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;

import com.hand.util.ConnectionFactory;
import com.opensymphony.xwork2.ActionSupport;

public class AddAction extends ActionSupport {
	private String fn,ln,em,address_id;
	
	
	public String getFn() {
		return fn;
	}


	public void setFn(String fn) {
		this.fn = fn;
	}


	public String getLn() {
		return ln;
	}


	public void setLn(String ln) {
		this.ln = ln;
	}


	public String getEm() {
		return em;
	}


	public void setEm(String em) {
		this.em = em;
	}

	

	public String getAddress_id() {
		return address_id;
	}


	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}


	public String add() throws SQLException {

		Connection conn = ConnectionFactory.getInstance().makeConnextion();
		String upSql = "INSERT INTO customer(first_name,last_name,email,store_id,address_id,create_date) VALUES(?,?,?,?,?,?)";

		try {
			PreparedStatement ps = conn.prepareStatement(upSql);
			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setString(3, em);
			ps.setInt(4, 1);
			ps.setString(5, address_id);
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			String str = sdf.format(date);
			ps.setString(6,str);
			System.out.println(ps);
			ps.execute();
			return SUCCESS;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			conn.close();
		}

	
		return SUCCESS;

	}
	
	public String jump(){
		return SUCCESS;
		
	}
}
