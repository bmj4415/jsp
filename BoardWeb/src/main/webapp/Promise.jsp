<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
	async function promiseFunc() {
		
new Promise((resolve, reject) => { //async-await을 이용하여 바로 실행되지 않고 조금 있다가 실행?
	setTimeout(function () { //setTimeout : 비동기함수이기 때문에 1초뒤에 바로 실행
		resolve('OK');
		//reject('Fail');
	}, 1000);
})
.then(function(result) { //resolve 함수가 성공적으로 실행되었을 때 발생할 함수(setTime)
	console.log(result);//OK가 출력
})
.catch(function (err) {
	console.log('err : ', err);
});

	}
// promise.then(function(result) { //resolve 함수가 성공적으로 실행되었을 때 발생할 함수(setTime)
// 	console.log(result);//OK가 출력
// })
// .catch(function (err) {
// 	console.log(err);
// });
// 	}
	
 	promiseFunc();
	

</script>
</body>
</html>