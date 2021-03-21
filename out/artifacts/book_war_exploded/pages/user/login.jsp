<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>login</title>

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

                        ${ empty requestScope.msg ? "请输入密码和账号":requestScope.msg}
                    </span>
                </td>
            </tr>
            <tr>
                <td>
                    用户名：
                </td>
                <td>
                    <input type="text" name="username" value="${empty requestScope.username ?cookie.username.value:requestScope.username}">
                </td>
                </tr>
            <tr>
                <td>
                    密码：
                </td>
                <td>
                    <input type="password" name="password">
                </td>
            </tr>
            <tr>
                <td>
                    验证码
                </td>
                <td>
                    <input type="text" name="code">
                </td>
                <td>
                    <img src="kaptcha.jsp" id="code_img">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="text" hidden="hidden" name="action" value="login">
                    <input type="submit" value="登录">
                </td>
                <td>
                    <input type="reset" value="重置">
                </td>
            </tr>


        </table>
    </form>
<footer>
    <%@include file="/pages/common/footer.jsp"%>
</footer>
<script type="text/javascript">

    $("#code_img").bind("click",function () {
        this.src = "kaptcha.jsp?id="+new Date();
    })

</script>
</body>
</html>