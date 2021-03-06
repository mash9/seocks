<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<script type="text/javascript">
		$(document).ready(function() {

			$("#buttonLogout").click(function(event){
				event.preventDefault();
				event.stopImmediatePropagation();

				$.ajax({
					url:"/login/logout.do",
					type:"post",
					contentType:"application/json; charset=utf-8",
					dataType:"json",
					success: function(result){
						alert("로그아웃 되었습니다.")
						window.location = '/';
					}
				});
			});

		});
	</script>

	<div style="width: 100%;margin-top: 10px;text-align: right;font-size: 15px;;">
		<c:if test="${sessionScope.user == null }">
			<a href="/login/login.do" style="text-decoration: none;color: black;margin-right: 5px">로그인</a>
			<a href="/login/join.do" style="text-decoration: none;color: black;margin-right: 5px">회원가입</a>
			<a href="/pay/itemCart.do" style="text-decoration: none;color: black">장바구니</a>
		</c:if>

		<c:if test="${sessionScope.user != null }">
			<span style="color: blue;margin-right: 5px">${sessionScope.userName}님 반갑습니다.</span>
			<a id="buttonLogout" href="#" style="text-decoration: none;color: black;margin-right: 5px">로그아웃</a>
			<a href="/login/edit.do" style="text-decoration: none;color: black;margin-right: 5px">정보수정</a>
			<a href="/pay/itemCart.do" style="text-decoration: none;color: black;margin-right: 5px">장바구니</a>
			<a href="/pay/boughtList.do" style="text-decoration: none;color: black">결제내역</a>

			<c:if test="${sessionScope.userId == 'admin' }">
				<span style="color: black;margin-right: 20px;margin-left: 20px;font-weight: bold">|</span>
				<a href="/admin/memberList.do" style="text-decoration: none;color: #46b8da;margin-right: 5px">회원관리</a>
				<a href="/admin/product/add.do" style="text-decoration: none;color: #46b8da;margin-right: 5px">상품등록</a>
				<a href="/admin/saleList.do" style="text-decoration: none;color: #46b8da;margin-right: 5px">판매현황</a>
				<a href="/admin/order.do" style="text-decoration: none;color: #46b8da;margin-right: 5px">거래처</a>
				<a href="/admin/remain.do" style="text-decoration: none;color: #46b8da;margin-right: 5px">재고</a>
				<a href="/admin/report.do" style="text-decoration: none;color: #46b8da">통계</a>
			</c:if>
		</c:if>
	</div>

	<a href="/" style="text-decoration: none"><img src="/img/logo.jpg" width="600" height="100"></a>

