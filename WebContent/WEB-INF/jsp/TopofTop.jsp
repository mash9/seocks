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
					<font color="blue" size="3">Guest님 반갑습니다. &nbsp;&nbsp;&nbsp;</font>
					<a href="login.do" style="text-decoration: none"><font color="black" size="3"> 로그인 </font></a>
					&nbsp;&nbsp;&nbsp;
					<a href="memberjoinform.do" style="text-decoration: none"><font color="black" size="3"> 회원가입 </font></a>
					&nbsp;&nbsp;&nbsp;
				</c:if> &nbsp; 
				
				<c:if test="${sessionScope.id != null }">
					<font color="blue" size="3">${sessionScope.id}님 반갑습니다.&nbsp;&nbsp;&nbsp;</font>
					<a href="loginout.do" style="text-decoration: none"><font color="black" size="3"> 로그아웃 </font></a>
					&nbsp;&nbsp;&nbsp;
					<a href="memberjoinform.do" style="text-decoration: none"><font color="black" size="3"> 회원가입 </font></a>
					&nbsp;&nbsp;&nbsp;					
					<a href="cartlist.do" style="text-decoration: none"><font color="black" size="3"> 장바구니 </font></a>
					&nbsp;&nbsp;&nbsp;
					<a href="orderlist.do" style="text-decoration: none"><font color="black" size="3"> 주문조회 </font></a>
					
					<c:if test="${sessionScope.id == 'admin' }">
					<br><br>
						<center>
							<a href="memberlist.do" style="text-decoration: none"><font color="black" size="3"> 회원관리 </font></a>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="itemreserveform.do" style="text-decoration: none"><font color="black" size="3"> 상품등록 </font></a>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
							<a href="buylist.do" style="text-decoration: none"><font color="black" size="3"> 판매현황 </font></a>
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