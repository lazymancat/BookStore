<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" import="com.ssh.model.Administrator"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>后台系统登录</title>
	<link rel="stylesheet" type="text/css" href="css/normal.css">
	<link rel="stylesheet" type="text/css" href="css/ma-style.css?version=1.0.2">
	<script>
	<!--
		function checkADlogin(){
			var ad = "<%=(Administrator)ActionContext.getContext().getSession().get("theAdministrator")%>";
		
			if(ad != "null"){
				location.href="http://localhost:8080/BookStore/management_Main.jsp";
			}
		
		}
		window.onpageshow=checkADlogin;
	-->
	</script>
    <!-- jQuery -->
	<script type="text/javascript" src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>  
</head>

<body background="img/manage/background.jpg">
	<div style="margin :0 auto; width:1300px; height:100%; ">
		<div class="title-word">
			<img src="img/manage/title-word.png" style="width:800px;">
		</div>
		<div class="login">
			<center>
				<br><br>
				<s:form method="post" action="administratorLogin">
					<s:textfield name="ad.name" label="用户名"/><br>
					<s:password name="ad.password" label="密码"/>
					<s:submit value="登录 " />
					<s:reset value="重置 " />
				</s:form>
				<br><br>
			</center>
		</div>
	</div>
</body>
</html>