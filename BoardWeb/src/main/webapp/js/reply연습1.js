/**
 * 
 */
//댓글 => li 생성
function makeRow(reply = {}) {
	let li = document.createElement('li');
	fields.forEach(field => {
		let span = document.createElement('span');
		span.innerHTML = reply[field];
		if (field == 'reply'){
			width = '4';
		} else if(field == 'replyDate'){
			width = '3';
		} else {
			width = '2';
		}
		span.setAttribute('class','col-sm-' + width);
		li.appendChild(span);
	})
	return li;
}

//아작스 생성

function cloneRow(reply = {}) {
	let template = document.querySelector('div.content>ul>li:nth-of-type(3)').cloneNode(true);
	console.dir(template);
	template.setAttribute("id", reply.replyNo); //template : 댓글 리스트. 리스트를 찾아서 삭제하기 위해 id값을 줌
	template.style.display = 'block';
	template.querySelector('span:nth-of-type(1)').innerHTML = reply.replyNo;
	template.querySelector('span:nth-of-type(2)').innerHTML = reply.reply;
	template.querySelector('span:nth-of-type(3)').innerHTML = reply.replyer;
	template.querySelector('span:nth-of-type(4)').innerHTML = reply.replyDate;
	template.querySelector("button").setAttribute("data-delrno", reply.replyNo);//버튼에 
	return template;
}


//cloneRow();


//한건 삭제
function deleteRow(e){
	// e.target.remove();//e.target.remove();까지만 작성하면 버튼만 삭제됨. 목적은 버튼삭제가 아니라 db+상위요소들을 삭제하는 것임(parent)
	// //정상적으로 삭제됐다면 OK메시지를 받음
	// 서버에 삭제요청 -> ajax -> ajax 객체 생성
	//const removeAjax = new XMLHttpRequest();
	// console.dir(e.target);
	// console.log(e.target.parentElement.parentElement.children[0].innerHTML, "parent"); // e.target => 버튼태그. 버튼태그의 상위-상위
	
	//교수님 방법 
	let li = e.target.parentElement.parentElement;
	let rno = li.getAttribute('id');
	svc.removeReply(rno, deleteReplyFnc); //removeReply메소드에 매개값으로 전달될 함수. 역할 : 화면에서 1건 삭제하기
	function deleteReplyFnc() {
		let result = JSON.parse(this.responseText);
		if(result.retCode == 'OK'){
			alert(result.retMsg);
			document.getElementById(rno).remove(); //DB에서 성공적으로 삭제되었다면 화면에서도 삭제
		} else {
			alert('Error =>' + result.retMsg);
		}
	}
	
	
	
	// console.log(e.target.dataset.delrno, "dataset");
	//let delrno = e.target.dataset.delrno;
	//removeAjax.open("get", `removeReply.do?rn=${delrno}`);
	//removeAjax.send();
	//removeAjax.onload = () => {
		//let data = JSON.parse(removeAjax.responseText);
		// retCode OK => 웹브라우저에서 지우기
		//if(data.retCode == "OK"){
		//	document.getElementById(delrno).remove();
		//}else{
		//	alert("삭제 안됐다.")
		//}
	//}

	// console.log(JSON.parse(removeAjax.responseText));
	// let data = JSON.parse(removeAjax.responseText);
	





const listAjax = new XMLHttpRequest();
listAjax.open('get', 'replyListJson.do?bno=' + bno);
listAjax.send();
listAjax.onload = function() {
	let data = JSON.parse(listAjax.responseText);
	console.log(data);
	data.forEach(reply => {
		//document.querySelector('div.content>ul').appendChild(makeRow(reply));
		document.querySelector('div.content>ul').appendChild(cloneRow(reply));
	})
}
}
