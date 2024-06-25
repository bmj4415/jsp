<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 화면(book) -->
<form action="bookForm.do">
	<table class="table">
		<thead>
			<tr>
				<th>도서코드</th>
				<td><input type="text" name="bookcode"></td>
			</tr>
			<tr>
				<th>도서명</th>
				<td><input type="text" name="bookcode"></td>
			</tr>
			<tr>
				<th>저자</th>
				<td><input type="text" name="bookcode"></td>
			</tr>
			<tr>
				<th>출판사</th>
				<td><input type="text" name="bookcode"></td>
			</tr>
			<tr>
				<th>금액</th>
				<td><input type="text" name="bookcode"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="저장"></td>
			</tr>
			<tr>
				<td><button id="delBtn">선택삭제</button>
			</tr>
		</thead>
		<tbody id="list"></tbody>
	</table>
</form>
<script src="js/bookList.js"></script>
