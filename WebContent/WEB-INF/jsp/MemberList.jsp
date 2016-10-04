<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<center>
		<h1>모든 회원 보기</h1>
		<table width="800" border="1">
			<tr height="40">
				<td width="200" align="center">아이디</td>
				<td width="200" align="center">이름</td>
				<td width="200" align="center">이메일</td>
				<td width="200" align="center">생년월일</td>
			</tr>
			<c:forEach var="bean" items="${v }">
				<tr height="40">
					<td width="200" align="center"><a
						href="memberinfo.do?id=${bean.id}">${bean.id }</a></td>
					<td width="200" align="center">${bean.name }</td>
					<td width="200" align="center">${bean.email }</td>
					<td width="200" align="center">${bean.birthday }</td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>