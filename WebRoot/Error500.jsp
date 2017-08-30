<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>出错啦！</title>
    <link rel="stylesheet" type="text/css" href="css/customer-statuscontrol.css?version=1.0.1">
  	<script type="text/javascript" src="js/jump.js?version=1.0.3"></script>
  </head>
  
  <body>
  	<center>
		<div id="loginsuccesspanel">
			<div id="loginsuccess">
				<p>非法访问,请重试 (错误代码：500)</p>
				<img src="img/error/error500.jpg"/>
				<br>
				<br>
			</div>
		</div>
		<div style="display:block; width:100%; height:20%"></div>
		<a class="btn-back" href="HomePage.jsp">返回首页</a>
	</center>
  </body>
</html>
