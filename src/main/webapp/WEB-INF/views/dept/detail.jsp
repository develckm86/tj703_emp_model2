<%@ page import="com.tj703.model2_study.dto.DepartmentDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>부서 상세</title>
</head>
<body>
  <h1>부서 상세</h1>
  <% DepartmentDto dept=(DepartmentDto) request.getAttribute("dept");%>
  <div>
    <p>부서 번호 :
      <strong><%=dept.getDeptNo()%></strong>
    </p>
    <p>부서 이름 :
      <strong><%=dept.getDeptName()%></strong>
    </p>
    <p>
      <a href="./modify.do?dept_no=<%=dept.getDeptNo()%>">부서 수정 페이지</a>
    </p>
  </div>
</body>
</html>
