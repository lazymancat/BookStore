<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <link rel="stylesheet" type="text/css" href="./css/shopping/default_setting.css?version=3"/>
  <link rel="stylesheet" type="text/css" href="./css/shopping/shopping.css?version=2"/>
<title>加入购物车成功</title>
</head>
<body>
	<div class="center">
	加入购物车成功,点击
	<a href="http://localhost:8080/BookStore/jumpToBookInfo?bookId=${bookId}">返回先前页面</a>
	</div>
</body>
</html>