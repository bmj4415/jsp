<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- modifyBoardForm.jsp -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3>수정화면</h3>

<form action="modifyBoard.do">
<input type="hidden" value="${searchCondition }" name="searchCondition">
<input type="hidden" value="${keyword }" name="keyword">
	<table class="table">
		<tr>
			<th>글번호</th>
			<td><input type="text" readonly class="form-control"
				value="${board.boardNo }" name="bno"></td>
				
			<th>조회수</th>
			<td></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" value="${board.title }"
				name="title"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><textarea class="form-control" name="content">${board.content }</textarea>
			</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${board.writer }</td>
			<th>작성일시</th>
			<td>${board.creationDate }</td>
		</tr>
		<tr>
			<td colspan="4"><input class="btn btn-warning" type="submit"
				value="수정처리"></td>
		</tr>
	</table>
</form>
