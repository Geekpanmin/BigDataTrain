<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%  //  /20170906
	String path = request.getContextPath();
    pageContext.setAttribute("path", path);
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>青柠购物</title>
	<link rel="stylesheet" type="text/css" href="${path}/css/style.css"/>
	<script  src="${path}/js/jquery.min.js"></script>
	<script>
	  //
	  function login(){
		  var username=$("#username").val();
		  var password=$("#password").val();
		  if(username!=''&&password!=''){
			  $.ajax({
				    type : "post",
					url :"${path}/login.shtml",
					contentType:"application/json;charset=utf-8",
					data:'{"username"'+':"'+username+'","password"'+':"'+password+'"}',
					success : function(data) {
						
						 if(data.status==1){
							window.location.href="${path}/index.shtml";
						}else{
							 $("#tips").html("用户名或密码错误");	
						} 
					
					}
					
				});
	      }else{
	    	  $("#tips").html("用户名或密码不能为空");
	      }
	  }
	  
	  
	  function logins(){
		     var id=window.prompt("请输入用户id");
			  $.ajax({
				    type : "get",
					url :"${path}/user/"+id,
					contentType:"application/json;charset=utf-8",
					success : function(data) {
						$("#username").val(data.username);
						$("#password").val(data.password);
					}
					
				});
	      }
	
	</script>
</head>
<body>
	<div class="logo">
		<img src="${path}/images/picture_03.gif" class="logoimg">
		<p class="p1">商品管理系统</p>
	</div>
	<div class="main">
		<img src="${path}/images/picture_07.gif" class="pic">
		<form  class="form" method="post" >
		    <p class="p3">用户登录</p>
		    <img src="${path}/images/picture_10.gif" class="userimg"><br/>
			<input type="text"  class="txt" placeholder="账号" name="username" id="username"><br/>
			<input type="password"  class="psw" placeholder="密码" name="password" id="password"><br/>
			
			<p class="p3" style="margin-top:-14px;"><span style="color:red" id="tips">${error}</span></p>
       		<p class="p3" style="margin-top:40px;margin-left:40px"><button type="button" onclick="logins()">获取数据</button><br/><button type="button" onclick="login()">登录</button>  </p>
		</form>
	</div>
	<div class="footer">
		<p class="p4"><a href="#">关于青檬</a><a href="#">平台规范</a><a href="#">联系我们</a><a href="#">隐私政策</a>|<a href="#" style="margin-left: 17px;">公司版权所有&copy;1997-2015</a></p>
	</div>

</body>

</html>
