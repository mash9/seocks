<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<!-- 다음우편번호 연동서비스 자바스크립트 설정 -->
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script type="text/javascript">

	$(document).ready(function() {

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
		$("#formEdit").submit(function(event){
			event.preventDefault();
			event.stopImmediatePropagation();

			var form = $("#formEdit");

			var arg = {
				id:$("input[name=id]" , form).val(),
				pass:$("input[name=pass]" , form).val(),
				name:$("input[name=name]" , form).val(),
				email:$("input[name=email]" , form).val(),
				mtemp:$("input[name=mtemp]" , form).val(),
				maddress1:$("input[name=maddress1]" , form).val(),
				maddress2:$("input[name=maddress2]" , form).val(),
				gender:$("input[name=gender]:checked" , form).val(),
				birthday:$("input[name=birthday]" , form).val(),
				info:$("textarea[name=info]" , form).val()
			};

            $.ajax({
                url:"/login/edit.do",
                type:"post",
                data: JSON.stringify(arg),
                contentType:"application/json; charset=utf-8",
                dataType:"json",
                success: function(result){
                    alert("저장 되었습니다.");
					window.location = '/';
                }
            });


		});
	});

	</script>



	<center>
		<h1>${user.id} 의 정보수정</h1>

		<form id="formEdit" action="/login/edit.do" method="post">
			<table width="400" border="1">
				<tr height="40">
					<td align="center" width="150">패스워드</td>
					<td><input type="password" name="pass" size="30" value="${user.pass}"></td>
				</tr>
				<tr height="40">
					<td align="center" width="150">이름</td>
					<td><input type="text" name="name" size="30" value="${user.name}"></td>
				</tr>
				<tr height="40">
					<td align="center" width="150">이메일</td>
					<td><input type="email" name="email" size="30" value="${user.email}"></td>
				</tr>
				<tr height="40">
					<td width="150" align="center">우편번호 검색</td>
					<td><input type="text" name="mtemp" size="20" id="mtemp" value="${user.mtemp}">
						&nbsp;&nbsp;&nbsp;<input id="buttonPostCheck" type="button" value="검색"></td>
				</tr>
				<tr height="40">
					<td width="150" align="center">주소</td>
					<td><input type="text" name="maddress1" size="30" id="m1" value="${user.maddress1}">
						<br>
						<input type="text" name="maddress2" size="30" id="m2"
						placeholder="상세주소" value="${user.maddress2}"></td>
				</tr>



				<tr height="40">
					<td align="center" width="150">성별</td>
					<td><input type="radio" name="gender" value="남" <c:if test="${user.gender == '남'}">checked</c:if> >남
						&nbsp;&nbsp;<input type="radio" name="gender" value="여" <c:if test="${user.gender == '여'}">checked</c:if> >여
					</td>
				</tr>

				<tr height="40">
					<td align="center" width="150">생년월일</td>
					<td><input type="date" name="birthday" size="30" value="${user.birthday}"></td>
				</tr>
				<tr height="40">
					<td align="center" width="150">자기소개</td>
					<td><textarea rows="5" cols="30" name="info">${user.info}</textarea></td>
				</tr>
				<tr height="40">
					<td align="center" colspan="2">
						<input type="submit" value="저장">
				</tr>
			</table>
		</form>

	</center>
