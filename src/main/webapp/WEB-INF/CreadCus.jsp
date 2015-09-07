<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.hand.util.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.hand.util.Imp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>创建客户</title>
<link rel="stylesheet" href="js/bootstrap.min.css">
</head>
<body>
	<nav class=" navbar navbar-inverse  " role="navigation">
	<div class="container">
		<div class="navbar-header">
			<a href="" class="navbar-brand">1924 8322</a>
		</div>
		<div id="navber " class="collapse navbar-collapse navbar-right">
			<a class="btn btn-info" style="margin-top: 10px">退出</a>
		</div>
	</div>
	</nav>

	<div class="container ">
		<div class="col-md-4">
			<a class="btn btn-block" style="border: 1px solid #eee">Customer</a>
			<a class="btn btn-block" style="border: 1px solid #eee">film</a> <a
				class="btn btn-block" style="border: 1px solid #eee">Customer</a> <a
				class="btn btn-block" style="border: 1px solid #eee">film</a> <a
				class="btn btn-block" style="border: 1px solid #eee">Customer</a> <a
				class="btn btn-block" style="border: 1px solid #eee">film</a>
		</div>
		<div class="col-md-8" id="ajaxget" style="height: 400px;">
			<div>
				<h1>创建Customer</h1>


			</div>
			<form action="<%=request.getContextPath()%>/add" method="post">
				<div style="background-color: #fff">基本信息</div>
				<div class="row">
					<div class="col-md-2 col-md-offset-2" style="margin-top: 30px">
						first name<strong style="color: red">*</strong>
					</div>
					<div class="col-md-6" style="margin-top: 30px">
						<input type="text" name="fn" />
					</div>
				</div>
				<div class="row">
					<div class="col-md-2 col-md-offset-2" style="margin-top: 30px">
						last name<strong style="color: red">*</strong>
					</div>
					<div class="col-md-5" style="margin-top: 30px">
						<input type="text" name="ln" />
					</div>
				</div>
				<div class="row">
					<div class="col-md-2 col-md-offset-2" style="margin-top: 30px">email</div>
					<div class="col-md-5" style="margin-top: 30px">
						<input type="text" name="em" />
					</div>
				</div>
				<div class="row">
					<div class="col-md-2 col-md-offset-2" style="margin-top: 30px">
						address <strong style="color: red">*</strong>
					</div>
					<div class="col-md-5" style="margin-top: 30px">
						<select name="address_id">
							<%
								Connection conn = ConnectionFactory.getInstance().makeConnextion();
								Imp imp = new Imp();
								ResultSet rs = imp.getAllLan(conn);
								while (rs.next()) {
							%>

							<option value="<%=rs.getString(2)%>"><%=rs.getString(1)%></option>

							<%
								}
							%>
						</select>
					</div>
				</div>
				<div class="row" style="margin-top: 20px">
					<input class="btn btn-info col-md-2 col-md-offset-2"
						style="margin-top: 5px" value="新建" type="submit"> <input
						class="btn btn-default col-md-2" style="margin-top: 5px"
						value="取消" type="reset">
				</div>
			</form>
		</div>
	</div>
</body>
</html>