/**
 * 
 */

document.getElementById('fruit').style.display = "none";
document.querySelector('table.table tr:nth-of-type(5)').setAttribute('align', 'center');

//회원 3명 고정으로 출력되는 화면
console.log(myMembers);
for (let mem of myMembers) { //for of : 변수 of 배열
	document.getElementById('memberList').appendChild(addRow(mem));
}

document.getElementById('addBtn').addEventListener('click', addMemberFnc);

function addMemberFnc() {
	const id = document.getElementById('mid').value;
	const name = document.getElementById('mname').value;
	const phone = document.getElementById('mphone').value;
	const point = document.getElementById('mpoint').value;
	
	if (!id || !name || !phone || !point) {
			alert('필수값을 입력');
			return;
		}



function addRow(member = { id, name, phone, point }) {
	//tr 생성하고 td를 4개 생성
	const tr = document.createElement('tr');
	tr.addEventListener('click', showDetailFnc);
	
	for (let prop in member) { //prop : id~poin 4가지 속성
			const td = document.createElement('td');
			td.innerHTML = member[prop];
			tr.appendChild(td); //appendChild(td) : 괄호안의 값을 tr의 하위요소(자식)으로 만들겠다
		}
		}
}
