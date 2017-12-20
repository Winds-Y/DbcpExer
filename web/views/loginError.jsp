<%@ page import="henu.util.ParameterName" %>
<%--
  Created by IntelliJ IDEA.
  User: Yangtse
  Date: 2017/12/19
  Time: 17:56
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
    <title>loginError</title>
    <base href="<%=basePath%>">
</head>
<body>
<%
    String loginStatus=request.getParameter(ParameterName.loginStatus);
    switch (loginStatus){
        case ParameterName.LOGINPASSWORDWRONG:
%>
            <a href="${pageContext.request.contextPath}/views/login.jsp">密码错误，请重新输入</a>
<%
            break;
        case ParameterName.USERNOTEXIST:
%>
            <a href="${pageContext.request.contextPath}/views/Register.jsp">账号不存在，请前往注册</a>
<%
            break;
    }
%>
</body>
</html>
