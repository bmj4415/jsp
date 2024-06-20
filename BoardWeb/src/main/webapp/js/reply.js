/**
 * reply.js
 */
//댓글목록 출력
svc.replyList(bno, replyListFnc); //onload가 실행되면 이 함수가 실행됨

//댓글등록 이벤트
document.getElementById('addReply').addEventListener('click', addReplyFnc);

//댓글등록 버튼(addReply)을 누르면 실행될 함수(addReplyFnc)
function addReplyFnc() {
	if (!replyer) {
		alert('로그인하세요!');
		return;
	}
	let reply = document.getElementById('reply').value;//댓글 작성하는 input상자의 값(댓글내용)

	if (!reply) {
		alert('댓글 등록')
		return;
	}

	svc.addReply({ replyer, reply, bno }, addReplyCallback); //속성과 값이 같으면 줄일수있음(replyer:replyer, bno:bno 등)

}//end of addReplyFnc

function addReplyCallback() {
	console.log(this.responseText);
	//화면에 댓글정보목록에 추가
	let result = JSON.parse(this.responseText);
	if (result.retCode == 'OK') {
		alert('등록성공');
		let li = cloneRow(result.retVal);
		document.querySelector('div.content>ul').appendChild(li);
		document.getElementById('reply').value = '';//다시 댓글 입력하기 위해 댓글 입력부분을 공백으로 비워주기
	} else {
		alert('실패=> ' + result.retVal);
	}
}


//replyList의 매개값으로 사용될 함수
function replyListFnc() {
	let data = JSON.parse(this.responseText);
	console.log(data);
	data.forEach(reply => {
		let li = cloneRow(reply);
		document.querySelector('div.content>ul').appendChild(li);
	})
}

//댓글정보를 확인 => li태그를 생성(클론)
function cloneRow(reply = {}) {
	let template = document.querySelector('div.content>ul>li:nth-of-type(3)').cloneNode(true);
	console.dir(template);
	template.setAttribute("id", reply.replyNo); //template : 댓글을 복사할 원본. 리스트를 찾아서 삭제하기 위해 id값을 줌
	template.style.display = 'block'; //댓글을 복사할 원본을 숨겨놓음.
	template.querySelector('span:nth-of-type(1)').innerHTML = reply.replyNo;
	template.querySelector('span:nth-of-type(2)').innerHTML = reply.reply;
	template.querySelector('span:nth-of-type(3)').innerHTML = reply.replyer;
	template.querySelector('span:nth-of-type(4)').innerHTML = reply.replyDate;
	template.querySelector("button").setAttribute("data-delrno", reply.replyNo);
	return template;
}

//한건 삭제
function deleteRow(e) {
	let li = e.target.parentElement.parentElement;
	let rno = li.getAttribute('id');
	svc.removeReply(rno, deleteReplyFnc); //removeReply메소드에 매개값으로 전달될 함수. 역할 : 화면에서 1건 삭제하기
	function deleteReplyFnc() {
		let result = JSON.parse(this.responseText);
		if (result.retCode == 'OK') {
			alert(result.retMsg);
			document.getElementById(rno).remove(); //DB에서 성공적으로 삭제되었다면 화면에서도 삭제
		} else {
			alert('Error =>' + result.retMsg);
		}
	}
} //end of deleteRow