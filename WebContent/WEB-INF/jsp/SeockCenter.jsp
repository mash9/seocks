<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<center>
		<img alt="" src="../../../img/CenterLogo.JPG"> <br>
		<table width="1200">
			<c:set var="count" value="0" />
			<!-- 조회순 높은 순서대로 데이터를 4개씩 화면에 보여줌 -->
			<c:forEach var="bean" items="${v }">
				<c:if test="${count % 4 == 0 }">
					<tr>
				</c:if>

				<td width="300" align="center" valign="middle"><a
					href="baginfo.do?pno=${bean.pno}" style="text-decoration: none">
						<img src="img/${bean.pmainimg}" width="280" height="300"> <br>
						<br>
					<br>
					<br> <font color="gray">상품 이름 : ${bean.pname }</font><br>
						<font color="gray">상품 설명 : ${bean.pinfo }</font><br> <font
						color="gray">상품 가격 : ${bean.pprice }원</font><br> <br>
					<br>
					<br>
				</a> <c:set var="count" value="${count + 1 }" /></td>
			</c:forEach>
		</table>
	</center>

</body>
</html>