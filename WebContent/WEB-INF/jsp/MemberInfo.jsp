<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<center>
		<h1>ȸ�� ��������</h1>
		<table width="400" border="1">
			<tr height="40">
				<td align="center" width="150">���̵�</td>
				<td width="250">${bean.id }</td>
			</tr>
			<tr height="40">
				<td align="center" width="150">�̸�</td>
				<td width="250">${bean.name }</td>
			</tr>
			<tr height="40">
				<td align="center" width="150">�̸���</td>
				<td width="250">${bean.email }</td>
			</tr>
			<tr height="40">
				<td align="center" width="150">�ּ�</td>
				<td width="250">${bean.maddress1 } ${bean.maddress2 }</td>
			</tr>
			<tr height="40">
				<td align="center" width="150">�ڱ�Ұ�</td>
				<td width="250"><textarea rows="5" cols="30">${bean.info } </textarea>
				</td>
			</tr>
		</table>
	</center>


</body>
</html>