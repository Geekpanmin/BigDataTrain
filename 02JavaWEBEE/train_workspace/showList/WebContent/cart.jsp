<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<%@ page import="java.sql.*"%>  
  
<html>  
  <head>  
    <title>我的设备车</title>  
  </head>  
  <%  
    //装载MySQL5.5的JDBC驱动  
    Class.forName("com.mysql.jdbc.Driver").newInstance();  
    //建立数据库连接  
    String url ="jdbc:mysql://localhost:3306/List?user=root&password=&useUnicode=true&characterEncoding=utf8";  
    Connection conn= DriverManager.getConnection(url);  
    //建立一个Statement对象，用于执行SQL语句  
    Statement stat = conn.createStatement();  
    //执行查询并得到查询结果  
    String sql = "select * from cart";  
    ResultSet rs = stat.executeQuery(sql);    
  %>     
  <body>  
    <h2>我的设备车</h2>  
    <hr>  
    <table border="1" width="600">  
        <tr bgcolor="#dddddd">  
            <td align="center" width="80">名称</td>   
            <td align="center">单价</td>  
            <td align="center" width="100">数量</td>  
            <td align="center" width="100">金额</td>  
            <td align="center" width="100">编辑</td> 
        </tr>  
        <%  
            String id,name,price,num,count;  
            //将查询结果集中的记录输出到页面上  
            while (rs.next()){  
                //从当前记录中读取各字段的值  
                id = rs.getString("id").trim();  
                name = rs.getString("name").trim();  
                price = rs.getString("price").trim();  
                num = rs.getString("num").trim();  
                count = rs.getString("count").trim();  
                  
                out.println("<tr>");  
                out.println("<td>"+ name +"</td>");  
                out.println("<td>"+ price +"</td>");  
                out.println("<td><input type=text value="+ num +" onChange=\"updateNum('"+id+"',this.value,'"+price+"')\"></td>");  
                out.println("<td>"+ count +"</td>");  
                out.println("<td><a href='change.jsp?op=del&id="+id+"'>退回实验室</a></td>");  
                out.println("</tr>");  
            }  
        %>         
    </table>  
    <br>  
    <a href="list.jsp">继续查看</a>    
    <a href="change.jsp?op=clear">清空设备车</a>              
  </body>  
  <script language="javascript">  
    function updateNum(id,num,price){  
        var url = "change.jsp?op=update&id="+id+"&num="+num+"&price="+price;  
        window.location = url;  
    }  
  </script>    
</html>  