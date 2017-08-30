<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.ssh.model.Customer"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>登录成功</title>
    <link rel="stylesheet" type="text/css" href="css/customer-statuscontrol.css?version=1.0.1">
  	<script type="text/javascript" src="js/jump.js?version=1.0.3"></script>
  </head>
  
  <body>
  	<center>
		<div id="loginsuccesspanel">
			<div id="loginsuccess">
				<p>登录成功</p>
				<br>
				<p>欢迎您，<%=((Customer)request.getSession().getAttribute("theCustomer")).getRegName() %></p>
				<br>
			</div>
		</div>
		<div style="display:block; width:100%; height:20%"></div>
		<a class="btn-back" href="javascript:jumpPreLocation('<%=request.getSession().getAttribute("preLocation")%>')">返回先前页面</a>
		<br>
		<a class="btn-back" href="HomePage.jsp">返回首页</a>
	</center>
  </body>
</html>
