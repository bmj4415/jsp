/**
 * calendar.js
 */
document.querySelectorAll('.container-fluid h3').forEach(item => item.remove());// 노드리스트 타입

document.querySelectorAll('.container-fluid table.table').forEach(item => item.remove());// 노드리스트 타입

document.getElementById('fruit').remove();

//달력을 첫째날 계산하는 함수, 마지막날(30일) 계산 함수

function getFirstDay(month = 6) { //첫번째 일요일의 위치를 잡기 위한 함수
	switch (month) {
		case 5: //5월달
			return 4;
		case 7: //7월달
			return 2;
	}
	return 7;
}
function getLastDate(month = 6) {
	switch (month) {
		case 5:
		case 7:
			return 31;
	}
	return 30;
}

//월을 변경하면 달력을 출력하는 이벤트를 등록(selectMonth)
//document.querySelector('#selectMonth option[value]').addEventListener('change',cgCal());


function cgCal(value) {
	console.log(value);
	makeCalendar(parseInt(value.target.value))
}

document.querySelector('#selectMonth').addEventListener('change', cgCal);


makeCalendar(6);
function makeCalendar(month = 6) {
	let firstDay = getFirstDay(month); //1일의 위치를 정해주기 위해
	let lastDate = getLastDate(month); //월의 마지막날을 계산하는 함수

	document.getElementById('show').innerHTML = ''; //비워주는 작업


	//table 생성. border="2"
	let tbl = document.createElement('table');
	tbl.setAttribute('border', '2');
	let thd = document.createElement('thead');
	let tbd = document.createElement('tbody');

	//thead에 들어갈 내용(하위요소)
	let days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat'];
	let tr = document.createElement('tr');
	days.forEach(day => {
		let td = document.createElement('th');
		td.innerHTML = day;
		tr.appendChild(td);
	})
	thd.appendChild(tr);


	//tbody(1~30)에 들어갈 내용(하위요소)
	tr = document.createElement('tr');

	//빈 공간(빈 날짜) 생성
	for (let i = 1; i < firstDay; i++) { //빈칸 6칸을 넣고 첫 시작 1이 7번째 자리
		let td = document.createElement('td');
		tr.appendChild(td);
	}

	//실제 날짜 출력
	for (let d = 1; d <= lastDate; d++) {
		let td = document.createElement('td');
		td.innerHTML = d;
		tr.appendChild(td);
		if ((d + firstDay - 1) % 7 == 0) { //7일마다 줄바꿈
			tbd.appendChild(tr);
			tr = document.createElement('tr') //줄바꿈
			td.bgColor = 'blue';
		} else if ((d + firstDay - 1) % 7 == 1) {
			td.bgColor = 'red';
		}
	}
	tbd.appendChild(tr);
	//tbl - thd, tbd 관계
	tbl.appendChild(thd);
	tbl.appendChild(tbd);

	document.getElementById('show').appendChild(tbl);
}

