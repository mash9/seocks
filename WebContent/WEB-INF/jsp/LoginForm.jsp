<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<c:if test="${msg==1 }">
		<script type="text/javascript">
			alert("���̵� Ȥ�� ��й�ȣ�� Ʋ�Ƚ��ϴ�");
		</script>
	</c:if>
	<center>
		<h2>�α���</h2>
		<br>
		<form action="login1.do" method='post'>
			<table width="400" border='1'>
				<tr>
					<td align='center' width='150' height='40'>���̵�</td>
					<td><input type='text' name='id' size='25'></td>
				</tr>
				<tr>
					<td align='center' width='150' height='40'>�н�����</td>
					<td><input type="password" name='pass' size='25'></td>
				</tr>
				<tr>
					<td align='center' width='150' height='40' colspan='2'><input
						type='submit' value='�α���'></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>