<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="width=device-width, initial-scale=1 , maximum-scale=1 , user-scalable=no" name="viewport">
<!--Bootstarp 3.3.2  -->
<link href="../../../bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<!--Jquery  -->
<script src="../../../jQuery/jQuery-2.1.3.min.js" type="text/javascript"></script>
<!--Bootstarp 3.3.2 js  -->
<script src="../../../bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
	<table width="1200" border="1">
		<tr height="100">
			<td rowspan="3">
				<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">

					<ol class="carousel-indicators">
						<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"></li>
						<li data-target="#carousel-example-generic" data-slide-to="2"></li>
						<li data-target="#carousel-example-generic" data-slide-to="3"></li>
						<li data-target="#carousel-example-generic" data-slide-to="4"></li>
						<li data-target="#carousel-example-generic" data-slide-to="5"></li>
						<li data-target="#carousel-example-generic" data-slide-to="6"></li>
					</ol>

					<!-- slide  -->
					<div class="carousel-inner" role="listbox" width="1000">
						<div class="item active">
							<img alt="" src="../../../img/main1.jpg" width="1000" height="300">
							<div class="carousel-caption"></div>
						</div>
						<div class="item">
							<img alt="" src="../../../img/main2.jpg" width="1000" height="300">
							<div class="carousel-caption"></div>
						</div>
						<div class="item">
							<img alt="" src="../../../img/main3.jpg" width="1000" height="300">
							<div class="carousel-caption"></div>
						</div>
						<div class="item">
							<img alt="" src="../../../img/main4.jpg" width="1000" height="300">
							<div class="carousel-caption"></div>
						</div>
						<div class="item">
							<img alt="" src="../../../img/main5.jpg" width="1000" height="300">
							<div class="carousel-caption"></div>
						</div>
						<div class="item">
							<img alt="" src="../../../img/main6.jpg" width="1000" height="300">
							<div class="carousel-caption"></div>
						</div>
						<div class="item">
							<img alt="" src="../../../img/main7.jpg" width="1000" height="300">
							<div class="carousel-caption"></div>
						</div>

						<a class="left carousel-control" href="#carousel-example-generic"
							role="button" data-slide="prev"><span
							class="glyphicon glyphicon-chevron-left" aria-hidden="true">
						</span> <span class="sr-only">Previous</span></a> <a
							class="right carousel-control" href="#carousel-example-generic"
							role="button" data-slide="next"><span
							class="glyphicon glyphicon-chevron-right" aria-hidden="true">
						</span> <span class="sr-only">Next</span></a>
					</div>
				</div>
			</td>
			
			<td>
				<a href="https://www.facebook.com/Seoks-163892830708764/" target="_blink">
				<img src="../../../img/facebook.JPG" width="200" height="100"></a>
			</td>
		</tr>
		<tr height="100">
			<td>
				<a href="https://twitter.com/" target="_blink">
				<img src="../../../img/twitter.JPG" width="200" height="100"></a>
			</td>
		</tr>
		<tr height="100">
			<td>
				<a href="https://www.instagram.com/" target="_blink">
				<img src="../../../img/instagram.JPG" width="200" height="100"></a>
			</td>
		</tr>
	</table>

	<br><hr color="gray" size="100%">
	<center><img alt="" src="../../../img/CenterLogo.JPG"><br><br><br>

		<table width="1200">
			<c:set var="count" value="0" />
			<!-- 조회순 높은 순서대로 데이터를 4개씩 화면에 보여줌 -->
			<c:forEach var="bean" items="${v }">
				<c:if test="${count % 4 == 0 }">
					<tr>
				</c:if>

				<td width="300" align="center" valign="middle"><a
					href="/shop/info.do?pno=${bean.pno}" style="text-decoration: none">
						<img src="/img/${bean.pmainimg}" width="280" height="300"> <br>
						<br><br><br>
						<font color="gray">상품 이름 : ${bean.pname }</font><br>
						<font color="gray">상품 설명 : ${bean.pinfo }</font><br>
						<font color="gray">상품 가격 : ${bean.pprice }원</font><br>
						<br><br><br>
				</a> <c:set var="count" value="${count + 1 }" /></td>
			</c:forEach>
	</table>
	<br>
	</center>
</body>
</html>