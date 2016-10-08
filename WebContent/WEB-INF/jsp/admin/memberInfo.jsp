<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
				<input type="button" value="회원삭제">
				<input type="button" value="정보수정">
			</td>
		</tr>
	</table>
</center>



