/**
 * obj1.js
 */
document.getElementById('dom').remove();

// 등록 이벤트
function addEmp() {
	let employee = {};
	employee.id = document.getElementById('mid').value,
	employee.first_name = document.getElementById('mname').value,
	employee.email = document.getElementById('memail').value,
	employee.salary = document.getElementById('msalary').value

	if (!employee.id || !employee.first_name || !employee.email || !employee.salary) {
		alert('입력하세요!');
		return;
	}
	//목록에 추가하기
	document.querySelector('#list').appendChild(obj.makeRow(employee));
}
document.getElementById('addBtn').addEventListener('click', addEmp);

//속성 설명
//person.height = 167.8; => person 객체에 height 속성을 추가

//'.'과 '[]'의 차이
//let prop = 'age';
//console.log(person.prop); => person의 속성 중 prop을 가지고 옴
//console.log(person[prop]); => person의 age값을 가지고 옴

//const today = new Date();
//today.getFullYear();

//2024-06-19
//Date.prototype.format = function() {
	//let yy = this.getFullYear();
	//let mon = '0' + (this.getMonth() +1);
	//let dd = this.getDate();
	
	//return yy + '-' + mon + '-' + dd;
//}
//console.log(today.format());

const obj = {
	data: '',
	fields: ['id', 'first_name', 'email', 'salary'],
	showList: function(ary = []) {
		ary.forEach((emp, idx) => {
			if (idx < 3) {
				document.querySelector('#list').appendChild(this.makeRow(emp));
			}
		});
	}, makeRow(emp = { id, first_name, email, salary }) {
		let tr = document.createElement('tr');
		this.fields.forEach(fields => {
			let td = document.createElement('td');
			td.innerText = emp[fields];
			tr.appendChild(td);
		});
		return tr;
	}
}


obj.showList(employees);
