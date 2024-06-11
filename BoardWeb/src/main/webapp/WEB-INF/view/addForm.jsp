<%@page import="co.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="../public/header.jsp"%>
<h3>게시글 등록</h3>
<%
BoardVO vo = new BoardVO(); request.getAttribute("addForm");
%>

<form action="addForm.do">
	<table class="table">
		<tr>
			<th>제목</th><td><%=vo.getTitle()%></td>
		</tr>
		<tr>
			<th>제목</th><td><%=vo.getTitle()%></td>
		</tr>
		<tr>
			<td><%=vo.getWriter() %></td>
		</tr>
		<tr>
			<td><%=vo.getContent() %></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center"><input type="submit"
				class="btn btn-success" value="글쓰기"></td>
		</tr>
	</table>
</form>

<%@include file="../public/footer.jsp"%>