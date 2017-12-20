<%@ page import="henu.util.ParameterName" %>
<%--
  Created by IntelliJ IDEA.
  User: Yangtse
  Date: 2017/12/19
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    String path=request.getContextPath();
    String basePath=request.getScheme()+"://"
            +request.getServerName()+":"+request.getServerPort()
            +path+"/";
%>
<html>
<head>
    <title>login</title>
    <base href="<%=basePath%>">
</head>
<link rel="stylesheet" type="text/css" href="../static/css/yeti_bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../static/css/register.css">
<body>
    <form id="loginform" action="LoginServlet" method="post" target="_self">
        <div id="myborder">
            <div class="innerdiv">
                <div class="badge badge-primary labels">用户名：</div>
                <input class="inputs" type="text" name="<%=ParameterName.USERNAME%>" title="username"/>
            </div>
            <div class="innerdiv">
                <div  class="badge badge-primary labels">密码：</div>
                <input class="inputs" type="password" name="<%=ParameterName.PASSWORD%>" title="password"/>
            </div>
        </div>
        <div id="btns">
            <input class="btn btn-outline-primary" style="height: 25px;line-height: 10px;margin-left: 80px;" type="submit"  value="登陆"/>
            <input style="height: 25px;line-height: 10px;" class="btn btn-outline-primary" type="reset" value="重置"/>
        </div>
        <a style="margin:30px 320px;" href="${pageContext.request.contextPath}/views/Register.jsp">点击注册</a>
    </form>
</body>
</html>
