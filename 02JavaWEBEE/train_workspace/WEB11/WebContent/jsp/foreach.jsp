<%@ page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="zd.web.User,java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		User user = new User(1, "xzh");
		User user1 = new User(11, "xzhh");
		User user2 = new User(111, "xzhhh");
		List<User> list = new ArrayList<>();
		list.add(user);
		list.add(user1);
		list.add(user2);
		session.setAttribute("userlist", list);
	%>
	<c:forEach items="${userlist }" var="list" varStatus="status" begin="2" step="2">
	${status.index }
	${status.count }
	${list.username }<br>
	</c:forEach>
</body>
</html>