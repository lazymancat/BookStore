<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <title>图书分类管理</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!-- 导入自己的css -->
	<link rel="stylesheet" type="text/css" href="css/btm-style.css?version=1.0.0">
    <script type="text/javascript" src="js/btm.js?version=1.0.0" charset="UTF-8"></script>
  </head>
  
  <body>
  		<!-- 整体轮廓 -->
		<div class="bookTypeManagement">
			<!-- 退出图片 -->
			<div class="bookTypeManagement_backImg" title="退出">
				<a href="management_Main.jsp"><img style="height:86px; width:78px" src="img/manage/backToManagement.png"></a>
			</div>
			<!-- 顶部图片 -->
			<div class="bookTypeManagement_headImg">
				<img style="height:128px; width:88px" src="img/manage/bookTypeManagement.png">
			</div>
			<!-- 顶部标题 -->
			<div class="bookTypeManagement_headTitle">
				<strong>图&nbsp书&nbsp分&nbsp类</strong>
			</div>
			<!-- 新增分类 -->
			<div class="bookTypeManagement_add">
				<div class="bookTypeManagement_add_title">新添分类</div>
				<div class="bookTypeManagement_add_content">
					<s:form action="addBookType" method="POST" theme="simple" enctype ="multipart/form-data">
						分类名称<input type="text" name="bookType.typeName">
								<s:hidden name="bookType.flag" value="0"/>
								<input type="submit" value="提交">
								<input type="reset" value="重置">
					</s:form>		
					<span class="errorMessage"><s:fielderror><s:param>errorTypeName</s:param></s:fielderror></span>
				</div>
			</div>
			<!-- 删除分类 -->
			<div class="bookTypeManagement_delete">
				<div class="bookTypeManagement_delete_title">删除分类</div>
				<div class="bookTypeManagement_delete_content">
					<s:action name="getAllBookType" executeResult="false"></s:action>
					分类名称<select id="bookTypeId">
							<s:iterator value="#request.bookTypes">
								<option value=${ typeId}>${ typeName}</option>
							</s:iterator>
						</select>
						<a href="javascript:deleteBookType()"><button value="删除">删除</button></a>
						<input type="reset" value="重置">
				</div>
			</div>
			<!-- 修改分类 -->
			<div class="bookTypeManagement_change">
				<div class="bookTypeManagement_change_title">修改分类</div>
				<div class="bookTypeManagement_change_content">
					<s:action name="getAllBookType" executeResult="false"></s:action>
					修改前<select id="reviseTypeId">
							<s:iterator value="#request.bookTypes">
								<option value=${ typeId}>${ typeName}</option>
							</s:iterator>
						</select>
					<img class="bookTypeManagement_change_img" src="img/manage/bookTypeManagement_right_arrow.png">
					<span style="margin-left:80px;" >修改后<input style="margin-left:10px; outline:none;" type="text" id="reviseTypeName"></span>
					<a href="javascript:reviseBookType()"><button value="修改">修改</button></a>
					<input type="reset" value="重置">
				</div>
			</div>
		</div>
  </body>
</html>
