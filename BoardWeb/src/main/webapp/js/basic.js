
//DOM 연습
	document.querySelector('ul#fruit>li').innerHTML = '사과';//ul>li의 첫번째 값에 사과라는 값을 넣음
	
	//LI 생성
	let li = document.createElement('li'); // li 태그를 만들어 inner속성이 HTML인 오렌지 텍스트를 넣겠다
	li.innerHTML = '<b>오렌지</b>';
	
	document.querySelector('ul#fruit').appendChild(li); //아이디가 fruit인 ul에 li를 자식으로 넣겠다 
	document.querySelector('ul#fruit>li').remove();
	document.querySelector('ul#fruit>li').style.backgroundColor = 'yellow';
	
	console.log(document.querySelectorAll('#fruit>li'));//fruit 아이디의 모든 li를 출력
	let lists = document.querySelectorAll('#fruit>li');
	for(let list of lists) {
		console.log(list)
		//버튼생성
		let btn = document.createElement('button');
		btn.innerText = '삭제';
		btn.setAttribute('class','btn btn-primary');
		btn.addEventListener('click', function(){
			btn.parentElement.remove();
		}); //이벤트 유형, 실행코드
		list.appendChild(btn);
	}
	