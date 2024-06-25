
function allchecking() {
	let allCheck = document.querySelector('thead input[type="checkbox"]');
	if (!this.checked) {
		allCheck.checked = false;
	}
}

function allCheckFnc() {
	console.log(this.checked); // this : input[type="checkbox"]
	document.querySelectorAll('#list tr input[type="checkbox"]').forEach(item => {
		item.checked = this.checked;
	});
}

document.querySelector('thead input[type="checkbox"]').addEventListener('change', allCheckFnc); //체크박스의 값이 change 될 때 allCheckFnc 함수 실행


const xthp = new XMLHttpRequest();
xthp.open('get', 'bookListJson.do');
xthp.send();
xthp.onload = function() {
	//console.log(xthp);
	let data = JSON.parse(xthp.responseText);
	data.forEach(book => {
		document.getElementById('list').appendChild(makeRow(book));
	});
};

// 도서목록 테이블 틀
const fields = ['bookCode', 'bookTitle', 'author', 'company', 'price'];

function makeRow(book = {}) {
	let tr = document.createElement('tr');
	tr.setAttribute('id', book.bookCode);

	//체크박스 생성
	let td = document.createElement('td');
	let btn = document.createElement('input');
	btn.setAttribute('type', 'checkbox');
	btn.addEventListener('click', allchecking);
	td.appendChild(btn);
	tr.appendChild(td);


	fields.forEach(field => {
		let td = document.createElement('td');
		td.innerHTML = book[field];
		tr.appendChild(td);
	});
	td = document.createElement('td');
	btn = document.createElement('button');
	btn.setAttribute('data-delid', book.bookCode);
	btn.addEventListener('click', removeBookFnc);
	btn.innerHTML = '삭제';
	td.appendChild(btn);
	tr.appendChild(td);

	return tr;
}

function removeBookFnc(e) {
	let did = this.dataset.delid;//data-delId
	did = e.target.parentElement.parentElement.children[0].innerText;
	let tr = document.getElementById(did);


	const removeBook = new XMLHttpRequest();
	removeBook.open('get', 'removeBook.do?id=' + did);
	removeBook.send();
	removeBook.onload = function() {
		let result = JSON.parse(removeBook.responseText);
		//console.log(result);
		if (result.retCode == 'OK') {
			alert('정상삭제');
			tr.remove();
		} else {
			alert('삭제실패');
		}
	};
}

//등록

document.getElementById('saveBtn').addEventListener('click', addBookFnc);

function addBookFnc() {
	let code = document.getElementById('code').value;
	let title = document.getElementById('title').value;
	let author = document.getElementById('author').value;
	let company = document.getElementById('company').value;
	let price = document.getElementById('price').value;

	const addBook = new XMLHttpRequest();
	let url = 'addBook.do?code=' + code + '&title=' + title + '&author=' + author + '&company=' + company + '&price=' + price;
	addBook.open('get', url);
	addBook.send();
	addBook.onload = function() {
		let result = JSON.parse(addBook.responseText);
		if (result.retCode == 'OK') {
			let newBook = { bookCode: code, bookTitle: title, author: author, company: company, price: price }; 
			alert(result.retMsg);
			document.getElementById('list').appendChild(makeRow(newBook));

		} else {
			alert(result.retMsg);
		}

	}
}