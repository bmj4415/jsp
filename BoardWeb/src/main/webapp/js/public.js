/**
 * public.js
 */
let url = 'https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=jTeniTpByugGbOZQw7HXRlwyrYzNJx0yKaH%2FR5%2FDV6wsPMWMXZZ73%2FpXHWEuLe%2FJRjSh1VHgKYdos4JRZU7GyQ%3D%3D'
let centerList = [];
const target = document.querySelector('#centerList');//하위목록
console.log(target);//tbody

fetch(url)
	.then(result => result.json()) //json 파싱 //[{"id": 1, "center.."},{},{}] -> [{},{}]
	.then(result => {
		result.data.forEach(center => {
			centerList = result.data;
			//console.log(result.data);
			//console.log(center);
			target.appendChild(makeRow(center));
		});
	});


let fields = ['id', 'centerName', 'phoneNumber', 'address'];

function makeRow(center) { //fields에 따라 td들을 forEach해주고 그 td들에 자료 넣기
	let tr = document.createElement('tr');
	fields.forEach(field => {
		let td = document.createElement('td');
		td.innerHTML = center[field];
		tr.appendChild(td);
	})
	return tr;
}


//검색기능
//검색창에 키워드를 넣고 버튼(scBtn)을 누르면 자료에서 키워드값(address)을 찾아서 일치하는 데이터 출력
//input상자에 입력값을 읽어오기

document.getElementById('scBtn').addeaddEventListener('click', searchFnc);

function searchFnc(e) {
	let searchWord = document.querySelector('#search').values;
	centerList.forEach(center => {
		
	})
	}
