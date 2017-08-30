<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.ssh.model.Customer"%>
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
    <title>管理收货地址</title>
    <link rel="stylesheet" type="text/css" href="css/customer-handle.css?version=1.0.0">
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
   	<div id="manageCApanel">
   		<center>
	   		<br><br>
	   		<h2>管理我的收货地址</h2>
	   		<br><br>
    		<table cellspacing="0" id="CAtable">
    			<tr id="CAtable-thead">
    				<td>收货人</td>
    				<td>收货地址</td>
    				<td>邮编</td>
    				<td>联系电话</td>
    				<td>操作</td>
    			</tr>
    			
    			<s:iterator value="caList" var="ca">
    				<tr class="CAtable-trow">
    					<td><s:property value="#ca.consignmentName"/></td>
    					<td><s:property value="#ca.address"/></td>
    					<td><s:property value="#ca.postCode"/></td>
    					<td><s:property value="#ca.phone"/></td>
    					<td>
    						<a href="#" onclick="javascript:jumpToReviseConsignmentAddress('${ca.id}')">修改</a>
    						&nbsp;
    						<a href="#" onclick="javascript:jumpToDeleteConsignmentAddress('${ca.id}')">删除</a>
    					</td>
    				</tr>
    			</s:iterator>
    			
    			<c:if test="${quantity < quantityLimit}">
					<tr id="CAtable-tfoot">
	    				<td> </td>
	    				<td> </td>
	    				<td> </td>
	    				<td> </td>
	    				<td>
	    					<a href="#" onclick="javascript:jumpToAddConsignmentAddress()">添加</a>
	    				</td>
    				</tr>
    			</c:if>
    		</table>
   			<br><br><br>
			<a class="btn-back" href="javascript:jumpPreLocation('<%=request.getSession().getAttribute("preLocation")%>')">返回先前页面</a>
			<br>
			<a class="btn-back" href="HomePage.jsp">返回首页</a>
			<br><br><br>
	   	</center>
   	</div>
  </body>
</html>
