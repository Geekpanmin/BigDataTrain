<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@ page import="com.eems.entity.*,java.sql.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>设备篮</title>

</head>
<body>

	<%  
    //装载MySQL5.5的JDBC驱动  
    Class.forName("com.mysql.jdbc.Driver").newInstance();  
    //建立数据库连接  
    String url ="jdbc:mysql://localhost:3306/List?user=root&password=&characterEncoding=utf8";  
    Connection conn= DriverManager.getConnection(url);  
    PreparedStatement pstat = null;  
    ResultSet rs = null;  
      
    String sql = null;  
    String op = request.getParameter("op");  
      
    //将设备放入设备车  
    if (op.equals("add")){  
        //从设备库中取出所选购设备的数据  
        int id = Integer.parseInt(request.getParameter("id"));  
        String name=null,price=null;  
        sql = "select * from equipment where equipmentNo=?";  
        pstat = conn.prepareStatement(sql);  
        pstat.setInt(1,id);  
        rs = pstat.executeQuery();  
        if (rs.next()){  
        	    
            name = rs.getString("equipmentName").trim();  
            price = rs.getString("changeMoney").trim();  
        }  
        rs.close();  
        pstat.close();  
          
        //将所选购设备加入到设备车中  
        sql = "insert into cart values(?,?,?,?,?)";  
        pstat = conn.prepareStatement(sql); 
        pstat.setInt(1,id);
        pstat.setString(2,name);  
        pstat.setString(3,price);  
        pstat.setInt(4,1);  
        pstat.setString(5,price);  
        pstat.executeUpdate();  
        pstat.close();  
          
        //关闭数据库连接  
        conn.close();  
          
        //重定向到设备车页面  
        response.sendRedirect("cart.jsp");  
        
      
      //更改商品的数量  
        if (op.equals("update")){  
            int idupdate = Integer.parseInt(request.getParameter("id"));  
            int num = Integer.parseInt(request.getParameter("num"));  
            double priceupdate=Double.parseDouble(request.getParameter("price"));  
            sql = "update cart set num = ?, count = ? where id=?";  
            pstat = conn.prepareStatement(sql);  
            pstat.setInt(1,num);  
            pstat.setString(2,new Double(priceupdate*num).toString());  
            pstat.setInt(3,idupdate);  
            pstat.executeUpdate();  
            pstat.close();  
            //关闭数据库连接  
            conn.close();  
            //重定向到购物车页面 
            request.getRequestDispatcher("cart.jsp");
            //response.sendRedirect("cart.jsp");  
        }     
        //将设备退回到设备架(将设备从设备车中删除)  
        if (op.equals("del")){  
        	    int iddelete = Integer.parseInt(request.getParameter("id")); 
            sql = "delete from cart where id=?";  
            pstat = conn.prepareStatement(sql);  
            pstat.setInt(1,iddelete);  
            pstat.executeUpdate();  
            pstat.close();    
            //关闭数据库连接  
            conn.close();  
            //重定向到设备车页面  
            response.sendRedirect("./cart.jsp");  
        }  
        
        //清空设备车  
        if (op.equals("clear")){  
            sql = "delete from cart";  
            pstat = conn.prepareStatement(sql);  
            pstat.executeUpdate();  
            pstat.close();  
              
            //关闭数据库连接  
            conn.close();  
            //重定向到设备车页面  
            response.sendRedirect("./cart.jsp");  
        }  
          
    }   
    
      
    
%>
</body>
</html>