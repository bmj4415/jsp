<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 화면(book) -->

<table class="table">
	<tr>
		<th>도서코드</th>
		<td><input type="text" id="code"></td>
	</tr>
	<tr>
		<th>도서명</th>
		<td><input type="text" id="title"></td>
	</tr>
	<tr>
		<th>저자</th>
		<td><input type="text" id="author"></td>
	</tr>
	<tr>
		<th>출판사</th>
		<td><input type="text" id="company"></td>
	</tr>
	<tr>
		<th>금액</th>
		<td><input type="number" id="price"></td>
	</tr>
	<tr>
		<td colspan="2">
			<button id="saveBtn">저장</button>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<button id="delBtn">선택삭제</button>
		</td>
	</tr>
</table>

<div id="bookListUnder">
	<table>
		<thead>
			<tr>
				<th><input type="checkbox"></th>
				<th>도서코드</th>
				<th>도서명</th>
				<th>저자</th>
				<th>출판사</th>
				<th>가격</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody id="list"></tbody>
	</table>
</div>

<script src="js/bookList.js"></script>
