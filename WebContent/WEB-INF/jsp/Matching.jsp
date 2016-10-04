<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<center>
	<table width="500">
	<tr height="100">
		<td width="100"></td>
		<td width="300" valign="bottom" align="center"><img alt="" src="../../../img/face.JPG" width="150" height="100"></td>
		<td width="100"></td>
	</tr>		
	<tr height="150">
		<td width="100"><a href="shirtsbefore.do?tnum=${mbean.tnum-1 }">이전셔츠</a></td>
		<td width="300" align="center"><img alt="" src="img/${mbean.shirtimg }" height="150" width="150"></td>
		<td width="100"><a href="shirtsnext.do?tnum=${mbean.tnum+1 }">다음셔츠</a></td>
	</tr>
	<tr height="150">
		<td width="100"><a href="pantsbefore.do?pnum=${mbean.pnum-1 }">이전바지</a></td>
		<td width="300" align="center"><img alt="" src="img/${mbean.pantsimg }" height="150" width="150"></td>
		<td width="100"><a href="pantsnext.do?pnum=${mbean.pnum+1 }">다음바지</a></td>
	</tr>
	<tr height="150">
		<td width="100"><a href="shoesbefore.do?snum=${mbean.snum-1 }">이전신발</a></td>
		<td width="300" align="center"><img alt="" src="img/${mbean.shoesimg}" height="150" width="150"></td>
		<td width="100"><a href="shoesnext.do?snum=${mbean.snum+1 }">다음신발</a></td>
	</tr>
	</table>	
	</center>
</body>
</html>