<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript" src="/js/jqueryui/jquery-ui.min.js"></script>
<script type="text/javascript" src="/js/jqueryui.config.js"></script>
<link type="text/css" rel="stylesheet" href="/js/jqueryui/jquery-ui.min.css">
<script type="text/javascript">

	$(document).ready(function() {



	});

</script>



<center>

	<br>

	<h2><span style="color: blue;font-family:고딕체">재고현황</span></h2>

	<table width="1200">
		<tr height="40">
			<td width="400" align="center" valign="middle">종류</td>
			<td width="400" align="center" valign="middle">상품명</td>
			<td width="200" align="center" valign="middle">상품가격</td>
			<td width="200" align="center" valign="middle">수량</td>
			<td width="200" align="center" valign="middle">구매가격</td>
		</tr>

		<c:set var="totalprice" value="0"/>
		<c:forEach var="item" items="${products}">
			<tr height="30">

				<c:if test="${item.pcate == '11'}">
					<td width="400" align="center" valign="middle">Outer</td>
				</c:if>
				<c:if test="${item.pcate == '12'}">
					<td width="400" align="center" valign="middle">T-shirt</td>
				</c:if>
				<c:if test="${item.pcate == '13'}">
					<td width="400" align="center" valign="middle">Shirt</td>
				</c:if>
				<c:if test="${item.pcate == '14'}">
					<td width="400" align="center" valign="middle">Men to Men</td>
				</c:if>
				<c:if test="${item.pcate == '15'}">
					<td width="400" align="center" valign="middle">Pants</td>
				</c:if>
				<c:if test="${item.pcate == '16'}">
					<td width="400" align="center" valign="middle">Training</td>
				</c:if>
				<c:if test="${item.pcate == '17'}">
					<td width="400" align="center" valign="middle">Shoes</td>
				</c:if>
				<c:if test="${item.pcate == '18'}">
					<td width="400" align="center" valign="middle">Bag</td>
				</c:if>
				<c:if test="${item.pcate == '19'}">
					<td width="400" align="center" valign="middle">Accessory</td>
				</c:if>

				<td width="400" align="center" valign="middle">${item.pname}</td>
				<td width="200" align="center" valign="middle"><fmt:formatNumber value="${item.pprice}" type="number"/></td>
				<td width="200" align="center" valign="middle">${item.pocunt}</td>
				<td width="200" align="center" valign="middle"><fmt:formatNumber value="${item.pprice * item.pocunt}" type="number"/></td>
			</tr>
			<c:set var="totalprice" value="${totalprice + (item.pprice * item.pocunt)}"/>
		</c:forEach>

		<tr height="100">
			<td colspan="5" align="center" valign="middle"><font
					color="red" size="5">총 금액 : <fmt:formatNumber value="${totalprice}" type="number"/>원</font></td>
		</tr>
	</table>
</center>
