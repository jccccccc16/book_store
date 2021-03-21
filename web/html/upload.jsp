<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

    <form action="http://localhost:8080/book/upload" method="post" enctype="multipart/form-data">

        <input type="file" name="photo"><br>
        <input type="submit" value="上传">
    </form>

</body>
</html>