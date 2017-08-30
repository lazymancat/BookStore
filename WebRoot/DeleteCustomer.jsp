<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.ssh.model.Customer"%>
<%@ page language="java" import="com.opensymphony.xwork2.ActionContext"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	response.setHeader("Cache-Control","no-store"); 
	response.setHeader("Pragrma","no-cache"); 
	response.setDateHeader("Expires",0); 
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>删除用户</title>
    <script>
	<!--
		function getInfo(){
			var info = "<%=(String)ActionContext.getContext().getSession().get("info")%>";

			if(info != "null"){
				alert(info);
			}
			<%ActionContext.getContext().getSession().put("info", null);%>
			location.href = "jumpToManageCustomer";
		}
		
		window.onpageshow=getInfo;
	-->
	</script>
  </head>
  
  <body>
  </body>
</html>
