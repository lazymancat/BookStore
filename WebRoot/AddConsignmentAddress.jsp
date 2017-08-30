<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.ssh.model.ConsignmentAddress"%>
<%@ page language="java" import="com.opensymphony.xwork2.ActionContext"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加收货地址</title>
    <link rel="stylesheet" type="text/css" href="css/customer-handle.css?version=1.0.1">
    <script type="text/javascript" src="js/jump.js?version=1.0.3"></script>
    <script>
	<!--
		function getInfo(){
			var info = "<%=(String)ActionContext.getContext().getSession().get("info")%>";

			if(info != "null"){
				alert(info);
			}
			<%ActionContext.getContext().getSession().put("info", null);%>
		}
		window.onpageshow=getInfo;
	-->
	</script>
  </head>
  
  <body>
    <center>
    	<div id="addCApanel">
	    	<h2>添加收货地址</h2><br><br>
			<s:form method="post" action="addConsignmentAddress">
				<s:textfield name="consignmentAddress.consignmentName" label="收货人"/>
				<s:textfield name="consignmentAddress.address" label="详细地址"/>
				<s:textfield name="consignmentAddress.postCode" label="邮政编码"/>
				<s:textfield name="consignmentAddress.phone" label="联系电话"/>
				<s:hidden name="consignmentAddress.flag" value="0"/>
				<s:submit value="提交"/><s:reset value="重置"/>
			</s:form>
			<br><br>
		</div>
		<br><br>
		<a class="btn-back" href="javascript:jumpPreLocation('<%=request.getSession().getAttribute("preLocation")%>')">返回先前页面</a>
		<br>
		<a class="btn-back" href="HomePage.jsp">返回首页</a>
    </center>
  </body>
</html>
