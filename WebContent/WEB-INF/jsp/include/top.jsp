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
						window.location = '/';
					}
				});
			});

		});
	</script>



	<table width="1800">
		<tr height="15">
			<td width="30%"></td>
			<td width="40%"></td>
			<td width="30%" align="left" valign="top">
				<c:if test="${sessionScope.user == null }">
					<font color="blue" size="3">Guest님 반갑습니다. &nbsp;&nbsp;&nbsp;</font>
					<a href="/login/login.do" style="text-decoration: none"><font color="black" size="3"> 로그인 </font></a>
					&nbsp;&nbsp;&nbsp;
					<a href="/login/join.do" style="text-decoration: none"><font color="black" size="3"> 회원가입 </font></a>
					&nbsp;&nbsp;&nbsp;
				</c:if> &nbsp; 
				
				<c:if test="${sessionScope.user != null }">
					<font color="blue" size="3">${sessionScope.userName}님 반갑습니다.&nbsp;&nbsp;&nbsp;</font>
					<a id="buttonLogout" href="/login/logout.do" style="text-decoration: none"><font color="black" size="3"> 로그아웃 </font></a>
					&nbsp;&nbsp;&nbsp;
					<a href="/login/join.do" style="text-decoration: none"><font color="black" size="3"> 회원가입 </font></a>
					&nbsp;&nbsp;&nbsp;					
					<a href="cartlist.do" style="text-decoration: none"><font color="black" size="3"> 장바구니 </font></a>
					&nbsp;&nbsp;&nbsp;
					<a href="orderlist.do" style="text-decoration: none"><font color="black" size="3"> 주문조회 </font></a>
					
					<c:if test="${sessionScope.userId == 'admin' }">
					<br><br>
						<center>
							<a href="memberlist.do" style="text-decoration: none"><font color="black" size="3"> 회원관리 </font></a>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="itemreserveform.do" style="text-decoration: none"><font color="black" size="3"> 상품등록 </font></a>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
							<a href="buylist.do" style="text-decoration: none"><font color="black" size="3"> 판매현황 </font></a>
						</center>
					</c:if>	
				</c:if>
			</td>
		</tr>

		<tr height="50">
			<td width="30%"></td>
			<td width="40%" align="center"><a href="/main.do" style="text-decoration: none">
				<img src="/img/logo.jpg" width="600" height="100"></a></td>
			<td width="30%"></td>
		</tr>
	</table>
