<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.ssh.model.Customer"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改资料</title>
    <link rel="stylesheet" type="text/css" href="css/customer-handle.css?version=1.0.0">
  	<script type="text/javascript" src="js/jump.js?version=1.0.3"></script>
  </head>
 
  <body>
  	<center>
  		<div id="revisepwdpanel">
	  		<h2>修改密码</h2><br>
	  		<s:form method="post" action="revisePassword">
	  			<s:password name="oldPassword" label="旧密码"/>
	  			<s:password name="newPassword" label="新密码" />
	  			<s:password name="newPasswordConfirm" label="重复新密码"/>
	  			<s:submit value="提交"/>
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
