<%@ page import="com.tj703.model2_study.dto.DepartmentDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>부서 수정</title>
</head>
<body>
  <h1>부서 수정 ~/dept/modify.do </h1>
  <form action="./modify.do" method="post">
    <%DepartmentDto dept=(DepartmentDto) request.getAttribute("dept");%>
    <p>
      <label>
        부서번호 : <b><%=dept.getDeptNo()%></b>
        <input type="hidden" name="dept_no" value="<%=dept.getDeptNo()%>" />
      </label>
    </p>
    <p>
      <label>
        부서이름 : <input type="text" name="dept_name" value="<%=dept.getDeptName()%>" />
      </label>
    </p>
    <p>
      <button type="reset">초기화</button>
      <button type="submit">제출</button>
      <a href="./remove.do?dept_no=<%=dept.getDeptNo()%>">삭제</a>
    </p>
  </form>
</body>
</html>
