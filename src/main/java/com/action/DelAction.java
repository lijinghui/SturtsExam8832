package com.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hand.util.ConnectionFactory;
import com.opensymphony.xwork2.ActionSupport;

public class DelAction extends ActionSupport{

	public void del(){
		Connection conn = ConnectionFactory.getInstance().makeConnextion();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		System.out.println(request.getParameter("id"));
		int a = Integer.parseInt(request.getParameter("id").toString());
		System.out.println("del----------");
		String sql = "delete from payment where customer_id=?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = conn.prepareCall(sql);
			preparedStatement.setInt(1, a);
			preparedStatement.execute();
			sql = "delete from rental where customer_id=?";
			preparedStatement = conn.prepareCall(sql);
			preparedStatement.setInt(1, a);
			preparedStatement.execute();
			sql = "delete from customer where customer_id=?";
			preparedStatement = conn.prepareCall(sql);
			preparedStatement.setInt(1, a);
			preparedStatement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("INFO-->删除出错");
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
