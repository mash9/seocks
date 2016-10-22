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

			window.location = "/admin/saleList.do?" + $.param(arg);
		});

    });
</script>

<center>

	<br>
	<h2>
		<font face="고딕체" color="blue"> 전체 결제내역 </font>
	</h2>
	<br>
    <div>
        <input id="startDate" class="datePicker" type="text" style="margin-right: 10px;width: 100px;text-align: center" value="${startDate}">~
        <input id="endDate" class="datePicker" type="text" style="margin-left: 10px;width: 100px;text-align: center" value="${endDate}">
        <input id="buttonSearch" type="button" value="조회" style="padding: 0px;width: 50px;margin-left: 5px;top: -1px;position: relative">
    </div>
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
			<td width="200" align="center" valign="middle">아이디</td>
			<td width="400" align="center" valign="middle">상품명</td>
			<td width="200" align="center" valign="middle">수량</td>
			<td width="200" align="center" valign="middle">사이즈</td>
			<td width="200" align="center" valign="middle">가격</td>
		</tr>
		<c:set var="totalprice" value="0"/>
		<c:forEach var="item" items="${items}">
			<tr height="40">
				<td align="center"><fmt:formatDate value="${item.buyDate}" pattern="yyyy-MM-dd"/></td>
                <td width="200" align="center" valign="middle">${item.userId}</td>
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
