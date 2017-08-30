<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户注册</title>
    <link rel="stylesheet" type="text/css" href="css/customer-statuscontrol.css?version=1.0.0">
  	<script type="text/javascript" src="js/jump.js?version=1.0.3"></script>
  </head>
  
  <body>
    <center>
    	<div id="registerpanel">
    		<h2>网上书店用户注册</h2><br>
			<s:form method="post" action="register">
				<s:textfield name="customer.regName" label="用户名"/>
				<s:password name="customer.password" label="密码"/>
				<s:password name="passwordConfirm" label="确认密码"/>
				<s:textfield name="customer.email" label="邮箱"/>
				<s:textfield name="customer.mobile" label="手机"/>
				<s:hidden name="customer.flag" value="0"/>
				<s:submit value="注册"/><s:reset value="重置"/>
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
