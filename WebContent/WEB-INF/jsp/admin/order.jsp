<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<center>

	<br>

	<h2><span style="color: blue;font-family:고딕체">주문</span></h2>

	<table class="form-table">
		<tr>
			<td>상품종류</td>
			<td>
				<select>
					<c:forEach var="code" items="${codes}">
						<option value="${code.code}">${code.name}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>상품명</td>
			<td>
				<select>
					<c:forEach var="item" items="${products}">
						<option value="${item.pno}">${item.pname}</option>
					</c:forEach>
				</select>
			</td>

		</tr>
		<tr>
			<td>수량</td>
			<td>
				<input type="number" style="width: 50px">
			</td>
		</tr>
	</table>

	<br>
	<input type="button" value="주문하기" style="font-size: 15px">
	<br>
	<br>
	<br>
	<h2>
		<font face="고딕체" color="blue">주문내역</font>
	</h2>
	<br>
	<table width="1200">
		<tr height="40">
			<td width="200" align="center" valign="middle">날짜</td>
			<td width="400" align="center" valign="middle">상품명</td>
			<td width="200" align="center" valign="middle">수량</td>
			<td width="200" align="center" valign="middle">상품가격</td>
		</tr>
	</table>
</center>
