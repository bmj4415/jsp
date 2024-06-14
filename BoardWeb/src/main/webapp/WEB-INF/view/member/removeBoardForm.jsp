<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:forward page="../public/header.jsp">

<h3>삭제화면</h3>
<form action="removeBoard.do">
	<table class="table table-sm">
		<tr>
			<th>글번호</th>
			<td><input type="text" readonly class="form-control"
				value="${board.boardNo }" name="bno"></td>
			<th>조회수</th>
			<td></td>
		</tr>
		<tr>
			<th>제목 :</th>
			<td>${board.title }</td>
		</tr>
		<tr>
			<th>내용 :</th>
			<td colspan="3"><textarea col="80" readonly>${board.content }</textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${board.writer }</td>
			<th>작성일시</th>
			<td>${board.creationDate }</td>
		</tr>
		<tr>
			<td colspan="3" align="center"><input class="btn btn-danger"
				type="submit" value="삭제처리"></td>
		</tr>
	</table>
</form>
<jsp:forward page="../public/footer.jsp">