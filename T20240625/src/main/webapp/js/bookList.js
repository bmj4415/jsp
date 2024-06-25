/**
 * 
 */

const xthp = new XMLHttpRequest();
xthp.open('get', 'bookListJson.do');
xthp.send();
xthp.onload = function() {
	console.log(xthp);
	let data = JSON.parse(xthp.responseText);
	data.forEach(book => {
		document.getElementById('list').appendChild(makeRow(book))
	})
}

const fields = ['bookCode', 'bookTitle', 'author', 'company', 'price', 'createDate'];

function makeRow(book = {}) {
	let tr = document.createElement('tr');
	fields.forEach(field => {
		let td = document.createElement('td');
		td.innerHTML = book[field];
		tr.appendChild(td);
	})
	return tr;
}