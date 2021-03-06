<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">


	$(document).ready(function() {

		var pno = '${product.pno}';

		$("#buttonCart").click(function(){

			var arg = {
				pno:pno,
				psize:$("#psize").val(),
				qty:$("#qty").val()
			};

			if(isNaN(parseInt(arg.qty)) || parseInt(arg.qty) == 0)
			{
				alert("구매수량을 입력하세요.");
				return;
			}

			$.post("/pay/addCart.do" , arg , function(){
				window.location = "/pay/itemCart.do";
			});
		});

		$("#buttonBuy").click(function(){

			var arg = {
				pno:pno,
				psize:$("#psize").val(),
				qty:$("#qty").val()
			};

			if(isNaN(parseInt(arg.qty)) || parseInt(arg.qty) == 0)
			{
				alert("구매수량을 입력하세요.");
				return;
			}

			$.post("/pay/addCart.do" , arg , function(){
				window.location = "/pay/itembuy.do";
			});
		});
	});

</script>

	<center>
		<h2><font face="고딕체" color="gray"> 제품 상세보기 </font></h2><br>
			<table width="1200">
				<tr>
					<td width="600" rowspan="8" align="center" valign="middle"><img
						alt="" src="/img/${product.pmainimg}" width="500" height="500"></td>
					<td width="200" align="center">제품명</td>
					<td width="400">${product.pname }</td>
				</tr>
				<tr>
					<td width="200" align="center">제품설명</td>
					<td width="400">${product.pinfo }</td>
				</tr>
				<tr>
					<td width="200" align="center">판매가</td>
					<td width="400">${product.pprice}원</td>
				</tr>

				<tr>
					<td width="200" align="center">남은수량</td>

					<c:if test="${product.pocunt == 0}">
						<td width="400"><span style="color: red">재고없음</span></td>
					</c:if>
					<c:if test="${product.pocunt > 0}">
						<td width="400">${product.pocunt}</td>
					</c:if>
				</tr>

				<tr>
					<td width="200" align="center">제품사이즈</td>
					<td width="400">
						<select name="psize" id="psize">
							<option value="Small">Small</option>
							<option value="Medium">Medium</option>
							<option value="Large">Large</option>
						</select>
					</td>
				</tr>

				<tr>
					<td width="200" align="center">구매수량</td>
					<td width="400">
						<input type="number" name="qty" id="qty" size="25">
					</td>
				</tr>
				<tr>
					<td width="200" align="center">&nbsp;</td>
					<td width="400">&nbsp;</td>
				</tr>
				<tr>
					<c:if test="${product.pocunt > 0}">
					<td width="200" align="center" colspan="2">
						<input id="buttonCart" type="button" value="장바구니 담기" style="margin-right: 10px">
						<c:if test="${sessionScope.user != null}">
							<input id="buttonBuy" type="button" value="구매하기">
						</c:if>
					</td>
					</c:if>
				</tr>
			</table>
		<br><br>
		<hr color="gray" size="2">
		<br><br>
		
		<h2><font face="고딕체" color="gray"> 제품 상세보기 </font></h2>
		<br> <img alt="품절되었습니다." src="/img/${product.psubimg}" width="1100">
	</center>