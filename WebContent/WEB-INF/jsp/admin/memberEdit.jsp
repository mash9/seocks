<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

		$("#buttonSave").click(function(event){

			var form = $("#formEdit");
			var arg = {
				id:$("input[name=id]" , form).val(),
				pass:$("input[name=pass]" , form).val(),
				name:$("input[name=name]" , form).val(),
				email:$("input[name=email]" , form).val(),
				mtemp:$("input[name=mtemp]" , form).val(),
				maddress1:$("input[name=maddress1]" , form).val(),
				maddress2:$("input[name=maddress2]" , form).val(),
				phone:$("input[name=phone]" , form).val(),
				gender:$("input[name=gender]:checked" , form).val(),
				birthday:$("input[name=birthday]" , form).val(),
				info:$("textarea[name=info]" , form).val()
			};

            $.ajax({
                url:"/admin/memberEdit.do",
                type:"post",
                data: JSON.stringify(arg),
                contentType:"application/json; charset=utf-8",
                dataType:"json",
                success: function(result){
                    alert("저장되었습니다.");
					window.location = '/admin/memberInfo.do?id=${member.id}';
                }
            });


		});
	});

</script>



	<center>
		<h1>${member.id} 의 정보수정</h1>

			<table id="formEdit" width="400" border="1" class="form-table">
				<tr height="40">
					<td align="center" width="150">패스워드</td>
					<td>
						<input type="hidden" name="id" value="${member.id}">
						<input type="password" name="pass" size="30" value="${member.pass}">
					</td>
				</tr>
				<tr height="40">
					<td align="center" width="150">이름</td>
					<td><input type="text" name="name" size="30" value="${member.name}"></td>
				</tr>
				<tr height="40">
					<td align="center" width="150">이메일</td>
					<td><input type="email" name="email" size="30" value="${member.email}"></td>
				</tr>
				<tr height="40">
					<td width="150" align="center">우편번호 검색</td>
					<td><input type="text" name="mtemp" size="20" id="mtemp" value="${member.mtemp}">
						&nbsp;&nbsp;&nbsp;<input id="buttonPostCheck" type="button" value="검색"></td>
				</tr>
				<tr height="40">
					<td width="150" align="center">주소</td>
					<td><input type="text" name="maddress1" size="30" id="m1" value="${member.maddress1}">
						<br>
						<input type="text" name="maddress2" size="30" id="m2"
						placeholder="상세주소" value="${member.maddress2}"></td>
				</tr>

				<tr height="40">
					<td width="150" align="center">전화번호</td>
					<td><input type="text" name="phone" size="30" id="phone" value="${member.phone}"></td>
				</tr>



				<tr height="40">
					<td align="center" width="150">성별</td>
					<td><input type="radio" name="gender" value="남" <c:if test="${member.gender == '남'}">checked</c:if> >남
						&nbsp;&nbsp;<input type="radio" name="gender" value="여" <c:if test="${member.gender == '여'}">checked</c:if> >여
					</td>
				</tr>

				<tr height="40">
					<td align="center" width="150">생년월일</td>
					<td><input type="text" name="birthday" class="datePicker" size="30" value="${member.birthday}"></td>
				</tr>
				<tr height="40">
					<td align="center" width="150">자기소개</td>
					<td><textarea rows="5" cols="30" name="info">${member.info}</textarea></td>
				</tr>
			</table>

			<div style="margin-top: 10px">
				<a href="#" style="text-decoration: none;color: black">
					<input id="buttonSave" type="button" value="저장">
				</a>
				<a href="/admin/memberInfo.do?id=${member.id}" style="text-decoration: none;color: black">
					<input id="buttonCancel" type="button" value="취소">
				</a>
			</div>

	</center>
