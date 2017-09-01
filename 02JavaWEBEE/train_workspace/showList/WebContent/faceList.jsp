<%@ page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   ${list1 }
	<c:forEach items="${list1}" var="equip">
	   ${equip.equipmentNo} 
		<div style="float: left; width: 12%; margin: 10px; text-align: center">
			<img src="./img/${equip.equipmentNo}.jpg" width="100%" /> 
			<a href="#">设备名：${equip.equipmentName}</a><br>
			<a href="#">负责人：${equip.person}</a>
		</div>
	</c:forEach>
</body>
</html>