<%--
  Created by IntelliJ IDEA.
  User: 61702
  Date: 2020/4/8
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<header>
    <%@include file="../common/header.jsp"%>
</header>
<form action="manager/bookServlet" method="get">
    <table align="center">
        <tr>
            <td>
                价格：
            </td>
            <td>
                <input type="text" name="min" value="${param.min}">元-
            </td>
            <td>
                <input type="text" name="max" value="${param.max}">元
            </td>
            <td>
                <input type="hidden" name="action" value="pageByPrice">
                <input type="submit" value="查询">
            </td>
        </tr>
    </table>

</form>

<table align="center">
    <tr>
        <td>
            书名
        </td>
        <td>
            价格
        </td>
        <td>
            作者
        </td>
        <td>
            销量
        </td>
        <td>
            库存
        </td>
    </tr>
    <c:forEach items="${requestScope.page.items}" var="book">
    <tr>

        <td>
                ${book.name}
        </td>
        <td>
                ${book.price}
        </td>
        <td>
                ${book.author}
        </td>
        <td>
                ${book.sales}
        </td>
        <td>
                ${book.stock}
        </td>
    </tr>

    </c:forEach>
<footer>
    <%@include file="../common/footer.jsp"%>
</footer>

</body>
</html>
