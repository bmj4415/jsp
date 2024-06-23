/**
 * reply.js
 */
//댓글목록 출력
let page = 1;
svc.replyList({ bno, page }, replyListFnc); //onload가 실행되면 이 함수가 실행됨


//댓글등록 이벤트
document.getElementById('addReply').addEventListener('click', addReplyFnc);

//페이징 a 태그를 클릭하면 해당 페이지의 목록 보여주기
document.querySelectorAll('div.pagination a').forEach(item => { //item = a태그
	item.addEventListener('click', function(e) {
		e.preventDefault(); //a태그의 페이지 이동하는 기본값 기능(링크를 클릭하면 화면이 맨 위로 올라가는것)을 차단
		page = item.innerHTML; // item(a태그)이 가지고 있는 페이지 HTML을 page에 넣어주기
		svc.replyList({ bno, page }, replyListFnc);
	})
});



//댓글 건수를 활용해서 건수만큼 페이징을 계산하고 해당 목록을 출력

function makePagingFnc() {
	svc.replyTotalCnt(bno, createPageingList);
}

let pagination = document.querySelector('div.pagination');

//건수를 확인하고 페이징을 계산할 함수 createPageingList 선언

function createPageingList() {
	let totalCnt = this. responseText;
	console.log(this, 'dddddd');
};







//건수를 확인하고 페이징을 계산할 함수 생성
function createPageingList() {
	let totalCnt = this.responseText; //this => xhtp.onload = successCall; => 댓글건수(bno)
	console.log(totalCnt); // 예를들어 632 / 5 => 127 페이지
	let startPage, endPage; //첫페이지, 마지막 페이지
	let prev, next; //이전, 다음
	let realEnd = Math.ceil(totalCnt / 5); //현재 페이지를 기준으로 실제 계산한 페이지 // 예) 127페이지

	endPage = Math.ceil(page / 10) * 10; //현재페이지 /10의 올림 후 *10
	startPage = endPage - 9; //예) 1페이지
	endPage = endPage > realEnd ? realEnd : endPage; addReplyCallback

	prev = startPage > 1;
	next = endPage < realEnd;

	//starPage, endPage, prev, next => a태그를 생성
	pagination.innerHTML = ''; //이전 코드가 있으면 삭제

	if (prev) {
		let aTag = document.createElement('a');
		aTag.setAttribute('data-page', startPage - 1)
		aTag.setAttribute('href', '#');
		aTag.innerHTML = "&laquo";
		pagination.appendChild(aTag);
	}

	for (let p = startPage; p <= endPage; p++) {
		let aTag = document.createElement('a');
		aTag.setAttribute('data-page', p);
		aTag.setAttribute('href', '#');
		aTag.innerHTML = p;
		if (page == p) {
			aTag.className = 'active';
		}
		pagination.appendChild(aTag);
	}

	if (next) {
		let aTag = document.createElement('a');
		aTag.setAttribute('data-page', endPage + 1);
		aTag.setAttribute('href', '#');
		aTag.innerHTML = "&raquo"; //오른쪽 >
		pagination.appendChild(aTag);
	}

	document.querySelectorAll('div.pagination a').forEach(item => { //item = a태그
		item.addEventListener('click', function(e) {
			e.preventDefault(); //a태그의 페이지 이동하는 기본값 기능(링크를 클릭하면 화면이 맨 위로 올라가는것)을 차단
			page = item.dataset.page; // item(a태그)이 가지고 있는 페이지 HTML을 page에 넣어주기 ==> &l/raquo를 쓰면 숫자를 입력받을 수 없기 때문에 data-에 넣어서 이동해줌
			svc.replyList({ bno, page }, replyListFnc);
		})
	});


} // end of createPageingList



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
	//화면에 댓글정보목록에 추가
	let result = JSON.parse(this.responseText);
	console.log(result);
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
	//5개의 댓글을 지워주고 새로운 목록으로 5개 출력
	document.querySelectorAll('div.content>ul>li').forEach((item, idx) => {
		if (idx > 2) { //index값이 0,1,2 였던 a태그들은 놔두고 이후의 a태그들만 지우기 위해
			item.remove();
		}
	});
	let data = JSON.parse(this.responseText);
	console.log(data);
	data.forEach(reply => {
		let li = cloneRow(reply);
		document.querySelector('div.content>ul').appendChild(li);
	})
	makePagingFnc();

} //end of replyListFnc();


//댓글정보를 확인 => li태그를 생성(클론)
function cloneRow(reply = {}) {
	let template = document.querySelector('div.content>ul>li:nth-of-type(3)').cloneNode(true);
	//console.dir(template);
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