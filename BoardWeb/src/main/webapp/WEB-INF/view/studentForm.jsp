<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../public/header.jsp" />
<h3>학생등록화면</h3>
<%
String msg = (String) request.getAttribute("message");
%>
<%
if (msg != null) {
%>
<p><%=msg%></p>
<%
}
%>

<form action="addStudent.do">
	<!-- form action을 누르면 addStudent.do url이 실행됨 -->
	<table class="table">
		<tr>
			<th>학생번호</th>
			<td><input type="text" name="sno"></td>
		</tr>
		<tr>
			<th>학생이름</th>
			<td><input type="text" name="sname"></td>
		</tr>
		<tr>
			<th>연락처</th>
			<td><input type="text" name="phone"></td>
		</tr>
		<tr>
			<th>혈액형</th>
			<td><input type="text" name="btype"></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit"
				class="btn btn-danger" value="저장"></td>
		</tr>
	</table>
</form>

<jsp:include page="../public/footer.jsp" />