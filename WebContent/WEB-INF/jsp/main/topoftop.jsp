<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table width="1800">
		<tr height="15">
			<td width="30%"></td>
			<td width="40%"></td>
			<td width="30%" align="left" valign="top">
				<c:if test="${sessionScope.id == null }">
					<font color="blue" size="3">Guest�� �ݰ����ϴ�. &nbsp;&nbsp;&nbsp;</font>
					<a href="login.do" style="text-decoration: none"><font color="black" size="3"> �α��� </font></a>
					&nbsp;&nbsp;&nbsp;
					<a href="memberjoinform.do" style="text-decoration: none"><font color="black" size="3"> ȸ������ </font></a>
					&nbsp;&nbsp;&nbsp;
				</c:if> &nbsp; 
				
				<c:if test="${sessionScope.id != null }">
					<font color="blue" size="3">${sessionScope.id}�� �ݰ����ϴ�.&nbsp;&nbsp;&nbsp;</font>
					<a href="loginout.do" style="text-decoration: none"><font color="black" size="3"> �α׾ƿ� </font></a>
					&nbsp;&nbsp;&nbsp;
					<a href="memberjoinform.do" style="text-decoration: none"><font color="black" size="3"> ȸ������ </font></a>
					&nbsp;&nbsp;&nbsp;					
					<a href="cartlist.do" style="text-decoration: none"><font color="black" size="3"> ��ٱ��� </font></a>
					&nbsp;&nbsp;&nbsp;
					<a href="orderlist.do" style="text-decoration: none"><font color="black" size="3"> �ֹ���ȸ </font></a>
					
					<c:if test="${sessionScope.id == 'admin' }">
					<br><br>
						<center>
							<a href="memberlist.do" style="text-decoration: none"><font color="black" size="3"> ȸ������ </font></a>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="itemreserveform.do" style="text-decoration: none"><font color="black" size="3"> ��ǰ��� </font></a>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
							<a href="buylist.do" style="text-decoration: none"><font color="black" size="3"> �Ǹ���Ȳ </font></a>
						</center>
					</c:if>	
				</c:if>
			</td>
		</tr>

		<tr height="50">
			<td width="30%"></td>
			<td width="40%" align="center"><a href="seocksmain.do"
				style="text-decoration: none"> <img src="../../../img/logo.jpg"
					width="600" height="100"></a></td>
			<td width="30%"></td>
		</tr>
	</table>
</body>
</html>