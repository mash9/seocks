<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<center>

		<h2>
			<font face="고딕체" color="gray"> 판매현황 </font>
		</h2>
		<br>

		<table width="1200">
			<tr height="40">
				<td width="200" align="center" valign="middle">이미지</td>
				<td width="400" align="center" valign="middle">상품명</td>
				<td width="200" align="center" valign="middle">수량</td>
				<td width="200" align="center" valign="middle">사이즈</td>
				<td width="200" align="center" valign="middle">판매일</td>			
				<!-- <td width="200" align="center" valign="middle">구매자</td> -->			
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
					color="red" size="6">총 금액 : ${totalprice}원</font></td>
			</tr>

		</table>
	</center>
</body>
</html>