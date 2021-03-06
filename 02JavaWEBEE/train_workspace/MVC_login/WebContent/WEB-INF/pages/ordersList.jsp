<%@ page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path = request.getContextPath();
	pageContext.setAttribute("path", path);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h3>订单管理</h3>
		<form method="post" action="${path}/ordersList.shtml">
			订单号:<input type="text" name="ordersId" value="${vo.ordersId}" />
			商品名称:<input type="text" name="itemsName" value="${vo.itemsName}" />
			商品价格:<input type="text" name="price" value="${vo.price}" /> <input
				type="submit" value="搜索" />
		</form>
		<table border="1" width="800">
			<tr style="width: 800px; height: 100px">
				<td>订单编号</td>
				<td>商品件数</td>
				<td>状态</td>
				<td>商品明细</td>
				<td>收货人</td>
			</tr>
			<c:forEach items="${ordersList}" var="orders">
				<tr>
					<td>${orders.ordersId}</td>
					<td>${orders.count}</td>
					<td><c:if test="${orders.status==0}">
							<span style="color:red">未支付</span>
						</c:if> <c:if test="${orders.status==1}">
							<span style="color: red">已支付</span>
						</c:if></td>
					<td>
						<table>
							<c:forEach items="${orders.itemss}" var="items">
								<tr>
									<td>${items.itemsName}</td>
									<td>${items.price}</td>
								</tr>
							</c:forEach>

						</table>
					</td>
					<td>${orders.post.postName}</td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>