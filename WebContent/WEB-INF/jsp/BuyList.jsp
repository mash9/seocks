<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<center>

		<h2>
			<font face="���ü" color="gray"> �Ǹ���Ȳ </font>
		</h2>
		<br>

		<table width="1200">
			<tr height="40">
				<td width="200" align="center" valign="middle">�̹���</td>
				<td width="400" align="center" valign="middle">��ǰ��</td>
				<td width="200" align="center" valign="middle">����</td>
				<td width="200" align="center" valign="middle">������</td>
				<td width="200" align="center" valign="middle">�Ǹ���</td>			
				<!-- <td width="200" align="center" valign="middle">������</td> -->			
			</tr>
			<c:set var="totalprice" value="0" />
			<c:forEach var="bean" items="${v}">
				<tr height="100">
					<td width="200" align="center" valign="middle"><img alt=""
						src="img/${bean.pmainimg}" width="150" height="90"></td>
					<td width="400" align="center" valign="middle">${bean.pname }</td>
					<td width="200" align="center" valign="middle">${bean.qty }</td>
					<td width="200" align="center" valign="middle">${bean.psize }</td>
					<td width="200" align="center" valign="middle">${bean.reg_date }</td>
					<%-- <td width="200" align="center" valign="middle">${bean.pname }</td> --%>

					<c:set var="totalprice" value="${totalprice + bean.totalprice }" />
				</tr>
			</c:forEach>
			<tr height="100">
				<td colspan="5" align="center" valign="middle"><font
					color="red" size="6">�� �ݾ� : ${totalprice}��</font></td>
			</tr>

		</table>
	</center>
</body>
</html>