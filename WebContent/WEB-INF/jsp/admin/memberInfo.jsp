<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">

	$(document).ready(function() {

		$("#buttonDelete").click(function(){

			if(!confirm("삭제하시겠습니까?")) return;

			$.post("/admin/memberDelete.do" , {id:'${member.id}'} , function(){
				alert("삭제되었습니다.");
				window.location = "/admin/memberList.do";
			});

		});

	});
</script>

<center>
	<h1>회원 정보보기</h1>
	<table width="400" border="1">
		<tr height="40">
			<td align="center" width="150">아이디</td>
			<td>${member.id}</td>
		</tr>
		<tr height="40">
			<td align="center" width="150">이름</td>
			<td>${member.name}</td>
		</tr>
		<tr height="40">
			<td align="center" width="150">이메일</td>
			<td>${member.email}</td>
		</tr>
		<tr height="40">
			<td width="150" align="center">우편번호 검색</td>
			<td>${member.mtemp}</td>
		</tr>
		<tr height="40">
			<td width="150" align="center">주소</td>
			<td>${member.maddress1}<br>${member.maddress2}</td>
		</tr>

		<tr height="40">
			<td align="center" width="150">성별</td>
			<td>${member.gender}</td>
		</tr>

		<tr height="40">
			<td align="center" width="150">생년월일</td>
			<td>${member.birthday}</td>
		</tr>
		<tr height="40">
			<td align="center" width="150">자기소개</td>
			<td>${member.info}</td>
		</tr>
		<tr height="40">
			<td align="center" colspan="2">
				<a href="/admin/memberEdit.do?id=${member.id}" style="color: black;text-decoration: none">
					<input id="buttonEdit" type="button" value="수정">
				</a>
				<a href="#" style="color: black;text-decoration: none">
					<input id="buttonDelete" type="button" value="삭제">
				</a>
				<a href="/admin/memberList.do" style="color: black;text-decoration: none">
					<input type="button" value="목록">
				</a>
			</td>
		</tr>
	</table>
</center>



