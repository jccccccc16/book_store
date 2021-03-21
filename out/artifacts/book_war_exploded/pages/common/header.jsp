<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 61702
  Date: 2020/3/26
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String bashPath = request.getScheme()
            +"://"
            +request.getServerName()
            +":"
            +request.getServerPort()
            +request.getContextPath()
            +"/";
    pageContext.setAttribute("basePath",bashPath);
%>
<base href="<%=bashPath%>">
<html>
<head>
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js" type="text/javascript"></script>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <tb>
                <a href="clientBookServlet?action=page">主页</a>
            </tb>
            <tb>
                搜索
            </tb>
            <tb>
                <c:choose>
                    <c:when test="${empty sessionScope.user}">
                        <a href="pages/user/register.jsp">注册</a>
                        <a href="pages/user/login.jsp">登录</a>
                    </c:when>
                    <c:when test="${not empty sessionScope.user}">
                        <a href="#">${sessionScope.user.username}</a>
                        <a href="userServlet?action=logout">注销</a>
                        <a href="pages/cart/cart.jsp">购物车</a>
                    </c:when>
                </c:choose>
            </tb>
            <td>
                <a href="manager/bookServlet?action=page">图书管理</a>
            </td>
        </tr>


    </table>

</body>
</html>
