

// 목록가져오기
const xthp = new XMLHttpRequest();
xthp.open('get', 'membersAjax.do');
xthp.send();
xthp.onload = function() {
	console.log(xthp);
	let data = JSON.parse(xthp.responseText);
	data.forEach(user => {
		document.getElementById('list').appendChild(makeRow(user))
	})
}
//json 문자열의 필드이름을 활용
const fields = ['userId', 'userName', 'userPw', 'responsibility'];

function makeRow(obj = {}) {
	let tr = document.createElement('tr');
	fields.forEach(field => {
		let td = document.createElement('td');
		td.innerHTML = obj[field];
		tr.appendChild(td);
	})
let td = document.createElement('td');
let btn = document.createElement('btn');


}