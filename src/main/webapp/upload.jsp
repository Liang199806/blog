<%--
  Created by IntelliJ IDEA.
  User: 86151
  Date: 2019/11/20
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>图片上传页面</title>
</head>
<body>
<form action="/api/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="filename" multiple="multiple">
    <input type="submit" value="上传">
</form>
<p>${msg}</p>
</body>
</html>
