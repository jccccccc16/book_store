<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<header>
    <%@include file="/pages/common/header.jsp"%>
</header>

<form action="clientBookServlet" method="get">
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
            <td>
                <button id="addItem_btn"  onclick="" bookId="${book.id}">加入购物车</button>
            </td>
        </tr>

    </c:forEach>

</table>
<%@include file="../common/dev_page.jsp"%>
<footer>
    <%@include file="/pages/common/footer.jsp"%>
</footer>

<script type="text/javascript">
    $("#addItem_btn").on('click',function () {
        var bookId = $(this).attr("bookId")
        location.href="cartServlet?action=addItem&id="+bookId;
    })
</script>

</body>

</html>
