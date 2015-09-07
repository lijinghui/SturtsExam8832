package com.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.hand.util.ConnectionFactory;
import com.mysql.jdbc.ResultSetMetaData;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GetCusAction extends ActionSupport {

	public void getJson() throws SQLException {
		Connection conn = ConnectionFactory.getInstance().makeConnextion();
		JsonArray array = new JsonArray();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"select a.first_name ,a.last_name,b.address,a.email,a.customer_id,a.last_update from  customer a  join address b on a.address_id=b.address_id ");
			ResultSet res = ps.executeQuery();

			while (res.next()) {
				JsonObject lan1 = new JsonObject();
				lan1.addProperty("first_name", res.getString(1));
				lan1.addProperty("last_name", res.getString(2));
				lan1.addProperty("address", res.getString(3));
				lan1.addProperty("email", res.getString(4));
				lan1.addProperty("customer_id", res.getString(5));
				lan1.addProperty("last_update", res.getString(6));
				array.add(lan1);
			}

			
			HttpServletResponse response = ServletActionContext.getResponse();
			response.getWriter().write(array.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}
}
