<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">


	$(document).ready(function() {

		var pno = '${product.pno}';

		$("#buttonCart").click(function(){
			window.location = "/pay/itemcart.do";
		});

		$("#buttonBuy").click(function(){
			window.location = "/pay/itembuy.do";
		});
	});

	/*
 function msubmit() {
  //상품번호와 Size와 수량을 먼저 읽어드림
  var pno =document.getElementById('pno').value; 
  var psize =document.getElementById('psize').value; 
  var qty =document.getElementById('qty').value; 
  var pname =document.getElementById('pname').value; 
  var pprice =document.getElementById('pprice').value; 
  var pmainimg =document.getElementById('pmainimg').value; 
  
  location.href='itemcart.do?pno='+pno+'&psize='+psize+'&qty='+qty+'&pname='+pname+'&pprice='+pprice+'&pmainimg='+pmainimg;
 }
 */

</script>

	<center>
		<h2><font face="고딕체" color="gray"> 제품 상세보기 </font></h2><br>
			<table width="1200">
				<tr>
					<td width="600" rowspan="7" align="center" valign="middle"><img
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
					<td width="200" align="center">제품사이즈</td>
					<td width="400"><select name="psize" id="psize">
							<option value="Small">Small</option>
							<option value="Medium">Medium</option>
							<option value="Large">Large</option>
					</select></td>
				</tr>
				<tr>
					<td width="200" align="center">구매수량</td>
					<td width="400"><input type="number" name="qty" id="qty"
						size="25"></td>
				</tr>
				<tr>
					<td width="200" align="center">&nbsp;</td>
					<td width="400">&nbsp;</td>
				</tr>
				<tr>
					<td width="200" align="center" colspan="2">
						 <input type="hidden" name="pno" value="${product.pno}" id="pno">
			            <input type="hidden" name="pname" value="${product.pname}" id="pname">
			            <input type="hidden" name="pprice" value="${product.pprice}" id="pprice">
			            <input type="hidden" name="pmainimg" value="${product.pmainimg}" id="pmainimg">
			            <input type="hidden" name="pcate" value="${product.pcate}">
			          
						
						<input id="buttonCart" type="button" value="장바구니" style="margin-right: 10px">
						<input id="buttonBuy"   type="button" value="구매하기">
					</td>
				</tr>
			</table>
		<br><br>
		<hr color="gray" size="2">
		<br><br>
		
		<h2><font face="고딕체" color="gray"> 제품 상세보기 </font></h2>
		<br> <img alt="품절되었습니다." src="/img/${product.psubimg}" width="1100">
	</center>