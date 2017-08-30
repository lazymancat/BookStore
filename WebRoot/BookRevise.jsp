<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	request.setCharacterEncoding("UTF-8");	
 %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<link rel="stylesheet" type="text/css" href="css/normal.css">
	<link rel="stylesheet" type="text/css" href="css/br-style.css?version=1.0.0">
	<script type="text/javascript" src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>  
    <script type="text/javascript" src="js/br.js?version=1.0.0" charset="UTF-8"></script>
    
    <title>图书修改</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
	<div style="height:100%; width:1300px; margin:0 auto; background-color:#f2f9fd;">
	
		<s:form action="reviseBook" method="POST" theme="simple" enctype ="multipart/form-data">
		<table width="750px" align="center">
			<tr>
				<td colspan="3" class="title">图书信息修改</td>
			</tr>

			<s:iterator value="book" status="st" var="book">
				<tr style="display:none;">
					<td class="fontStyle">图书编号:</td>
					<td><input type="text" name="book.id" value="<s:property value="#book.id"/>" readonly="true">(不可修改)</td>
				</tr>
				
				<tr style="display:none;">
					<td class="fontStyle">图书图片:</td>
					<td><input type="text" name="book.image" value="<s:property value="#book.image"/>" readonly="true">(不可修改)</td>
				</tr>
				
				<tr>
					<td class="fontStyle">图书名称:</td>
					<td><input type="text" id="bookName" name="book.name" maxlength="100" onchange="checkEmpty('bookName');" value="<s:property value="#book.name"/>">
						<span id="checkbookNameInfo"></span>
  						<span name="errorMessage"><s:fielderror><s:param>errorName</s:param></s:fielderror></span>
					</td>
					
					<td rowspan="7" align="center">
						<img id="bookImage" src="img/books/<s:property value="#book.image"/>" style="height:150px; width:150px; "> 
						<s:file name ="upload" onchange="javascript:changeImage(this)"/>     
					</td>
				</tr>
				
				<tr>
					<td class="fontStyle">图书作者:</td>
					<td><input type="text" id="bookAuthor" name="book.author" onchange="checkEmpty('bookAuthor');" value="<s:property value="#book.author"/>">
						<span id="checkbookAuthorInfo"></span>
  						<span name="errorMessage"><s:fielderror><s:param>errorAuthor</s:param></s:fielderror></span>
					</td>
				</tr>
				
				<tr>
					<td class="fontStyle">图书价格:</td>
					<td><input type="text" id="bookPrice" name="book.price" onchange="this.value = checkFloat(this.value);" value="<s:property value="#book.price"/>">
						<span id="checkBookPriceInfo"></span>
  						<span name="errorMessage"><s:fielderror><s:param>errorPrice</s:param></s:fielderror></span>
					</td>
				</tr>
				
				<tr>
					<td class="fontStyle">出版社:</td>
					<td><input type="text" id="bookPublisher" name="book.publisher" onchange="checkEmpty('bookPublisher');" value="<s:property value="#book.publisher"/>">
						<span id="checkbookPublisherInfo"></span>
  						<span name="errorMessage"><s:fielderror><s:param>errorPublisher</s:param></s:fielderror></span>
					</td>
				</tr>
				
				<tr>
					<td class="fontStyle">I&nbspS&nbspB&nbspN:</td>
					<td><input type="text" id="bookISBN" name="book.isbn" onchange="checkEmpty('bookISBN');" value="<s:property value="#book.isbn"/>">
						<span id="checkbookISBNInfo"></span>
  						<span name="errorMessage"><s:fielderror><s:param>errorISBN</s:param></s:fielderror></span>
					</td>
				</tr>
				
				<tr>
					<td class="fontStyle">图书类型:</td>
					<td>
						<s:action name="getAllBookType" executeResult="false"><s:param name="number">1</s:param></s:action>
						<select id="bookType" name="book.typeId">
							<s:iterator value="#request.bookTypes">
								<option value=${ typeId} ${book.typeId == typeId ? "selected" : ""} ><s:property value="typeName"/></option>
							</s:iterator>
						</select>
					</td>
				</tr>
				
				<tr>
					<td class="fontStyle">图书页数:</td>
					<td><input type="text" id="BookPageCount" name="book.pageCount" onkeyup="this.value = check(this.value);" value="<s:property value="#book.pageCount"/>">
						<span id="checkBookPageCountInfo"></span>
  						<span name="errorMessage"><s:fielderror><s:param>errorPageCount</s:param></s:fielderror></span>
					</td>
				</tr>
				
				<tr>
					<td class="fontStyle">图书字数:</td>
					<td><input type="text" id="BookWordCount" name="book.wordCount" onkeyup="this.value = check(this.value);" value="<s:property value="#book.wordCount"/>">
						<span id="checkBookWordCountInfo"></span>
  						<span name="errorMessage"><s:fielderror><s:param>errorWordCount</s:param></s:fielderror></span>
					</td>
				</tr>
				
				<tr>
					<td class="fontStyle">库存数量:</td>
					<td><input type="text" id="BookStockStatus" name="book.stockStatus" onkeyup="this.value = check(this.value);" value="<s:property value="#book.stockStatus"/>">
					</td>
				</tr>
				
				<tr>
					<td class="fontStyle">图书介绍:</td>
					<td><textarea id="bookIntroduction" name="book.introduction" onchange="checkEmpty('bookIntroduction');" rows="6" cols="50"><s:property value="#book.introduction"/></textarea>
						<span id="checkbookIntroductionInfo"></span>
					</td>
				</tr>
			
				<s:hidden name="book.flag" value="0"/>
	
				<tr>
					<td colspan="3" align="center">	
						<s:submit value="保存" align="left"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" onclick="resetBook(<s:property value="#book.id"/>)" value="重置">重置</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" onclick="cancel()" value="取消">取消</button>
					</td>
				</tr>
			</s:iterator>
		</table>
		</s:form>
	</div>
  </body>
</html>
