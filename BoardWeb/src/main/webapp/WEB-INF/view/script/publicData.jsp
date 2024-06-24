<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- publicData.jsp -->
<h3>공공데이터 연습</h3>

주소입력 :
<input type="text" id="searchBox" name="keyword" class="col-sm-6"
	placeholder="ex) '동구' 입력 후 검색버튼을 누르면 동구를 포함한 지역이 검색됩니다">

<button id="scBtn" style="disply:none;">검색</button>

<!-- select 옵션을 달아서 시/도 리스트를 출력함 -->
<select id="searchList">
</select>

<button id="centerDB">센터DB생성</button>

<table class="table">
	<thead>
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
