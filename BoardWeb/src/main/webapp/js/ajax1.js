/**
 * ajax1.js
 * 비동기처리 방식
 */
//setTimeout(실행할 함수, 함수 실행 전 지연시간)
 setTimeout(function() {
	console.log("1번");
 }, 1000);
 
 setTimeout(function() {
	console.log("2번");
 }, 3000);
 
 setTimeout(function() {
	console.log("3번");
 }, 2000);
 
 console.log("end");