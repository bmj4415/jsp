<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cusTag" %> <!-- 사용자 정의 태그 연습 -->	

<h3>로그인 화면(loginForm.jsp)</h3>
<cusTag:line/> <!-- jsp에서 제공해주는 standard tag library(=JSTL) -->

<c:set var="name" value="hong"></c:set>
<c:out value="${name == 'hong'? '맞다':'아니다'}"></</c:out>

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

