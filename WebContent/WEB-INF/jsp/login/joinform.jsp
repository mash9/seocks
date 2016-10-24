<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="/js/jqueryui/jquery-ui.min.js"></script>
<script type="text/javascript" src="/js/jqueryui.config.js"></script>
<link type="text/css" rel="stylesheet" href="/js/jqueryui/jquery-ui.min.css">

	<!-- 다음우편번호 연동서비스 자바스크립트 설정 -->
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script type="text/javascript">

	$(document).ready(function() {

		$(".datePicker").datepicker({dateFormat: 'yy-mm-dd' });
		$(".datePicker").on('focus', function (e) {
			e.preventDefault();
			$(this).datepicker('show');
			$(this).datepicker('widget').css('z-index', 1051);
		});

		//아이디 체크
		$("#buttonIdCheck").click(function(){
			var inputId = $("#inputId").val();

			if(inputId.match(/[^a-zA-Z0-9]/g))
			{
				alert("사용할수 없는 아이디 입니다.");
				return;
			}

			alert("사용가능 아이디 입니다.");
		});


		//우편번호 검색
		$("#buttonPostCheck").click(function(){
			new daum.Postcode(
					{//다음 주소코드실행후
						//선택을 했다면
						oncomplete : function(data) {
							//검색된 우편번호값은 우편번호 텍스트에 보여주시오
							document.getElementsByName("mtemp")[0].value = data.zonecode;
							document.getElementsByName("maddress1")[0].value = data.roadAddress;
						}
					}).open();
		});

		//회원가입
		$("#formRegist").submit(function(event){
			event.preventDefault();
			event.stopImmediatePropagation();

			var form = $("#formRegist");

			var arg = {
				id:$("input[name=id]" , form).val(),
				pass:$("input[name=pass]" , form).val(),
				name:$("input[name=name]" , form).val(),
				email:$("input[name=email]" , form).val(),
				mtemp:$("input[name=mtemp]" , form).val(),
				maddress1:$("input[name=maddress1]" , form).val(),
				maddress2:$("input[name=maddress2]" , form).val(),
				phone:$("input[name=phone]" , form).val(),
				gender:$("input[name=gender]" , form).val(),
				birthday:$("input[name=birthday]" , form).val(),
				info:$("textarea[name=info]" , form).val()
			};

            $.ajax({
                url:"/login/regist.do",
                type:"post",
                data: JSON.stringify(arg),
                contentType:"application/json; charset=utf-8",
                dataType:"json",
                success: function(result){
                    alert("회원가입이 정상적으로 되었습니다.");
					window.location = '/';
                }
            });


		});
	});

	</script>



	<center>
		<h1>회원 가입 양식</h1>

		<form id="formRegist" action="/login/regist.do" method="post">
			<table width="400" border="1" class="form-table">
				<tr height="40">
					<td align="center" width="150">아이디</td>
					<td>
						<input id="inputId" type="text" name="id" size="20" id="id">
						<input id="buttonIdCheck" type="button" value="ID체크">
					</td>
				</tr>
				<tr height="40">
					<td align="center" width="150">패스워드</td>
					<td><input type="password" name="pass" size="30"></td>
				</tr>
				<tr height="40">
					<td align="center" width="150">이름</td>
					<td><input type="text" name="name" size="30"></td>
				</tr>
				<tr height="40">
					<td align="center" width="150">이메일</td>
					<td><input type="email" name="email" size="30"></td>
				</tr>
				<tr height="40">
					<td width="150" align="center">우편번호 검색</td>
					<td><input type="text" name="mtemp" size="20" id="mtemp">
						&nbsp;&nbsp;&nbsp;<input id="buttonPostCheck" type="button" value="검색"></td>
				</tr>
				<tr height="40">
					<td width="150" align="center">주소</td>
					<td><input type="text" name="maddress1" size="30" id="m1"><br>
						<input type="text" name="maddress2" size="30" id="m2"
						placeholder="상세주소"></td>
				</tr>

				<tr height="40">
					<td width="150" align="center">전화번호</td>
					<td><input type="text" name="phone" size="30" id="phone">
					</td>
				</tr>

				<tr height="40">
					<td align="center" width="150">성별</td>
					<td><input type="radio" name="gender" value="남">남
						&nbsp;&nbsp; <input type="radio" name="gender" value="여">여
					</td>
				</tr>

				<tr height="40">
					<td align="center" width="150">생년월일</td>
					<td><input type="text" name="birthday" class="datePicker" size="30"></td>
				</tr>
				<tr height="40">
					<td align="center" width="150">자기소개</td>
					<td><textarea rows="5" cols="30" name="info"></textarea></td>
				</tr>
			</table>

			<div>
				<input type="submit" value=" 회원가입 ">
				<input type="reset" value=" 다시작성 ">
			</div>
		</form>

	</center>
