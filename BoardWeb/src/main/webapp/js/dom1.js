/**
 * dom1.js
 */
document.getElementById('fruit').style.display = "none";
document.querySelector('table.table tr:nth-of-type(5)').setAttribute('align', 'center'); //가운데 정렬하기 위해(테이블 타입의 tr의 5번째 tr)

// 페이지가 로딩되면서 회원 3명이 출력되는 화면 구현
console.log(myMembers);
for (let mem of myMembers) {
	document.getElementById('memberList').appendChild(addRow(mem));
}

//추가 버튼에 클릭 이벤트 등록
document.getElementById('addBtn').addEventListener('click', addMemberFnc); //addBtn을 클릭하면 addMemberFnc 실행
document.getElementById('modBtn').addEventListener('click', modMemberFnc);
document.getElementById('delBtn').addEventListener('click', removeMemberFnc);

//힌트
document.querySelector('thead input[type="checkbox"]').addEventListener('change', allCheckFnc); //체크박스의 값이 change 될 때 allCheckFnc 함수 실행
//this => 1. 이벤트 안에서 사용될 경우(이벤트 대상을 가르킴) 2. 함수(호출한 객체) 3. 객체(객체자신) 4. 윈도우
const obj = {
	name: '홍길동',
	age: 20,
	showinfo() {
		return '이름은 ' + this.name + ', 나이는 ' + this.age;
	}
}

function allCheckFnc() {
	//tbody의 하위에 있는 모든 input[type]="checkbox"의 속성을 변경
	console.log(this.checked); //this : input[type]="checkbox"
	//let checkVal = this.checked;//this의 값이 바뀌기 때문에 this : input[type]="checkbox"일 때의 this값을 checkVal에 저장
	document.querySelectorAll('#memberList tr').forEach(item => {item.children[5].children[0].checked = this.checked}); //this : thead의 checkbox
	//document.querySelectorAll('#memberList tr').forEach(function test(item) {item.children[5].children[0].checked = this.checked}); //여기서의 this : window
	//tbody의 아이디값(#memberList)이  tr인 것들을 모두 가져옴.. item = tr.. 
}

//AA().forEach(BB=>{CC})

//선택삭제
function removeMemberFnc() {
	let targetTr = document.querySelectorAll('#memberList tr');
	for (let tr of targetTr) {
		//console.log(tr.children[5].children[0].checked);
		if (tr.children[5].children[0].checked) {
			tr.remove();
		}
	}
}
function modMemberFnc() {
	let targetTr = document.querySelectorAll('#memberList tr');
	//입력화면의 회원아이디 값을 가져와서 mid 변수저장
	for (let tr of targetTr) {
		console.log(tr.children[0].innerHTML, mid);
		if (tr.children[0].innerHTML == document.getElementById('mid').value) {
			tr.children[1].innerHTML = document.getElementById('mname').value;
			tr.children[2].innerHTML = document.getElementById('mphone').value;
			tr.children[3].innerHTML = document.getElementById('mpoint').value;
		}
	}
}// end of modMemberFnc

function addMemberFnc() {
	const id = document.getElementById('mid').value;
	const name = document.getElementById('mname').value;
	const phone = document.getElementById('mphone').value;
	const point = document.getElementById('mpoint').value;

	if (!id || !name || !phone || !point) {
		alert('필수값을 입력');
		return;
	}

	document.getElementById('memberList').appendChild(addRow({ id, name, phone, point })); //addRow라는 메소드의 매개값으로 전달

	document.getElementById('mid').value = "";
	document.getElementById('mname').value = "";
	document.getElementById('mphone').value = "";
	document.getElementById('mpoint').value = "";
} // end of addMemberFnc()

function addRow(member = { id, name, phone, point }) {
	//tr 생성하고 td를 4개 생성
	const tr = document.createElement('tr');
	tr.addEventListener('click', showDetailFnc);

	for (let prop in member) { //prop : id~poin 4가지 속성
		const td = document.createElement('td');
		td.innerHTML = member[prop];
		tr.appendChild(td); //appendChild(td) : 괄호안의 값을 tr의 하위요소(자식)으로 만들겠다
	}
	//삭제버튼 생성
	//<td><button> 삭제 </button></td>
	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.addEventListener('click', removeTrElement);

	btn.innerText = '삭제';
	td.appendChild(btn);
	tr.appendChild(td);

	//체크박스 생성
	td = document.createElement('td');
	btn = document.createElement('input');
	btn.setAttribute('type', 'checkbox');
	btn.addEventListener('click', allchecking);
	td.appendChild(btn);
	tr.appendChild(td);

	return tr;
} // end of addRow()

//이벤트 핸들러
function removeTrElement(e) {
	console.log('btn', e);
	e.stopPropagation(); //상위요소로 
	this.parentElement.parentElement.remove();
}



function showDetailFnc(e) {
	console.log('tr', e);
	const id = document.getElementById('mid').value = this.children[0].innerText;
	const name = document.getElementById('mname').value = this.children[1].innerText;
	const phone = document.getElementById('mphone').value = this.children[2].innerText;
	const point = document.getElementById('mpoint').value = this.children[3].innerText;
}

function allchecking() {
	let allCheck = document.querySelector('thead input[type="checkbox"]');
	if(!this.checked) {
		allCheck.checked = false;
	}
}
