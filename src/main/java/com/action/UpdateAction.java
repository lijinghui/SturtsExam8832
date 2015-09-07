package com.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.hand.util.ConnectionFactory;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateAction extends ActionSupport {

	private String fn, ln, em, id,address_id;

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

	public String getAddress_id() {
		return address_id;
	}

	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}

	public String update() throws Exception {
		Connection conn = ConnectionFactory.getInstance().makeConnextion();
		String upSql = "UPDATE customer SET first_name = ?,last_name=?,email=?,address_id=? WHERE customer_id=?";
		System.out.println(address_id);
		System.out.println(upSql);
		try {
			PreparedStatement ps = conn.prepareStatement(upSql);
			ps.setString(1, fn);
			ps.setString(2, ln);
			ps.setString(3, em);
			ps.setString(4, address_id);
			ps.setString(5, id);
			System.out.println(ps.toString());
			ps.execute();
			return SUCCESS;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return SUCCESS;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
