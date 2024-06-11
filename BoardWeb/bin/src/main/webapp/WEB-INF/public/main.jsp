<%@page import="java.util.List"%>
<%@page import="co.yedam.vo.Student"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jsp는 다른 파일에 있는 내용을 가져올 수 있음 -->
<%@include file="header.jsp" %>


	<h3>main 페이지</h3>
<!--  jsp 파일은 자동임포트 x 임포트 할 부분에서 ctrl+spacebar-->
	<% 
		Student student = (Student) request.getAttribute("student"); 
		List<Student> list = (List<Student>) request.getAttribute("studentList");
	%>
	<p>학생번호 : <%=student.getStdNo() %></p>
	<p>학생이름 : <%=student.getStdName() %></p>
	
	<!-- 학생목록은 리스트기 때문에 반복문을 통해 하나씩 가져옴. -->
	<h3>학생목록</h3>
	<ul>
		<%for(Student std : list) { %>
		<li>학번 : <%=std.getStdNo() %> 이름 : <a href="product.do?stdNo=<%=std.getStdNo() %>"><%=std.getStdName() %></a> 연락처 : <%=std.getPhone() %></li>
		<%} %>
	</ul>
	<%@include file="footer.jsp" %>