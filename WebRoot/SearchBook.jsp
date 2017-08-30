<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <!-- 自己创建的js和css -->
	<link rel="stylesheet" type="text/css" href="css/nb-style.css?version=1.0.0">
	<script type="text/javascript" src="js/hp.js?version=1.0.1"></script>
    
    <title>搜索结果</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<div style="width:1300px; margin:0 auto;">
		<a href="HomePage.jsp"><div class="back-img"><img style="height:61px;width:88px;" src="img/other/back.png"></div></a>
  		<h1 style="text-align:center;">搜索结果</h1>
	  	<hr>
		<div class="book-list">
			
			<ul class="all-book">
				<s:iterator value="searchBooks" status="st" var="searchBook">
			    	<li class="book-decorate">
			    		 <div class="book-img-decorate">
			    		 	<a href="jumpToBookInfo?bookId=<s:property value="id"/>"><img src="img/books/<s:property value="#searchBook.image"/>" style="height:218px; width:218px; "></a>
			    		 </div>
			    		 
			    		 <div class="book-introduction">
				    		 <a href="jumpToBookInfo?bookId=<s:property value="id"/>"><div class="book-title-decorate"><s:property value="#searchBook.name"/></div></a>
				    		 <div class="book-author-decorate">作者：<s:property value="#searchBook.author"/></div>
				    		 <div class="book-publisher-decorate">出版社：${searchBook.publisher }</div>
				    		 <div class="book-price-decorate">￥${searchBook.price}</div>
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
								<a href="javascript:jumpToAddShopping(<s:property value="id"/>)"><img  src="img/bookinfo/cart.png"/></a>
							</div>
			    		</div>
			    		
			    	</li>			
				</s:iterator>		
			</ul>	
		</div>
		<div class="buttom-list">
			<a href="homePageSearch?pageNo=${currentPage-1}&bookName=${bookName}">
				<div class="left-button">
					<span class="icon-arrow-left2"></span>
				</div>
			</a>
	
			<a href="homePageSearch?pageNo=${currentPage+1}&bookName=${bookName}">
				<div class="right-button">
					<span class="icon-arrow-right2"></span>
				</div>
			</a>
		</div>
	</div>
  </body>
</html>
