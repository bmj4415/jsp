<%@page import="co.yedam.web.BoardList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="co.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../public/header.jsp"%>

<%
String paging = (String) request.getAttribute("page");
BoardVO board = (BoardVO) request.getAttribute("board"); //BoardVO로 캐스팅
SimpleDateFormat sdf  = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
String yyyymmdd = sdf.format(board.getCreationDate());
%>

<p><%=board%></p>
<table class="table table-sm">
	<tr>
		<th class = "col-sm-1">글번호 : </th>
		<td class = "col-sm-3"><%=board.getBoardNo()%></td>
		<th class = "col-sm-1">조회수 : </th>
		<td class = "col-sm-2"><%=board.getClickCnt()%></td>
	</tr>
	<tr>
		<th>제목 : </th>
		<td><%=board.getTitle()%></td>
	</tr>
	<tr>
		<th>내용 : </th>
		<td><textarea class = "form-control" readonly><%=board.getContent()%>></textarea></td>
	</tr>
	<tr>
		<th>작성자 : </th>
		<td colspan="3"><%=board.getWriter()%></td>
	</tr>
	<tr>
		<th>작성일시 : </th>
		<td colspan="3"><%=yyyymmdd %></td>
	</tr>
</table>
<a href="boardList.do?page=<%=paging %>">목록으로 이동하기</a>

<%@include file="../public/footer.jsp" %>