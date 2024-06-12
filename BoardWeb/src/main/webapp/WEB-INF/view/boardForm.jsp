<%@page import="co.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../public/header.jsp"%>
<%
BoardVO board = (BoardVO) request.getAttribute("board");
%>
<h3>게시글 등록</h3>
<form action="addBoard.do">
	<table class="table table-sm">
		<tr>
			<th>제목</th>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td col = "80"><input type="text" name="content"></td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="submit"
				class="btn btn-success" value="등록"></td>
		</tr>
	</table>
</form>

<%@include file="../public/footer.jsp"%>