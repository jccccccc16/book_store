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
<header>
    <%@include file="/pages/common/header.jsp"%>
</header>
<form action="userServlet" method="post">
    <table align="center">
        <tr>
            <td>
                <span>
                    ${empty requestScope.msg ?"请输入信息":requestScope.msg}
                </span>
            </td>
        </tr>
        <tr>
            <td>
                用户名：
            </td>
            <td>
                <input id="username" type="text" name="username"/>
            </td>
            <td>
                <span id="error_msg">
                </span>
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
                <input type="text"  name="action" hidden="hidden" value="register">
                <input type="submit" value="提交" onclick="onclickCheck()">
            </td>
            <td>
                <input type="submit" value="重置">
            </td>
        </tr>
    </table>
</form>

<script>
    $("#username").blur(function () {
        var username = this.value;
        $.getJSON(
            "ajaxServlet",
            "action=ajaxExistUsername&username="+username,
            function (data) {
                if(data.existsUsername){
                    $("#error_msg").text("用户名已存在")
                }else{
                    $("#error_msg").text("用户名可用")
                }
            }
        )
    })
</script>
<footer>
    <%@include file="/pages/common/footer.jsp"%>
</footer>
</body>
</html>