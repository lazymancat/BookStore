<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>用户登录</title>
  	<link rel="stylesheet" type="text/css" href="css/customer-statuscontrol.css?version=1.0.0">
  	<script type="text/javascript" src="js/jump.js?version=1.0.3"></script>
  </head>
  
  <body>
  	<center>
  		<div id="loginpanel">
			<br><h2>网上书店用户登录</h2><br><br>
			<s:form method="post" action="login">
				<s:textfield name="customer.regName" label="用户名"/>
				<s:password name="customer.password" label="密码"/>
				<s:submit value="登录"/><s:reset value="重置"/>
			</s:form>
			<br>
		</div>
		<br><br><br>
		<a class="btn-back" href="javascript:jumpPreLocation('<%=request.getSession().getAttribute("preLocation")%>')">返回先前页面</a>
		<br>
		<a class="btn-back" href="HomePage.jsp">返回首页</a>
	</center>
  </body>
</html>
