<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<center>

		<h2>
			<font face="고딕체" color="gray"> 장바구니 </font>
		</h2>
		<br>

		<table width="1200">
			<tr height="40">
				<td width="200" align="center" valign="middle">이미지</td>
				<td width="400" align="center" valign="middle">상품명</td>
				<td width="200" align="center" valign="middle">수량</td>
				<td width="200" align="center" valign="middle">사이즈</td>
				<td width="200" align="center" valign="middle">가격</td>
			</tr>
			<c:set var="totalprice" value="0" />
			<c:forEach var="bean" items="${cart}">
				<tr height="100">
					<td width="200" align="center" valign="middle"><img alt=""
						src="img/${bean.pmainimg}" width="150" height="90"></td>
					<td width="400" align="center" valign="middle">${bean.pname }</td>
					<td width="200" align="center" valign="middle">${bean.qty }</td>
					<td width="200" align="center" valign="middle">${bean.psize }</td>
					<td width="200" align="center" valign="middle">${bean.pprice*bean.qty }</td>
					<td width="200" align="center" valign="middle"><input
						type="button" value="삭제"
						onclick="location.href='cartdel.do?pno=${bean.pno}&gubun=1'">
					</td>
					<td width="200" align="center" valign="middle"><input
						type="button" value="결제"
						onclick="location.href='itembuy2.do?pno=${bean.pno}&qty=${bean.qty }&psize=${bean.psize }'">
					</td>
					<c:set var="totalprice" value="${totalprice + bean.totalprice }" />
				</tr>
			</c:forEach>
			<tr height="100">
				<td colspan="5" align="center" valign="middle"><font
					color="red" size="6">총 금액 : ${totalprice}원</font></td>
			</tr>
			<tr height="100">
				<td colspan="5" align="center" valign="middle">
					<input type="button" value="전체카트삭제" onclick="location.href='cartdel.do?gubun=2'"> 
					<!-- <input type="button" value="전체결제하기" onclick="location.href='itemallbuyresult.do'"> -->
				</td>
			</tr>

		</table>
	</center>
</body>
</html>