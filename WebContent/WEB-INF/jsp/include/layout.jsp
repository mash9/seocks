<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${title}</title>

	<script type="text/javascript" src="/js/jquery-3.1.0.min.js"></script>
	<script type="text/javascript" src="/js/core.js"></script>
</head>
<body>

<center>
	<!--Top, Center, Bottom을 테이블에 정의 -->
	<table width="1200">
		<!-- topoftop -->
		<tr height="60" align="center" valign="middle">
			<td width="1200" align="center"><jsp:include page="/WEB-INF/jsp/include/top.jsp" /></td>
		</tr>
		<!-- top -->
		<tr height="90" align="center" valign="middle">
			<td width="1200" align="center"><jsp:include page="/WEB-INF/jsp/main/top.jsp" /></td>
		</tr>
		<!-- Center-->
		<tr align="center" valign="middle">
			<td width="1200" align="center">
				<c:if test="${page != null}">
					<c:set var="pageUrl" value="/WEB-INF/jsp${page}.jsp"/>
					<jsp:include page="${pageUrl}" />
				</c:if>
			</td>
		</tr>
	</table>
	<br>
	<br>
	<hr color="gray" size="2" width="1200">
	<br>
	<table width="1200">
		<!-- Bottom -->
		<tr height="80" align="center" valign="middle">
			<td width="1200" align="center"><jsp:include page="/WEB-INF/jsp/main/bottom.jsp" /></td>
		</tr>
	</table>

</center>

</body>
</html>