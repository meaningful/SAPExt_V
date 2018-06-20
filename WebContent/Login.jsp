<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection"%>  
<%@page import="db.ConnectionFactory" %>
<%@page import="db.UserJdbcDAO"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title> SAP 前置登录系统 - 登录</title>
    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">

    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>
    
    <%
    	session = request.getSession();
    	String username =(String)session.getAttribute("AdminUsername");
    	String password =(String)session.getAttribute("AdminUserpassword");
    	if(username!=null && password!=null){
    		// 校验用户名和密码
  		  try {  
  	            UserJdbcDAO userInfoDao=new UserJdbcDAO();  
  	            Connection conn=ConnectionFactory.getInstance().getConnection();  
  	            boolean bRtv = userInfoDao.checkLogin(conn, username, password) ;
  	            if(bRtv) response.sendRedirect("mainFrame.jsp"); ; 
  	              
  	        } catch (Exception e) {  
  	            e.printStackTrace();  
  	        }  
    		
    	}
    %>
</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen  animated fadeInDown">
        <div>
            <div>

                <h1 class="logo-name">SAP</h1>

            </div>
            <h3>欢迎使用 SAP　前置登录系统</h3>

            <form class="m-t" role="form" action="LoginServlet">
                <div class="form-group">
                    <input name ="userid" id="userid" class="form-control" placeholder="用户名" required="">
                </div>
                <div class="form-group">
                    <input name="password" id="password" type="password" class="form-control" placeholder="密码" required="">
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>

            </form>
        </div>
    </div>
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>
</body>

</html>