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
	async function upload(formData) {
		  try {
		    const response = await fetch("https://example.com/profile/avatar", {
		      method: "PUT",
		      body: formData,
		    });
		    const result = await response.json();
		    console.log("성공:", result);
		  } catch (error) {
		    console.error("실패:", error);
		  }
		}

		const formData = new FormData();
		const fileField = document.querySelector('input[type="file"]');

		formData.append("username", "abc123"); // id 
		formData.append("pw", "abc123"); // pw
		formData.append("avatar", fileField.files[0]);//첫번째 파일에 "avatar"
		

		upload(formData);

</script>
</body>
</html>