<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<c:if test="${msg==1 }">
		<script type="text/javascript">
			alert("아이디 혹은 비밀번호가 틀렸습니다");
		</script>
	</c:if>
	<center>
		<h2>로그인</h2>
		<br>
		<form action="login1.do" method='post'>
			<table width="400" border='1'>
				<tr>
					<td align='center' width='150' height='40'>아이디</td>
					<td><input type='text' name='id' size='25'></td>
				</tr>
				<tr>
					<td align='center' width='150' height='40'>패스워드</td>
					<td><input type="password" name='pass' size='25'></td>
				</tr>
				<tr>
					<td align='center' width='150' height='40' colspan='2'><input
						type='submit' value='로그인'></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>