<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<script type="text/javascript">
	$(document).ready(function() {


		$(".item-delete").click(function(){
			if(!confirm("삭제 하시겠습니까?")) return;

			var arg = {
				pno: $(this).attr("pno"),
				psize: $(this).attr("psize")
			};

			$.post("/pay/clearCart.do" , arg , function(){
				alert("삭제되었습니다.");
				window.location = "/pay/itemCart.do";
			});
		});

		$("#buttonCartDel").click(function(){
			if(!confirm("장바구니를 비우시겠습니까?")) return;

			$.post("/pay/clearCart.do" , function(){
				alert("삭제되었습니다.");
				window.location = "/pay/itemCart.do";
			});
		});

		$("#buttonBuy").click(function(){
			window.location = "/pay/itembuy.do";
		});

	});
</script>


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
			<td width="200" align="center" valign="middle">삭제</td>
		</tr>
		<c:set var="totalprice" value="0"/>
		<c:forEach var="item" items="${cartList}">
			<tr height="100">
				<td width="200" align="center" valign="middle">
					<a href="/shop/info.do?pno=${item.pno}">
						<img src="/img/${item.pmainimg}" style="width: 150px;height: 90px"/>
					</a>
				</td>
				<td width="400" align="center" valign="middle">
					<a href="/shop/info.do?pno=${item.pno}">${item.pname}</a>
				</td>
				<td width="200" align="center" valign="middle">${item.qty}</td>
				<td width="200" align="center" valign="middle">${item.psize}</td>
				<td width="200" align="center" valign="middle">${item.pprice}</td>
				<td width="200" align="center" valign="middle">
					<input class="item-delete" type="button" value="삭제" pno="${item.pno}" psize="${item.psize}">
				</td>
			</tr>

			<c:set var="totalprice" value="${totalprice + item.totalprice}"/>
		</c:forEach>
		<tr height="100">
			<td colspan="5" align="center" valign="middle"><font
				color="red" size="6">총 금액 : ${totalprice}원</font></td>
		</tr>
		<tr height="100">
			<td colspan="5" align="center" valign="middle">
				<input id="buttonCartDel" type="button" value="전체카트삭제">
				<c:if test="${sessionScope.user != null}">
					<input id="buttonBuy"   type="button" value="전체결제하기">
				</c:if>
			</td>
		</tr>

	</table>
</center>
