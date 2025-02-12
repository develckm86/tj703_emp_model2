<%@ page import="java.util.List" %>
<%@ page import="com.tj703.model2_study.dto.DepartmentDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
      <title>부서 리스트</title>
</head>
<body>
  <h1>부서 리스트 ~~/detp/list.do</h1>
  <%List< DepartmentDto> deptList=(List<DepartmentDto>)request.getAttribute("deptList");%>
  <p><a href="./register.do">부서등록</a></p>
  <table>
    <thead>
    <tr>
      <th>부서번호</th>
      <th>부서이름</th>
      <th>상세</th>
    </tr>
    </thead>
    <tbody>
    <%for(DepartmentDto dept:deptList){%>
      <tr>
        <td><%=dept.getDeptNo()%></td>
        <td><%=dept.getDeptName()%></td>
        <td><a href="detail.do?dept_no=<%=dept.getDeptNo()%>">상세</a></td>
<%--   http://localhost:8888/model2_study_war_exploded/dept/detail.do?dept_no=d009   --%>
      </tr>
    <%}%>
    </tbody>

  </table>
</body>
</html>
