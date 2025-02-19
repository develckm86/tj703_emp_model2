<%@ page import="com.tj703.model2_study.dto.DepartmentDto" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<hr>
    <h2>
        <a href="./dept/list.do">부서로 이동</a>
    </h2>
    <hr>
    <h2>하루동안 보지 않기 배너 만들기</h2>
<%
    Cookie [] cookies=request.getCookies();
    Cookie isBanner=null;
    if(cookies!=null){
        for(Cookie c :  cookies){
            if(c.getName().equals("isBanner")){
                isBanner=c;
            }
        }
    }
%>
<%if(isBanner==null || !isBanner.getValue().equals("1") ){%>
<script>
    window.open("./banner.jsp", "_blank","width=400,height=300,left=100,top=50");

</script>
<%}%>

    <hr>
    <h2>부서 이름과 부서 번호 로그인 session 에 DepartmentDto deptDto 저장</h2>
    <p>로그인 성공시 form 을 보이지 않게 하고 Marketing 부서 로그인 중 구현!</p>

    <%
    Object deptDtoObj=session.getAttribute("deptDto");
    Object msg=session.getAttribute("msg");
    %>
    <%if(msg!=null){
        session.removeAttribute("msg");
    %> <script>alert("<%=msg%>");</script>

    <%}%>

    <%if(deptDtoObj==null){%>
    <form action="./dept/login.do" method="post">
        <p><label><input type="text" name="dept_no" value="d001" ></label></p>
        <p><label><input type="text" name="dept_name" value="Marketing" ></label></p>
        <p><button>로그인</button></p>
    </form>
    <%}else{
        DepartmentDto deptDto=(DepartmentDto) deptDtoObj;
    %>
    <p>
        <%=deptDto.getDeptName()%> 님 로그인 중
        /
        <a href="./dept/logout.do">로그아웃</a>
    </p>
    <%}%>

</body>
</html>