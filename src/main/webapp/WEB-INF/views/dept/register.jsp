<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>부서 등록</title>
</head>
<body>
  <h1>부서등록</h1>
  <form action="./register.do" method="post">
    <p>
      <label>
        부서번호 : <input type="text" name="dept_no" value="d123" />
      </label>
    </p>
    <p>
      <label>
        부서이름 : <input type="text" name="dept_name" value="등록테스트" />
      </label>
    </p>
    <p>
      <button type="reset">초기화</button>
      <button type="submit">제출</button>
    </p>
  </form>
</body>
</html>
