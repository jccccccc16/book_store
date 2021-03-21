<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>login</title>
</head>
<body>
    <form action="http://localhost:8080/book/login" method="post">
        <table>
            <tr>
                <td>
                    用户名：
                </td>
                <td>
                    <input type="text" name="username">
                </td>
                <td>
                    密码：
                </td>
                <td>
                    <input type="password" name="password">
                </td>
                <td>
                    <input type="submit" value="登录">
                </td>
                <td>
                    <input type="reset" value="重置">
                </td>
            </tr>


        </table>


    </form>

</body>
</html>