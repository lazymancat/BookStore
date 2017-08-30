<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">	
    
    <title>新品推荐</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="css/normal.css">
    <!-- 如果要使用Bootstrap的js插件，必须先调入jQuery -->
	<script type="text/javascript" src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>  
    <!-- 包括所有bootstrap的js插件或者可以根据需要使用的js插件调用　-->
	<script type="text/javascript" src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script> 
    <!-- Bootstrap -->
	<link rel="stylesheet" href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css"/>  
    
    <!-- 自己创建的js和css -->
	<link rel="stylesheet" type="text/css" href="css/nb-style.css?version=1.0.0">
	<script type="text/javascript" src="js/hp.js?version=1.0.2"></script>
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<div style="width:1300px; margin:0 auto;">
		<a href="HomePage.jsp"><div class="back-img"><img style="height:61px;width:88px;" src="img/other/back.png"></div></a>
	  	<h1 style="text-align:center;">图书分类</h1>
	  	<hr>
		<div class="book-list">
			
			<ul class="all-book">
				<s:iterator value="books" status="st" var="book">
			    	<li class="book-decorate">
			    		 <div class="book-img-decorate">
			    		 	<a href="jumpToBookInfo?bookId=<s:property value="id"/>"><img src="img/books/<s:property value="#book.image"/>" style="height:218px; width:218px; "></a>
			    		 </div>
			    		 
			    		 <div class="book-introduction">
				    		 <a href="jumpToBookInfo?bookId=<s:property value="id"/>"><div class="book-title-decorate"><s:property value="#book.name"/></div></a>
				    		 <div class="book-author-decorate">作者：<s:property value="#book.author"/></div>
				    		 <div class="book-publisher-decorate">出版社：${book.publisher }</div>
				    		 <div class="book-price-decorate">￥${book.price}</div>
			    		 </div>
			    		 
			    		 <div class="book-shop">
							<table style="margin:auto">
								<tr>
									<td><p style="font-size:24px; font-weight:300; display:inline">购买数量：</p></td>
									<td><button id="reducebtn" onclick="reduce('number')">-</button></td>
									<td><textarea id="number" rows="1"  onkeyup="this.value = check(this.value)">1</textarea></td>
									<td><button id="addbtn" onclick="add('number')">+</button></td>
								</tr>
							</table>
							<div style="margin-left:100px;">
								<a href="javascript:jumpToAddShopping(<s:property value="id"/>)"><img src="img/bookinfo/cart.png"/></a>
							</div>
			    		</div>
			    		
			    	</li>			
				</s:iterator>		
			</ul>	
		</div>
		<div class="buttom-list">
	
			<a href="newBook?pageNo=${currentPage-1}&bookType=${bookType}">
				<div class="left-button">
					<span class="icon-arrow-left2"></span>
				</div>
			</a>
	
			<a href="newBook?pageNo=${currentPage+1}&bookType=${bookType}">
				<div class="right-button">
					<span class="icon-arrow-right2"></span>
				</div>
			</a>
			</a>
		</div>
	</div>
  <body>
</html>
