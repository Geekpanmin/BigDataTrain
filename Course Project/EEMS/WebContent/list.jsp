<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
   <script type="text/javascript">
   	function search(){
   	     var cp=document.getElementById("cp").value;
   	     location.href="equipment?op=list&currentPage="+cp;
   	}
   </script>
  </head>
  
  <body>
     <%
         request.setCharacterEncoding("utf-8");
         String NoReturn=(String)request.getAttribute("NoReturn");
         
      %>
    <br/>
    <center><marquee width="80%" direction="left" bgcolor="#ccc"><%=NoReturn %></marquee></center>
    <br/>
    <table width="80%" align="center">
      <tr>
      	<td>设备编号</td>
      	<td>设备名称</td>
      	<td>领用人</td>
      	<td>设备类型</td>
      	<td>设备状态</td>
      	<td>报废状态</td>
      	<td>操作</td>
      </tr>
<!-- 		${status.index} 输出行号，从0开始。 -->
<!-- 	    ${status.count} 输出行号，从1开始。 -->
<!-- 		${status.current} 当前这次迭代的（集合中的）项 -->
<!-- 	    ${status.first}判断当前项是否为集合中的第一项，返回值为true或false  -->
<!-- 	    ${status.last}判断当前项是否为集合中的最后一项，返回值为true或false -->
	    <c:forEach items="${list }" var="bean" varStatus="status">
        <tr <c:if test="${status.index%2==0 }">style="background:#eee"</c:if>>
      	<td>${bean.equipmentNo }</td>
      	<td>${bean.equipmentName }</td>
      	<td>${bean.person }</td>
      	
      	<td>
      	  <c:forEach items="${typelist }" var="equipmentType" >
      		<c:if test="${equipmentType.id==bean.equipmentTypeId }">
      		     ${equipmentType.type}
      		</c:if>
      	  </c:forEach>
      	</td>
      	
      	<td>
      	   <c:forEach items="${statuslist }" var="equipmentStatus" >
      		<c:if test="${equipmentStatus.id==bean.equipmentStatusId }">
      		     ${equipmentStatus.value}
      		</c:if>
      	   </c:forEach>
      	</td>
      	<td>
      	  <c:forEach items="${slist }" var="isScrap" >
      		<c:if test="${isScrap.id==bean.isScrapId }">
      		     ${isScrap.value}
      		</c:if>
      	  </c:forEach>
        </td>
      	<td>
      		<a href="equipment?op=getById&id=${bean.equipmentNo }" <c:if test="${bean.isScrapId==2 }" >style="color:#ccc;" onclick="javascript:return false;"</c:if> >修改</a>
      		<a href="equipment?op=delete&id=${bean.equipmentNo }">删除</a>
      	</td>
      </tr>
      </c:forEach>
      <tr>
        <td colspan="1" align="center">
            <!-- <a  href="equipment?op=toAdd">添加</a> -->
        </td>
       	<td colspan="6" align="right">
       	    <a href="equipment?op=list&currentPage=1">首页</a>
       	    <a href="equipment?op=list&currentPage=${page.totalPage }">尾页</a>
       		<a href="equipment?op=list&currentPage=${page.currentPage-1 }" <c:if test="${page.currentPage==1 }" >style="color:#ccc;" onclick="javascript:return false;"</c:if>>上一页</a>
       		<c:forEach begin="1" step="1" end="${page.totalPage }" var="pg">
       			<a href="equipment?op=list&currentPage=${pg }">${pg }</a>
       		</c:forEach>
       		<a href="equipment?op=list&currentPage=${page.currentPage+1 }" <c:if test="${page.currentPage==page.totalPage }">style="color:#ccc;" onclick="javascript:return false;"</c:if>>下一页</a>
       		<span>共${page.totalPage }页</span>
       		到第<input id="cp" type="text" style="width: 20px" maxlength="4">页 <input type="button" value="确定" onclick="search();">
       	</td>
      </tr>
    </table>
  </body>
</html>
