<%--
  Created by IntelliJ IDEA.
  User: 61702
  Date: 2020/4/13
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp"%>

<button id="ajax_btn">点我是ajax</button>

<button id="getJson_btn">点我是getjson</button>
<from id="ser_form">
    <input type="text" name="username">
    <button id="submit">提交</button>
</from>
<script>
    $("#ajax_btn").click(function () {
       $.ajax({
           url:"ajaxServlet",
           data:{
               action:"ajax"
             },
           type:"GET",
           success:function (data) {

            var jsonObj = JSON.parse(data);

            $("#msg").html("姓名："+jsonObj.username+", 密码："+jsonObj.password);

           },
           datatype:"JSON",
       }


       )
    });

    $("#getJson_btn").click(function () {
        $.getJSON(
            "ajaxServlet",
            "action=getJson",
            function () {
                $("#msg").html("这是getJson方法")
            }
        )
    })

    $("#submit").click(function () {
        alert($("#ser_form").serialize())
        $.getJSON(
            "ajaxServlet",
            "action=serialize&"+$("#ser_form").serialize(),

            function () {
                $("#msg").html("调用了serialize方法")
            }
        )
    })

</script>


<div id="msg">

</div>

</body>
</html>
