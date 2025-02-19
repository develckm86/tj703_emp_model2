<%--
  Created by IntelliJ IDEA.
  User: som
  Date: 25. 2. 19.
  Time: 오후 4:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>광고</title>
</head>
<body>
    <h1>광고 입니다.</h1>
    <form action="./setBanner.do" method="post">
        <label>하루동안 보지 않기<input type="checkbox" name="isBanner" value="1"></label>
        <button>제출</button>
    </form>
</body>
</html>
