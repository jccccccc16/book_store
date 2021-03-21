<%--
  Created by IntelliJ IDEA.
  User: 61702
  Date: 2020/4/5
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑</title>
</head>
<body>
<header>
    <%@include file="../common/header.jsp"%>
</header>
<form action="manager/bookServlet" method="get">
    <input type="text" hidden="hidden" name="action" value="${empty param.id ?"add":"update"}">
    <input type="text" hidden="hidden" name="id" value="${ requestScope.book.id }"/>
    <table>
        <tr>
            <td>书名</td>
            <td><input type="text" name="name" value="${requestScope.book.name}"></td>
        </tr>
        <tr>
            <td>作者</td>
            <td><input type="text" name="author" value="${requestScope.book.author}"></td>
        </tr>
        <tr>
            <td>价格</td>
            <td><input type="text" name="price" value="${requestScope.book.price}"></td>
        </tr>
        <tr>
            <td>销量</td>
            <td><input type="text"  name="sales" value="${requestScope.book.sales}"></td>
        </tr>
        <tr>
            <td>库存</td>
            <td><input type="text" name="stock" value="${requestScope.book.stock}"></td>
        </tr>

        <tr>
            <td><input type="submit"  value="提交"></td>
        </tr>

    </table>


</form>
<footer>
    <%@include file="../common/footer.jsp"%>
</footer>
</body>
</html>
