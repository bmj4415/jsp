/**
 * public.js
 */
let url = 'https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=jTeniTpByugGbOZQw7HXRlwyrYzNJx0yKaH%2FR5%2FDV6wsPMWMXZZ73%2FpXHWEuLe%2FJRjSh1VHgKYdos4JRZU7GyQ%3D%3D'

let centerList = [];
let sidoList = [];
const target = document.querySelector('#centerList');
const selectSido = document.querySelector('#searchList'); //sidoList를 출력할 장소

fetch(url)
	.then(result => result.json())
	.then(result => {
		centerList = result.data;
		result.data.forEach(center => {
			target.appendChild(makeRow(center));
			//console.log(center);
		});

		//시, 도 list 자료 만들기	
		result.data.forEach(center => {
			if (sidoList.indexOf(center.sido) == -1) { // sidoList 배열에 center.sido값이 -1이면(즉, center.sido 값이 포함되어 있지 않으면)
				sidoList.push(center.sido); //sidoList에 center.sido값을 push방법(맨끝부터) 밀어넣기
			}
		})
		sidoList.forEach(sido => {
			let option = document.createElement('option');
			option.value = sido; // 시도 옵션 리스트에서 어떤 시도를 선택하면 그 값이 옵션의 값으로 지정됨
			option.innerHTML = sido; //옵션 리스트를 펼치면 보이는 시도 텍스트
			selectSido.appendChild(option);
		})
	});

//1) 목록 출력하기
let fields = ['id', 'centerName', 'phoneNumber', 'address'];

function makeRow(center) {
	let tr = document.createElement('tr');
	fields.forEach(field => {
		let td = document.createElement('td');
		td.innerHTML = center[field] //center 객체의 특정 속성(:[ ])에 접근
		tr.appendChild(td);
	});
	return tr;
}

//2) 검색
document.getElementById('scBtn').addEventListener('click', function(e) {
	target.innerHTML = ''; //검색결과를 보여줄때 기존 목록을 비우고 검색결과만 출력하기 위해
	let scWord = document.querySelector('#searchBox').value;
	centerList.reduce((acc, center) => { //reduce(콜백함수, 초기값);
		if (center.address.indexOf(scWord) != -1) { //주소값에 중복값이 있으면 즉, 검색한 단어가 주소에 있으면
			let tr = makeRow(center);
			// 검색조건결과를 <b>태그로 감싸기.
			let tr_trans = center.address.replace(scWord, '<b>' + scWord + '</b>'); //replace : 문자열 교체 ==> scWord를 <b>scWord<b>로 교체
			tr.querySelector('td:nth-of-type(4)').innerHTML = tr_trans; //4번째 td : 주소 ==> 주소 데이터에 굵게 표시하라고 교체한 문자열 대입
			acc.appendChild(tr);
		}
		return acc;
	}, target);

})

//3)
selectSido.addEventListener('change', searchBysido); //시도리스트를 바꿀 때마다 searchBysido 함수 실행

function searchBysido() {
	target.innerHTML = ''; //화면비워주기
	centerList.filter(center => center.sido == this.value).forEach(center => target.appendChild(makeRow(center)));
	//console.log(this.value); => 옵션셀렉에서 선택하는 항목 ex)대구광역시
	//필터함수로 center의 sido 속성이 this.value(선택하는 값)와 일치하는 요소들을 필터링하고 그 값 각각을 반복해서 돌면서 테이블에 데이터로 표시해줌
}

