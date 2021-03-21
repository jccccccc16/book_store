<%@ page import="book.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: 61702
  Date: 2020/3/27
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        pageContext.setAttribute("key", "page");
        request.setAttribute("key","request");
        session.setAttribute("key","session");
        application.setAttribute("key","application");
        User user = new User();
        user.setUsername("cjc");
        pageContext.setAttribute("user",user);
    %>

${key}
${user.username}
${empty user.email}

</body>
</html>
