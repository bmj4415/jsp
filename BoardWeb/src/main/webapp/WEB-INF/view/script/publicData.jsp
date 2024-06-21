<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- publicData.jsp -->
<h3>공공데이터 연습</h3>
<table class="table">
	<thead>
		<tr>
			<th>주소입력 :</th>
			<div id="search">
				<th><input type="text" name="keyword" class="form-control"></th>
				<th><button id="scBtn">검색</button></th>
			</div>
		</tr>
		<tr>
			<th>센터id</th>
			<th>센터명</th>
			<th>연락처</th>
			<th>주소</th>
		</tr>
	</thead>
	<tbody id="centerList"></tbody>
</table>
<script src="js/public.js"></script>
