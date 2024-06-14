<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>	

<h3>상세화면</h3>
<form name="myFrm" action = "removeForm.do">
<input type="hidden" value="${board.boardNo}" name="bno" >
<input type="hidden" value="${searchCondition }" name="searchCondition">
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
		<td colspan="3"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${board.creationDate}"/></td>
	</tr>
	<tr>
		<td colspan="3" align = "center">
		<c:choose>
		<c:when test="${!empty logId && logId == board.writer}">
			<button type="submit" class="btn btn-danger">삭제</button>
			<button type="button" class="btn btn-warning">수정</button>
		</c:when>
		<c:otherwise>
			<button type="submit" disabled class="btn btn-danger">삭제</button>
			<button type="button" disabled class="btn btn-warning">수정</button>
		</c:otherwise>
		</c:choose>
			<a href="boardList.do?page=${page }" class = "btn btn-success">목록으로 이동하기</a>
		</td>
	</tr>
</table>
</form>
<script>
	document.querySelector('button.btn-warning').addEventListener('click', function(e) {
	//삭제화면 이동할 경우에는 removeForm.do
	//수정화면이동으로 처리할 경우에는 action = "modifyForm.do";
	document.forms.myFrm.action = "modifyForm.do";
	document.forms.myFrm.submit();
	document.forms.myFrm.action = "removeForm.do";
	});

</script>

