/**
 * replyService.js
 * //목록, 단건조회 , 등록, 삭제
 * //기능들을 종합해놓고 확인하기 쉽게 하려고 
 */

const svc = {
	//목록
	replyList(bno = 1, successCall) { //(번호(생략가능), 실행할 함수)
		const xhtp = new XMLHttpRequest();
		xhtp.open('get', 'replyListJson.do?bno=' + bno); //
		xhtp.send(); //아작스가 요청
		xhtp.onload = successCall; //아작스가 정상적으로 실행되고 나면 결과를 보여줄 이벤트(이벤트가 실행될 때 실행될 함수)
	},
	//단건조회
	getReply() {

	},
	//등록
	addReply(rvo = { replyer, reply, bno }, successCall) { //파라미터 값 자체가 rvo이기 때문에 rvo의 어떤값을 넘길지 rvo.bno 처럼 적어줘야함
		console.log('bno=' + rvo.bno, '&reply=' + rvo.reply, '&replyer=' + rvo.replyer);
		const xhtp = new XMLHttpRequest();
		xhtp.open('post', 'addReply.do'); //내용을 많이 올리고 싶으면 post
		xhtp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');//서버쪽으로 넘어가는 데이터들의 타입, 고정값('Content-Type','application/x-www-form-urlencoded')임
		xhtp.send('bno=' + rvo.bno + '&reply=' + rvo.reply + '&replyer=' + rvo.replyer); //키,값 쌍으로 전달(=> 키 : Content-Type, 값 : application/x-www-form-urlencoded')
		xhtp.onload = successCall;
	},
	//삭제
	removeReply(rno = 1, successCall) {
		const xhtp = new XMLHttpRequest();
		xhtp.open('get', 'removeReply.do?rno=' + rno);
		xhtp.send();
		xhtp.onload = successCall;

	}
}
