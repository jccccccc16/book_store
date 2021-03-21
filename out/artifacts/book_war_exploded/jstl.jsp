<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="book.pojo.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 61702
  Date: 2020/3/27
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
保存之前 :${requestScope.name}<br>
<c:set  scope="request" var="name" value="cjc"/>
保存之后：${requestScope.name}
<%--test属性表示判断的条件--%>
<c:if test="${ 12 == 12}">
    <h1>你好</h1>
</c:if>

<%--choose 其实就是switch--%>
<c:set scope="request" var="age" value="22"/>
<c:choose>

    <c:when test="${requestScope.age<18}">
        去看动画片
    </c:when>
    <c:when test="${requestScope.age> 18}">
        去学习
    </c:when>
</c:choose>

<%--遍历循环 var 为循环变量--%>
<%
    request.setAttribute("arr",new String[]{"123","456","789"});
%>
<c:forEach items="${requestScope.arr}" var="each">
    ${each}
</c:forEach>

<%
    Map<String,String> map = new HashMap<String,String>();
    map.put("key1","value1");
    map.put("key2","value2");
    map.put("key3","value3");
    for(Map.Entry entry :map.entrySet()){

    }
    request.setAttribute("map",map);
%>

<c:forEach items="${requestScope.map}" var="entry">
    ${entry.key}=${entry.value}
</c:forEach>

<%--Integer id, String usernameUser user01 = new User("");--%>
<%
    User u1 = new User(1,"cjc123456","cjc","cjc@123");
    User u2 = new User(2,"cjc123456","cjc","cjc@123");
    User u3 = new User(3,"cjc123456","cjc","cjc@123");
    List list = new ArrayList<User>();
    list.add(u1);
    list.add(u2);
    list.add(u3);
    request.setAttribute("list",list);

%>

<table border="1" >

    <tr>
        <th>id</th>
        <th>用户名</th>
        <th>密码</th>
        <th>邮箱</th>
    </tr>

    <c:forEach begin="" items="${list}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.email}</td>
        </tr>
    </c:forEach>

</table>





</table>







</body>
</html>
