<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 61702
  Date: 2020/4/5
  Time: 11:36
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
            <td>
                <a href="manager/bookServlet?id=${book.id}&action=getBook">修改图书</a>
            </td>
            <td>
                <a href="manager/bookServlet?action=delete&id=${book.id}">删除图书</a>
            </td>


        </tr>

    </c:forEach>

    <tr align="right">
        <td>
            <a href="pages/manager/book_edit.jsp">添加图书</a>
        </td>
    </tr>

</table>
<%@include file="../common/dev_page.jsp"%>
<footer>
    <%@include file="../common/footer.jsp"%>
</footer>



</body>
</html>
