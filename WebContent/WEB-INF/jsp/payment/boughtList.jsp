<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<center>

	<br>
	<h2>
		<font face="고딕체" color="blue"> 전체 결제내역 </font>
	</h2>
	<br>
	<table width="1200">
		<tr height="60">
			<td width="200" align="center" valign="middle">이미지</td>
			<td width="400" align="center" valign="middle">상품명</td>
			<td width="200" align="center" valign="middle">수량</td>
			<td width="200" align="center" valign="middle">사이즈</td>
			<td width="200" align="center" valign="middle">가격</td>
		</tr>
		<c:set var="totalprice" value="0"/>
		<c:forEach var="item" items="${groups}">
			<tr height="45">
				<td width="200" align="center" valign="middle">
					<a href="/shop/info.do?pno=${item.pno}">
						<img src="/img/${item.pmainimg}" style="width: 40px;height: 30px"/>
					</a>
				</td>
				<td width="400" align="center" valign="middle">
					<a href="/shop/info.do?pno=${item.pno}">${item.pname}</a>
				</td>
				<td width="200" align="center" valign="middle">${item.qty}</td>
				<td width="200" align="center" valign="middle">${item.psize}</td>
				<td width="200" align="center" valign="middle"><fmt:formatNumber value="${item.price}" type="number"/></td>
			</tr>

			<c:set var="totalprice" value="${totalprice + item.price}"/>
		</c:forEach>
		<tr height="100">
			<td colspan="5" align="center" valign="middle"><font
				color="black" size="6">총 금액 : <fmt:formatNumber value="${totalprice}" type="number"/>원</font></td>
		</tr>

	</table>
	<br>
	<h2>
		<font face="고딕체" color="blue">날짜별 결제내역</font>
	</h2>
	<br>
	<table width="1200">
		<tr height="40">
			<td width="200" align="center" valign="middle">날짜</td>
			<td width="400" align="center" valign="middle">상품명</td>
			<td width="200" align="center" valign="middle">수량</td>
			<td width="200" align="center" valign="middle">사이즈</td>
			<td width="200" align="center" valign="middle">가격</td>
		</tr>
		<c:set var="totalprice" value="0"/>
		<c:forEach var="item" items="${items}">
			<tr height="40">
				<td align="center"><fmt:formatDate value="${item.buyDate}" pattern="yyyy-MM-dd"/></td>
				<td width="400" align="center" valign="middle">
					<a href="/shop/info.do?pno=${item.pno}">${item.pname}</a>
				</td>
				<td width="200" align="center" valign="middle">${item.qty}</td>
				<td width="200" align="center" valign="middle">${item.psize}</td>
				<td width="200" align="center" valign="middle"><fmt:formatNumber value="${item.price}" type="number"/></td>
			</tr>

			<c:set var="totalprice" value="${totalprice + (item.price * item.qty)}"/>
		</c:forEach>
		<tr height="100">
			<td colspan="5" align="center" valign="middle"><font
					color="black" size="6">총 금액 : <fmt:formatNumber value="${totalprice}" type="number"/>원</font></td>
		</tr>

	</table>
</center>
