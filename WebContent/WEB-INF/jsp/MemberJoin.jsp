<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	function checkemail() {
		var data = "abcdefghijklmnopqrstuvwxyz0123456789";

		//영문과 숫자가 아닌 문자일시에는 잘못된 아이디라고 표시하고 영문과 숫자가 들어왔다면 아이디 사용가능이라는 alert()을 띄우시오
		var id = document.getElementById('id').value;
		//해당 캐릭터가 없다면
		var flag = true;

		for (var i = 0; i < id.length; i++) {
			var result = data.match(id.charAt(i));
			//캐릭터 하나마다 비교를 해줌(해당 캐릭터가 있는지 비교)
			if (result == null) {//해당 문자가 없다면
				alert("사용할수 없는 아이디 입니다.")
				flag = false;
				break;
			}
		}

		//한번만 사용자에게 알려주어야 하기에 맨 마지막에 출력
		if (flag == true) {
			alert("사용가능 아이디 입니다.")
		}
	}
</script>
<!-- 다음우편번호 연동서비스 자바스크립트 설정 -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js">
</script>
<script>
	//버튼클릭시 실행되는 함수
	function openAddr() {
		daum.postcode
				.load(function() {
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
	}
</script>
</head>
<body>
	<center>
		<h1>회원 가입 양식</h1>

		<form action="memberjoin.do" method="get">
			<table width="400" border="1">
				<tr height="40">
					<td align="center" width="150">아이디</td>
					<td><input type="text" name="id" size="20" id="id"><input
						type="button" onclick="checkemail()" value="ID체크"></td>
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
						&nbsp;&nbsp;&nbsp;<input type="button" value="주소검색"
						onclick="openAddr();"></td>
				</tr>
				<tr height="40">
					<td width="150" align="center">주소</td>
					<td><input type="text" name="maddress1" size="30" id="m1">
						&nbsp; <input type="text" name="maddress2" size="30" id="m2"
						placeholder="상세주소"></td>
				</tr>

				<tr height="40">
					<td align="center" width="150">성별</td>
					<td><input type="radio" name="gender" value="남">남
						&nbsp;&nbsp; <input type="radio" name="gender" value="여">여
					</td>
				</tr>

				<tr height="40">
					<td align="center" width="150">생년월일</td>
					<td><input type="date" name="birthday" size="30"></td>
				</tr>
				<tr height="40">
					<td align="center" width="150">자기소개</td>
					<td><textarea rows="5" cols="30" name="info"></textarea></td>
				</tr>
				<tr height="40">
					<td align="center" colspan="2"><input type="submit"
						value=" 회원가입 "> &nbsp;&nbsp;&nbsp; <input type="reset"
						value=" 다시작성 "></td>
				</tr>
			</table>
		</form>

	</center>
</body>
</html>