<%@page import="java.text.SimpleDateFormat"%>
<%@page import="co.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../public/header.jsp"%>
<%
BoardVO board = (BoardVO) request.getAttribute("board");
SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
String yyyymmdd = sdf.format(board.getCreationDate());
%>
<h3>게시글 삭제</h3>
<form action="removeBoard.do">
	<table class="table table-sm">
		<tr>
			<th class="col-sm-1">글번호 :</th>
			<td class="col-sm-3"><%=board.getBoardNo()%></td>
		</tr>
		<tr>
			<th>제목 :</th>
			<td><%=board.getTitle()%></td>
		</tr>
		<tr>
			<th>내용 :</th>
			<td><textarea class="form-control" readonly><%=board.getContent()%>></textarea></td>
		</tr>
		<tr>
			<th>작성자 :</th>
			<td colspan="3"><%=board.getWriter()%></td>
		</tr>
		<tr>
			<th>작성일시 :</th>
			<td colspan="3"><%=yyyymmdd%></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit"
				class="btn btn-danger" value="삭제"></td>
		</tr>
	</table>

</form>

<%@include file="../public/footer.jsp"%>