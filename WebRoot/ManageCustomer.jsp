<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>用户管理</title>
  	<link rel="stylesheet" type="text/css" href="css/customer-manage.css?version=1.0.1">
  	<script type="text/javascript" src="js/jump.js?version=1.0.3"></script>
  </head>
  	
  <body>
  	<div id="fixeddiv-gotop">
  		<a href="#">返回顶部</a>
  		<hr>
  		<a href="management_Main.jsp">回到首页</a>
  	</div>
  	
  	<center>
  		<div id="manageCuspanel">
		  	<br><h2>用户管理</h2>
		  	<form method="post" action="jumpToManageCustomer">
		  		<input type="text" name="nameKeyWord" value="输入想查找的用户名关键字..." onfocus="this.value=''"/>
		  		<input type="submit" value="查找"/>
		  	</form>
		  	<br>
		  	<table cellspacing="0" id="Custable">
	   			<tr id="Custable-thead">
	   				<td class="Custable-td-name">用户名</td>
	   				<td class="Custable-td-pwd">密码</td>
	   				<td class="Custable-td-email">电子邮箱</td>
	   				<td class="Custable-td-mobile">手机</td>
	   				<td class="Custable-td-handle">操作</td>
	   			</tr>
	   			
	   			<s:iterator value="cusList" var="cus">
	   				<tr class="Custable-trow">
	   					<td class="Custable-td-name"><s:property value="#cus.regName"/></td>
	   					<td class="Custable-td-pwd"><s:property value="#cus.password"/></td>
	   					<td class="Custable-td-email"><s:property value="#cus.email"/></td>
	   					<td class="Custable-td-mobile"><s:property value="#cus.mobile"/></td>
	   					<td class="Custable-td-handle">
	   						<a href="#" onclick="javascript:jumpToReviseCustomer('${cus.id}')">修改</a>
	   						&nbsp;
	   						<a href="#" onclick="javascript:jumpToDeleteCustomer('${cus.id}')">删除</a>
	   					</td>
	   				</tr>
	   			</s:iterator>
	   			
	   			<c:if test="${cusList.size()==0}">
	   				<tr id="Custable-tfoot">
	   					<td colspan="5">未查找到相应的数据</td>
	   			</c:if>
	   		</table>
	   		<br><br>
	   	</div>
	 </center>
  </body>
</html>
