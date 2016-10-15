<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${title}</title>

	<script type="text/javascript" src="/js/jquery-3.1.0.min.js"></script>
	<script type="text/javascript" src="/js/core.js"></script>

	<link type="text/css" rel="stylesheet" href="/css/styles.css">
	<link type="text/css" rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
	<link type="text/css" rel="stylesheet" href="/css/seocks.css">
</head>
<body>

<center>
	<!--Top, Center, Bottom을 테이블에 정의 -->
	<table width="1200">
		<!-- topoftop -->
		<tr height="60" align="center" valign="middle">
			<td width="1200" align="center"><jsp:include page="/WEB-INF/jsp/include/top.jsp" /></td>
		</tr>
		<!-- top -->
		<tr height="90" align="center" valign="middle">
			<td width="1200" align="center"><jsp:include page="/WEB-INF/jsp/main/top.jsp" /></td>
		</tr>
		<!-- Center-->
		<tr align="center" valign="middle">
			<td width="1200" align="center">
				<c:if test="${page != null}">
					<c:set var="pageUrl" value="/WEB-INF/jsp${page}.jsp"/>
					<jsp:include page="${pageUrl}" />
				</c:if>
			</td>
		</tr>
	</table>
	<br>
	<br>
	<hr color="gray" size="2" width="1200">
	<br>
	<table width="1200">
		<!-- Bottom -->
		<tr height="80" align="center" valign="middle">
			<td width="1200" align="center">

				<table width="100%">
					<tr>
						<td width="10%"></td>
						<td width="37%" align="center"><b><font size="4">CUSTOMER CENTER</font></b></td>
						<td width="5%"></td>
						<td width="37%" align="center"><b><font size="4" >COMPANY INFO</font></b></td>
						<td width="10%"></td>
					</tr>
					<tr>
						<td width="10%"></td>
						<td width="37%" align="center">
							<b><font size="4" color="skyblue" style="고딕체">010-8306-9017</font></b><br><br>
							Mon-Fri 10:00AM - 17:00PM<br>
							LUNCH 12:00PM - 13:00PM<br><br>
							농협 453062-52-207399<br>
							신한 110-332-323062<br>
							예금주 : 송석민<br><br><br>
						</td>
						<td width="5%"></td>
						<td width="37%" align="center">
							COMPANY : Seock's &nbsp;&nbsp;&nbsp; OWNER : 송석민<br>
							ADD : 21, Chungcheong-ro, Dong-gu,<br>
							Daejeon(Health Institute of Technology, 8517)<br>
							CHIEF PRIVACY OFFICER : seocks@naver.com<br>
							COPYRIGHT(C)2016 SEOCK'S SHOP ALL RIGHTS RESERVED.<br>
							DESIGN BY Seock's<br><br><br>
							반품주소 : 대전 광역시 동구 충청로 21,<br>
							CJ대한통운 택배 "Seock's Shop"<br><br><br>
						</td>
						<td width="10%"></td>
					</tr>
				</table>

			</td>
		</tr>
	</table>

</center>

</body>
</html>