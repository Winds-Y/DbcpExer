<%--
  Created by IntelliJ IDEA.
  User: Yangtse
  Date: 2017/12/19
  Time: 9:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path=request.getContextPath();
    String basePath=request.getScheme()+"://"
            +request.getServerName()+":"+request.getServerPort()
            +path+"/";
%>
<html>
<head>
    <title>Register</title>
    <base href="<%=basePath%>">
</head>
<link type="text/css" rel="stylesheet" href="../static/css/yeti_bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="../static/css/register.css">
<body>
    <form id="loginform" action="RegisterServlet" method="post" target="_self">
        <div id="myborder">
            <div class="innerdiv">
                <div class="badge badge-primary labels">用户名：</div>
                <input  class="inputs" type="text" name="userName" title="username"/>
            </div>
            <div class="innerdiv">
                <div  class="badge badge-primary labels">密码：</div>
                <input class="inputs" type="password" name="password" title="password"/>
            </div>
        </div>
        <div id="btns">
            <input class="btn btn-outline-primary" style="height: 25px;line-height: 10px;margin-left: 80px;" type="submit"  value="注册"/>
            <input style="height: 25px;line-height: 10px;" class="btn btn-outline-primary" type="reset" value="重置"/>
        </div>
    </form>
</body>
</html>
