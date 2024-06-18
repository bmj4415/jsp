/**
 * ary2.js 
 */
//console.log(employees);
let result = [23, 45, 22, 39, 10, 56].filter(function(item, idx, ary) { //배열의 수만큼 필터함수(true의 전제하에 원하는 조건의 값들만 리턴)를 실행함
	if (item % 2 == 0) {
		return true;
	}
});
console.log(result);

//employees.forEach(console.log);


//급여가 5000이 넘는 여자만 필터링

let over5000 = [];
let over5000Sum = 0;
//over5000 = employees.filter(emp => emp.gender == 'Female' && emp.salary > 5000); //화살표 함수를 이요하여 간단히 표기

let filterFnc = emp => emp.gender == 'Female' && emp.salary > 5000;//화살표 함수로 정리

filterFnc = function(emp, idx) {
	return emp.gender == 'Female' && emp.salary > 5000;
}

employees.filter(function(emp, idx) {
	return emp.gender == 'Female' && emp.salary > 5000;
}).forEach(function(emp) {
	over5000Sum += emp.salary;
});

console.log('조건 만족한 사람의 급여 합 : ', over5000Sum);

// [A,A,A] => [A', A', A']

employees.map(function(elem, idx, ary) {
	const obj = {}
	obj.name = elem.first_name + '-' + elem.last_name;
	obj.salary = elem.salary;
	return obj;
}).forEach(console.log);




