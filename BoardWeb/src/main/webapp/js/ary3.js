/**
 * ary3.js
 */
let sum = [10, 20, 30, 40, 50].reduce(function(acc, elem, idx, ary) { // reduce : 타입에 상관없이 반환
	console.log(acc, elem, idx, ary);
	return acc + elem;
}, 0);
console.log('결과 : ', sum);
//reduce(매개값, 초기값) // 두번째부터는 직전의 return 값이 acc의 값으로 쓰임 따라서 어떤값을 리턴하는지에 따라 acc값이 달라짐

//25보다 큰 값들의 합
let sum2 = [10, 20, 30, 40, 50].reduce(function(acc, elem, idx, ary) { // reduce : 타입에 상관없이 반환
	console.log(acc, elem);//, idx, ary);
	if (elem > 25) {
		acc.push(elem);
	}
	return acc;
}, []);
console.log('결과2 : ', sum2);

//max 값 구하기
let sum3 = [10, 20, 30, 40, 50].reduce(function(acc, elem, idx, ary) { // reduce : 타입에 상관없이 반환
	console.log(acc, elem);//, idx, ary);
	if (acc > elem) {
		return acc;
	}
	return elem;
}, 0);
console.log('최대값 : ', sum3);

//min 값 구하기
let sum4 = [10, 20, 30, 40, 50].reduce(function(acc, elem, idx, ary) { // reduce : 타입에 상관없이 반환
	console.log(acc, elem);//, idx, ary);
	if (elem > acc) {
		return acc;
	}
	return elem;
}, 100);
console.log('최소값 : ', sum4);

['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat'].reduce(function(acc, elem) {
	let li = document.createElement('li');
	li.innerHTML = elem;
	acc.appendChild(li);
	
	return acc;
}, document.getElementById('fruit'));
