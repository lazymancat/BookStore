<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.ssh.model.Customer"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	response.setHeader("Cache-Control","no-store"); 
	response.setHeader("Pragrma","no-cache"); 
	response.setDateHeader("Expires",0); 
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	  <title>注销成功</title>
	  <link rel="stylesheet" type="text/css" href="css/customer-statuscontrol.css?version=1.0.1">
	  <script type="text/javascript" src="js/jump.js?version=1.0.3"></script>
	</head>
	
	<body>
		<center>
			<div id="logoffsuccesspanel">
				<div id="logoffsuccess">
					<br><br>
					<p>注销成功</p>
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
