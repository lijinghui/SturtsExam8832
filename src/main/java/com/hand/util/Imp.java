package com.hand.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Imp {
	public ResultSet getAllLan(Connection conn) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("select address,address_id from address;");

		return ps.executeQuery();
	}
}
