<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<center>
	<h1>모든 회원 보기</h1>
	<table width="800" border="1">
		<tr height="40">
			<td width="200" align="center">아이디</td>
			<td width="200" align="center">이름</td>
			<td width="200" align="center">이메일</td>
			<td width="200" align="center">생년월일</td>
		</tr>
		<c:forEach var="user" items="${members}">
			<tr height="40">
				<td width="200" align="center"><a
						href="/admin/memberInfo.do?id=${user.id}">${user.id }</a></td>
				<td width="200" align="center">${user.name }</td>
				<td width="200" align="center">${user.email }</td>
				<td width="200" align="center">${user.birthday }</td>
			</tr>
		</c:forEach>
	</table>
</center>