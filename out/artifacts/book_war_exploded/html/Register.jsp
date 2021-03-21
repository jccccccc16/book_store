<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <script type="text/javascript">

        function  onclickCheck() {


            var usernameObj = document.getElementsByName("username");
            var usernameText = usernameObj.value;
            var patt = /^\w{5,12}$/;


            if(!patt.test(usernameText)){
                alert("不合法");
            }



        }




    </script>

</head>
<body>
<form action="http://localhost:8080/book/register" method="post">
    <table align="center">
        <tr>
            <td>
                用户名：
            </td>
            <td>
                <input type="text" name="username"/>
            </td>
        </tr>
        <tr>
            <td>
                密码：
            </td>
            <td>
                <input type="password" name="password"/>
            </td>
        </tr>
        <tr>
            <td>
                电子邮箱：
            </td>
            <td>
                <input type="text" name="email"/>
            </td>
        </tr>
        <tr>

            <td>
                <input type="submit" value="提交" onclick="onclickCheck()">
            </td>
            <td>
                <input type="submit" value="重置">
            </td>
        </tr>
    </table>
</form>
</body>
</html>