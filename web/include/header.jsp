<%--
  Created by IntelliJ IDEA.
  User: 61702
  Date: 2020/3/26
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <tb>
                主站
            </tb>
            <tb>
                搜索
            </tb>
            <tb>
                <%
                    Object username =  session.getAttribute("name");
                %>
                <%
                    if(username != null){
                        out.write((String)username);
                    }else{
                        out.write("未登录");
                    }
                %>
            </tb>
        </tr>


    </table>

</body>
</html>
