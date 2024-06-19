/**
 * 
 */

//목록 가져오기
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
	tr.setAttribute('id', obj.userId); // <tr id = 'user01 ...>
	tr.addEventListener('dblclick', function(e) {
		document.getElementById('myModal').style.display = 'block';
		//선택된 사용자의 이름, 비밀번호를 모달에 출력
		console.log(e, this);
		document.getElementById('modify_name').value = this.children[1].innerHTML;
		document.getElementById('modify_pass').value = this.children[2].innerHTML;
		document.getElementById('modify_id').value = this.children[0].innerHTML;
	})
	fields.forEach(field => {
		let td = document.createElement('td');
		td.innerHTML = obj[field];
		tr.appendChild(td);
	})
	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.setAttribute('data-delid', obj.userId);
	btn.addEventListener('click', removeMemberFnc);

	btn.innerText = '삭제';
	td.appendChild(btn);
	tr.appendChild(td);
	return tr;
}// end of makeRaw()

function removeMemberFnc(e) {
	console.log(e);
	let did = this.dataset.delid;
	console.log(did); //delId가 userId값을 담고 있기 때문에
	//did = e.target.parentElement.parentElement.children[0].innerText;
	let tr = document.getElementById(did);
	const delAjax = new XMLHttpRequest();
	delAjax.open('get', 'delAjax.do?id=' + did);
	delAjax.send();
	delAjax.onload = function() {
		let result = JSON.parse(delAjax.responseText);
		if (result.retCode == 'OK') {
			alert('정상삭제');
			tr.remove();
		}
	}
}

//수정이벤트
document.getElementById('modBtn').addEventListener('click', function() {
	let id = document.getElementById('modify_id').value;
	let name = document.getElementById('modify_name').value;
	let pass = document.getElementById('modify_pass').value;

	//ajax 생성
	//정상적으로 정보가 업데이트 되면 화면 수정
	//수정이 안됐으면 화면수정 x
	const mfields = ['modify_id', 'modify_name', 'modify_pass'];
	let modi = mfields[modify_id];
	
	//let modbtn = document.createElement('modify_id');
	//modbtn.setAttribute('data-modify', modify_id);
	let targetTr = document.getElementById(id);
	//let result = this.dataset.modify;//수정작업의 retCode 결과가 들어있는 것
	if (modi.retCode == 'OK') {
		targetTr.children[1].innerHTML = name;
		targetTr.children[2].innerHTML = pass;
	} else {
		alert('수정실패');
	}

	//모달창 닫기
	document.getElementById('myModal').style.display = 'none';
})



//등록이벤트
document.getElementById('addBtn').addEventListener('click', function() {
	let id = document.getElementById('uid').value;
	let pw = document.getElementById('upw').value;
	let nm = document.getElementById('uname').value;
	let auth = document.getElementById('auth').value;

	const addAjax = new XMLHttpRequest();
	let url = 'addAjax.do?id=' + id + '&pw=' + pw + '&nm=' + nm + '&auth=' + auth;
	addAjax.open('get', url);
	addAjax.send();//페이지 요청
	addAjax.onload = function() {
		let result = JSON.parse(addAjax.responseText);
		if (result.retCode == 'OK') {
			let newMem = { userId: id, userName: nm, userPw: pw, responsibility: auth }
			alert(result.retMsg);
			document.getElementById('list').appendChild(makeRow(newMem));
		} else {
			alert('실패');
		}
	}
})


//중복된 ID가 있는지 체크

document.getElementById('uid').addEventListener('change', function() {
	let checkId = this.value;
	const checkAjax = new XMLHttpRequest();
	checkAjax.open('get', 'checkIdAjax.do?id=' + checkId);
	checkAjax.send();
	checkAjax.onload = function() {
		let result = JSON.parse(checkAjax.responseText);
		if (result.retCode == 'Exist') {
			alert('이미 존재하는 아이디입니다.');
			document.querySelector('#addBtn').disabled = true;
		} else {
			alert('등록 가능한 아이디입니다.');
			document.querySelector('#addBtn').disabled = false;
		}
	}
})


