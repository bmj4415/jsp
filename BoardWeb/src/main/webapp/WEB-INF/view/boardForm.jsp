<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:forward page="../public/header.jsp">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
<c:when test="${!empty logId}">
<h3>게시글 등록</h3>
<form action="addBoard.do">
	<table class="table table-sm">
		<tr>
			<th>제목</th>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><c:out value="${logId }"/></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea cols="50" rows="10" class="form-control"></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit"
				class="btn btn-success" value="등록"></td>
		</tr>
	</table>
</form>
</c:when>
<c:otherwise>
<h3>로그인 화면(loginForm.jsp)</h3>
<form action="login.do">
<table class="table">
	<tr>
		<th>아이디</th>
		<td><input type="text" name="id"></td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td><input type="password" name="pw"></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="로그인"></td>
	</tr>
</table>
</form>
</c:otherwise>
</c:choose>

<jsp:forward page="../public/header.jsp">