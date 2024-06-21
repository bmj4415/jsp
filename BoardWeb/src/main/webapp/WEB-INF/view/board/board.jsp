<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<style>
div.reply div {
	margin: auto;
}

div.reply ul {
	list-style-type: none;
	margin-top: ]
}

div.reply li {
	padding-top: 1px;
	padding-bottom: 1px;
}

div.reply span {
	display: inline-block;
}
</style>

<!-- 페이지 디자인 때문에 넣음 -->
<style> 
.center {
	text-align: center;
}

.pagination {
	display: inline-block;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
	border: 1px solid #ddd;
	margin: 0 4px;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
	border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}
</style>

<h3>상세화면</h3>
<form name="myFrm" action="removeForm.do">
	<input type="hidden" value="${board.boardNo}" name="bno"> <input
		type="hidden" value="${searchCondition }" name="searchCondition">
	<input type="hidden" value="${keyword }" name="keyword">

	<table class="table table-sm">
		<tr>
			<th class="col-sm-1">글번호 :</th>
			<td class="col-sm-3">${board.boardNo}</td>
			<th class="col-sm-1">조회수 :</th>
			<td class="col-sm-2">${board.clickCnt}</td>
		</tr>
		<tr>
			<th>제목 :</th>
			<td>${board.title}</td>
		</tr>
		<tr>
			<th>내용 :</th>
			<td><textarea class="form-control" readonly>${board.content}</textarea></td>
		</tr>
		<tr>
			<th>작성자 :</th>
			<td colspan="3"><c:out value="${board.writer }"></c:out></td>
		</tr>
		<tr>
			<th>작성일시 :</th>
			<td colspan="3"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
					value="${board.creationDate}" /></td>
		</tr>
		<tr>
			<td colspan="3" align="center"><c:choose>
					<c:when test="${!empty logId && logId == board.writer}">
						<button type="submit" class="btn btn-danger">삭제</button>
						<button type="button" class="btn btn-warning">수정</button>
					</c:when>
					<c:otherwise>
						<button type="submit" disabled class="btn btn-danger">삭제</button>
						<button type="button" disabled class="btn btn-warning">수정</button>
					</c:otherwise>
				</c:choose> <a href="boardList.do?page=${page }" class="btn btn-success">목록으로
					이동하기</a></td>
		</tr>
	</table>
</form>

<!-- 댓글관련 시작 -->
<div class="container reply">

	<!-- 댓글 작성하는 창 -->
	<div class="header">
		<input class="col-sm-8" id="reply">
		<button class="col-sm-3" id="addReply">등록</button>
	</div>

	<!-- 댓글 목록보기 -->
	<div class="content">
		<ul>
			<li><span class="col-sm-1">글번호</span> <span class="col-sm-4">글내용</span>
				<span class="col-sm-2">작성자</span> <span class="col-sm-3">작성일시</span>
				<span class="col-sm-1">삭제</span></li>
			<li><hr /></li>
			<li style="display: none"><span class="col-sm-1">3</span> <span
				class="col-sm-4">글을 잘 봤습니다</span> <span class="col-sm-2">user01</span>
				<span class="col-sm-3">2024-05-08 13:22:34</span> <span
				class="col-sm-1"><button onclick="deleteRow(event)">삭제</button></span>
			</li>
		</ul>
	</div>
	<div class="footer">
		<div class="center">
			<div class="pagination">
				<a href="#">1</a>
				<a href="#" class="active">2</a>
				<a href="#">3</a>
				<a href="#">4</a>
			</div>
		</div>
	</div>
	
</div>
<!-- 댓글관련 끝 -->

<script>
	const bno = "${board.boardNo}";
	const replyer = "${logId}";//로그인해야 댓글을 작성할 수 있으므로

	document.querySelector('button.btn-warning').addEventListener('click',
			function(e) {
				//삭제화면 이동할 경우에는 removeForm.do
				//수정화면이동으로 처리할 경우에는 action = "modifyForm.do";
				document.forms.myFrm.action = "modifyForm.do";
				document.forms.myFrm.submit();
				document.forms.myFrm.action = "removeForm.do";
			});
</script>
<script src="js/replyService.js"></script>
<script src="js/reply.js"></script>

