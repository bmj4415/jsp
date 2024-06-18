<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- memberList.jsp -->
<h3>회원목록(관리자용)</h3>

<table class="table">
	<thead>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>권한</th>
		</tr>
	</thead>
	<tbody>
		<!-- 확장 for문 연습 -->
		<c:forEach var="vo" items="${boardList}">
			<tr>
				<td>${vo.boardNo }</td>
				<td><a
					href="getBoard.do?bno=${vo.boardNo}&page=${paging.page}&searchCondition=${searchCondition}&keyword=${keyword}"><c:out
							value="${vo.title}" /></a></td>
				<td><c:out value="${vo.writer}" /></td>
				<td><c:out value="${vo.clickCnt}" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>