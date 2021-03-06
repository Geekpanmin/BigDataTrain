<%@ page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path = request.getContextPath();
	pageContext.setAttribute("path", path);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品管理</title>
</head>
<body>
	<center>
	
	<img src="/Users/Zd/Desktop/GitHub/BigDataTrain/02JavaWEBEE/pic/9a1fa9e4-8c66-4f05-a917-e3a41a5dd6c6.jpg"/>
		<h3>商品管理</h3>
		<h4><a href="${path}/toAddItems.shtml">添加商品</a></h4>
		<form method="post" action="${path}/itemsList.shtml">
			商品名称:<input type="text" name="itemsName" value="${vo.itemsName}" />
			最低价:<input type="text" name="minPrice" value="${vo.minPrice}" />
			最高价:<input type="text" name="maxPrice" value="${vo.maxPrice}" /> <input
				type="submit" value="搜索" />
		</form>
		<table border="1" width="800">
			<tr style="width: 800px; height: 50px">
				<td>商品编号</td>
				<td>商品名称</td>
				<td>商品价格</td>
				<td>商品图片</td>
				<td>购物车</td>
				<td>修改</td>
			</tr>
			<c:forEach items="${itemsList}" var="items">
				<tr style="width: 800px; height: 80px">
					<td>${items.itemsId}</td>
					<td>${items.itemsName}</td>
					<td>${items.price}</td>
					<td><img style="width:100px;height: 80px" src="${items.url}"></td>
					<td><a href="${path}/addCart.shtml?id=${items.itemsId}">添加到购物车</a></td>
					<td><a href="${path}/toUpdateItems.shtml?id=${items.itemsId}">编辑商品</a></td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>