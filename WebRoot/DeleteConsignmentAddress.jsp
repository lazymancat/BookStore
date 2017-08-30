<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.ssh.model.Customer"%>
<%@ page language="java" import="com.opensymphony.xwork2.ActionContext"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>删除收货地址</title>
  	<script type="text/javascript" src="js/jump.js?version=1.0.3"></script>
    <script>
	<!--
		function getInfo(){
			var info = "<%=(String)ActionContext.getContext().getSession().get("info")%>";

			if(info != "null"){
				alert(info);
			}
			<%ActionContext.getContext().getSession().put("info", null);%>
			location.href = "<%=(String)ActionContext.getContext().getSession().get("preLocation")%>";
		}
		
		window.onpageshow=getInfo;
	-->
	</script>
  </head>
  
  <body>
  </body>
</html>
