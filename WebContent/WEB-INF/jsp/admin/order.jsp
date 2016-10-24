<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript" src="/js/jqueryui/jquery-ui.min.js"></script>
<script type="text/javascript" src="/js/jqueryui.config.js"></script>
<link type="text/css" rel="stylesheet" href="/js/jqueryui/jquery-ui.min.css">
<script type="text/javascript">

	$(document).ready(function() {

		$(".datePicker").datepicker({dateFormat: 'yy-mm-dd' });
		$(".datePicker").on('focus', function (e) {
			e.preventDefault();
			$(this).datepicker('show');
			$(this).datepicker('widget').css('z-index', 1051);
		});

		$("#buttonSearch").click(function(){

			var arg = {
				startDate:$("#startDate").val().replace("/-/g" , ""),
				endDate:$("#endDate").val().replace("/-/g" , "")
			}

			window.location = "/admin/order.do?" + $.param(arg);
		});

		$("#selectPcate").change(function(){
			$.post("/shop/list.do" , {pcate:$(this).val()} , function(result){

				$("#selectItem").empty();

				$(result).each(function(index , item){

					var option = $("<option></option>");
					option.val(item.pno);
					option.text(item.pname);

					$("#selectItem").append(option);
				});
			});
		});

		$("#buttonOrder").click(function(){

			var qty = parseInt($("#inputQty").val());

			if(qty == 0 || isNaN(qty))
			{
				alert('수량을 입력하세요.');
				return;
			}

			if(!confirm("주문하시겠습니까?"));

			var arg = {
				pno:$("#selectItem").val()
			   ,qty:qty
			}

			$.post("/admin/deal/order.do" , arg , function(){
				alert("주문되었습니다.");
				window.location = "/admin/order.do";
			});


		});

	});

</script>



<center>

	<br>

	<h2><span style="color: blue;font-family:고딕체">주문</span></h2>

	<table class="form-table">
		<tr>
			<td>상품종류</td>
			<td>
				<select id="selectPcate">
					<c:forEach var="code" items="${codes}">
						<option value="${code.code}">${code.name}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>상품명</td>
			<td>
				<select id="selectItem">
					<c:forEach var="item" items="${products}">
						<option value="${item.pno}">${item.pname}</option>
					</c:forEach>
				</select>
			</td>

		</tr>
		<tr>
			<td>수량</td>
			<td>
				<input id="inputQty" type="number" style="width: 50px">
			</td>
		</tr>
	</table>

	<br>
	<input id="buttonOrder" type="button" value="주문하기">
	<br>
	<br>
	<br>
	<h2>
		<font face="고딕체" color="blue">주문내역</font>
	</h2>
	<br>
	<div>
		<input id="startDate" class="datePicker" type="text" style="margin-right: 10px;width: 100px;text-align: center" value="${startDate}">~
		<input id="endDate" class="datePicker" type="text" style="margin-left: 10px;width: 100px;text-align: center" value="${endDate}">
		<input id="buttonSearch" type="button" value="조회" style="padding: 0px;width: 50px;margin-left: 5px;top: -1px;position: relative">
	</div>
	<br>
	<table width="1200">
		<tr height="40">
			<td width="200" align="center" valign="middle">날짜</td>
			<td width="400" align="center" valign="middle">상품명</td>
			<td width="200" align="center" valign="middle">수량</td>
			<td width="200" align="center" valign="middle">상품가격</td>
			<td width="200" align="center" valign="middle">구매가격</td>
		</tr>

		<c:set var="totalprice" value="0"/>
		<c:forEach var="order" items="${orders}">
			<tr height="30">
				<td width="200" align="center" valign="middle"><fmt:formatDate value="${order.dealDate}" pattern="yyyy-MM-dd"/></td>
				<td width="400" align="center" valign="middle">${order.pname}</td>
				<td width="200" align="center" valign="middle">${order.qty}</td>
				<td width="200" align="center" valign="middle"><fmt:formatNumber value="${order.price}" type="number"/></td>
				<td width="200" align="center" valign="middle"><fmt:formatNumber value="${order.totalPrice}" type="number"/></td>
			</tr>

			<c:set var="totalprice" value="${totalprice + order.totalPrice}"/>
		</c:forEach>

		<tr height="100">
			<td colspan="5" align="center" valign="middle"><font
					color="red" size="5">총 금액 : <fmt:formatNumber value="${totalprice}" type="number"/>원</font></td>
		</tr>
	</table>
</center>
