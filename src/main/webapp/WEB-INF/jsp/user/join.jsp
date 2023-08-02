<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>
	<div id="wrap">
		<%@include file="/header.jsp" %>
		<section class="contents d-flex justify-content-center">
			<div class="join-box my-4">
				<h1 class="text-center">회원가입</h1>
				<input type="text" class="form-control mt-2" placeholder="아이디" id="idInput">
				<input type="password" class="form-control mt-2" placeholder="비밀번호" id="passwordInput">
				<input type="password" class="form-control mt-2" placeholder="비밀번호 확인" id="passwordConfrimInput">
				<input type="text" class="form-control mt-2" placeholder="이름" id="nameInput">
				<input type="text" class="form-control mt-2" placeholder="이메일" id="emailInput">
				<button type="button" class="btn btn-secondary btn-block mt-2" id="joinBtn">가입</button>
				
			</div>
		</section>
		<footer class="d-flex align-items-center justify-content-center">
			<div class="text-secondary">
				Copyright © Kyung2am 2023
			</div>
		</footer>
	</div>
		
	<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>		
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

	<script>
		$(document).ready(function() {
			
			$("#joinBtn").on("click", function() {
				
				let id = $("#idInput").val();
				let password = $("#passwordInput").val();
				let passwordConfirm = $("#passwordConfrimInput").val();
				let name = $("#nameInput").val();
				let email = $("#emailInput").val();
				
				// 유효성 검사
				
				if(id == ""){
					alert("아이디를 입력해주세요.");
					return false;
				}
				
				if(password == ""){
					alert("비밀번호를 입력해주세요.");
					return false;
				}
				
				if(password != passwordConfirm){
					alert("비밀번호가 일치하지 않습니다.");
					return false;
				}
				
				if(name == ""){
					alert("이름을 입력해주세요.");
					return false;
				}
				
				if(email == ""){
					alert("이메일을 입력해주세요.");
					return false;
				}
				
				$.ajax({
					type:"post"
					,url:"/user/join"
					,data:{"loginId":id, "password":password, "name":name, "email":email}
					,success:function(data){
						if(data.result == "success"){
							location.href = "/user/login-view";
						}else{
							alert("가입 실패!!");
						}
					}
					,fail:function(){
						alert("가입 에러!!")
					}
					
				});
				
			});
			
		});
	</script>
</body>
</html>