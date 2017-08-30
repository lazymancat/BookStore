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
	<title>后台管理</title>
	<link rel="stylesheet" type="text/css" href="css/mm-style.css?version=1.1.0">
	<script type="text/javascript" src="js/jump.js?version=1.0.3"></script>
	<script>
	<!--
		function checkADlogin(){
			var ad = "<%=(Administrator)ActionContext.getContext().getSession().get("theAdministrator")%>";
		
			if(ad == "null"){
				location.href="http://localhost:8080/BookStore/management_Login.jsp";
			}
		
		}
		window.onpageshow=checkADlogin;
	-->
	</script>
</head>
<body>
	<div style="margin :0 auto; width:1300px; height:100%;">
		<div  class="main_head">
			<img src="img/manage/head.png">
		</div>
		<div class="main_title">后&nbsp台&nbsp管&nbsp理</div>
		<div class="main_subhead">BACKGROUND MANAGEMENT</div>

		<div class="main_list">
			<ul>
				<li class="main_userManage">
					<a href="jumpToManageCustomer" title="用户管理">
						<div class="main_list_img">
							<img style="height:100px; width:100px" src="img/manage/userManage.png">
						</div>
						<strong class="main_list_word">
							用&nbsp户
						</strong>
						<span class="main_list_subword">管理用户信息</span>
					</a>
				</li>
				<li class="main_bookManage">
					<a href="manageBook.action" title="书籍管理">
						<div class="main_list_img">
							<img style="height:100px; width:100px" src="img/manage/bookManage.png">
						</div>
						<strong class="main_list_word">
							书&nbsp籍
						</strong>
						<span class="main_list_subword">管理书籍信息</span>
					</a>
				</li>
				<li class="main_typeManage">
					<a href="BookTypeManagement.jsp" title="分类管理">
						<div class="main_list_img">
							<img style="height:100px; width:100px" src="img/manage/typeManage.png">
						</div>
						<strong class="main_list_word">
							分&nbsp类
						</strong>
						<span class="main_list_subword">管理分类信息</span>
					</a>
				</li>
				
				<li class="main_shopManage">
					<a href="OrderManageAction" title="订单管理">
						<div class="main_list_img">
							<img style="height:100px; width:100px" src="img/manage/shopManage.png">
						</div>
						<strong class="main_list_word">
							订&nbsp单
						</strong>
						<span class="main_list_subword">管理订单信息</span>
					</a>
				</li>
				
				<li class="main_countManage">
					<a href="BookStatisticsAction" title="统计管理">
						<div class="main_list_img">
							<img style="height:100px; width:100px" src="img/manage/countManage.png">
						</div>
						<strong class="main_list_word">
							统&nbsp计
						</strong>
						<span class="main_list_subword">管理统计信息</span>
					</a>
				</li>
			</ul>
		</div>
		<a class="btn-back" href="javascript:jumpToAdministratorLogoff()">安全退出</a>
	</div>
</body>
</html>