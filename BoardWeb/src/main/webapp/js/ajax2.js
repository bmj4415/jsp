/**
 * 
 */

const xhtp = new XMLHttpRequest(); //XMLHttpRequest가 대표적이라 그냥 ajax라고 부르기도 함
xhtp.open('get', 'data/MOCK_DATA.json');
xhtp.send(); //요청
xhtp.onload = function() {
	let data = JSON.parse(xhtp.responseText); //json 문자열 => 자바스크립트 객체로
	//console.log(data);
	//DOM 활용해서 페이지 작성
	data.forEach(function(emp){
		console.log(emp);
		document.getElementById('list').appendChild(makeRow(emp));
	});
}

let fields = ['id', 'first_name', 'email', 'salary'];
function makeRow(obj = {}) {
	let tr = document.createElement('tr');
	fields.forEach(field => {
		let td = document.createElement('td');
		td.innerHTML = obj[field];
		tr.appendChild(td);
	})
	return tr;
}// end of makeRaw()

const xhtm = new XMLHttpRequest();
xhtm.open('get', 'loginForm.do');
xhtm.send();
xhtm.onload = function(){
	console.log(xhtm);
	//document.getElementById('show').innerHTML = xhtm.responseText;
}

console.log('end');