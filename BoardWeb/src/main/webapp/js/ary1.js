/**
 * ary1.js
 * forEach, filter, map, reduce
 */

//예제 1.
const numAry = [23, 17, 6, 41, 30, 12];
let result = 0;

let evenSum = function(elem, idx, ary) {
	//console.log(elem, idx, ary);
	if (elem % 2 == 0) {
		result += elem;
	}
};

let oddSum = function(elem, idx, ary) {
	//console.log(elem, idx, ary);
	if (idx % 2 == 0) {
		result += elem;
	}
};

//35보다 작은 값들의 합
let less35 = function(elem, idx, ary) {
	//console.log(elem, idx, ary);
	if(elem < 35 ){
		result += elem;
	}
};

numAry.forEach(evenSum);
console.log('짝수합은 ', result);

numAry.forEach(oddSum);
console.log('홀수합은 ', result);

numAry.forEach(less35);
console.log('35보다 작은 값의 합은 ', result);


//예제 2.012310
const dupAry = [10, 27, 32, 55, 27, 10]; 
const ary = [];

//목표 : 중복된 값은 하나만 인식하여 ary라는 배열에 저장(사용 : indexOf(10) => 인덱스값을 반환하는데 중복된 값이 없을 경우 -1을 반환)
dupAry.forEach(function(elem){
	console.log(dupAry.indexOf(elem));
	if(ary.indexOf(elem) == -1){
		ary.push(elem);
	}
});
console.log(ary); //=> 10, 27, 32, 55
