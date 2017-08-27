<%@ page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="zd.web.User,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String str = "zd";
		User user = new User(1, "xzh");
		User user1 = new User(11, "xzhh");
		User user2 = new User(111, "xzhhh");

		pageContext.setAttribute("user", user);
		pageContext.setAttribute("pageStr", str);
		request.setAttribute("requestStr", str);
		session.setAttribute("sessionStr", str);
		application.setAttribute("applicationStr", str);
	%>
	${user.username}
	<br> ${pageStr}
	<br> ${requestStr}
	<br> ${sessionScope.sessionStr}
	<br> ${applicationScope.applicationStr}
	<br>
	<h1>集合list：</h1>
	<%
		List<User> list = new ArrayList<>();
		list.add(user);
		list.add(user1);
		list.add(user2);
		request.setAttribute("userList", list);
		session.setAttribute("userlist", list);
	%>
	${userList[0].username}
	<br> ${sessionScope.userlist[2]}
	<h1>map:</h1>
	<%
	Map<String,Object> map=new HashMap<>();
	map.put("name","zd");
	map.put("user",user);
	map.put("list",list);
	session.setAttribute("map", map);
	%>
	${map.name}
	${map.user.id}
	${map.list[0].username}
	${map["name"]}
</body>
</html>