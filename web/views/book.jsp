<%@ page import="java.util.List" %>
<%@ page import="henu.bean.BookBean" %>
<%@ page import="henu.factory.DaoFactory" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Random" %>
<%--
  Created by IntelliJ IDEA.
  User: Yangtse
  Date: 2017/11/20
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>图书信息查询和修改</title>
</head>
<link rel="stylesheet" type="text/css" href="../static/css/yeti_bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../static/css/book.css">
<%
    List<BookBean>bookList= DaoFactory.getBookDaoInstance().findAll();
    Map<Integer,String>map=new HashMap<>();
    map.put(0,"table-info");
    map.put(1,"table-success");
    map.put(2,"table-danger");
    map.put(3,"table-warning");
    map.put(4,"table-active");
    map.put(5,"");
    map.put(6,"trs");
    Random random=new Random();
%>
<body>
    <form action="BookServlet" method="post" target="_self">
        <table id="bookTable" class="table table-striped table-hover table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th>图书名称</th>
                    <th>图书价格</th>
                    <th>图书作者</th>
                    <th>出版社</th>
                    <th>存放数量</th>
                    <th>修改数量</th>
                    <th>删除</th>
                </tr>
            </thead>
            <tbody>
            <%
                for(BookBean bookBean:bookList){
                    session.setAttribute(BookBean.BOOKNAME,bookBean.getBookName());
                    session.setAttribute(BookBean.BOOKPRICE,bookBean.getBookPrice());
                    session.setAttribute(BookBean.BOOKAUTHOR,bookBean.getBookAuthor());
                    session.setAttribute(BookBean.BOOKPUBLISHER,bookBean.getBookPublisher());
            %>
                    <form action="BookServlet" method="post" target="_self">
                        <tr class="<%=map.get(random.nextInt(7))%>">
                            <td><%=bookBean.getBookName()%></td>
                            <td><%=bookBean.getBookPrice()%></td>
                            <td><%=bookBean.getBookAuthor()%></td>
                            <td><%=bookBean.getBookPublisher()%></td>
                            <td><%=bookBean.getBookNumber()%></td>
                            <td>
                                <input name="modifyNumber" class="myInputs" type="number" title="please input number of book">
                                <input name="operation" type="submit" value="修改" class="btn-success addSubmit"/>
                            </td>
                            <td>
                                <input name="operation" type="submit" value="删除" class="btn-info addSubmit"/>
                            </td>
                        </tr>
                    </form>
            <%
                }
            %>
            </tbody>
        </table>
    </form>
    <button class="btn btn-primary" id="addBookInfo" onclick="addRow()">添加图书信息</button>
    <script src="../static/js/jquery-3.2.1.js"></script>
    <script src="../static/js/book.js"></script>
</body>
</html>
