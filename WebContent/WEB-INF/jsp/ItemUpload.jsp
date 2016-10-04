<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
	function checkpno() {
		var data = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		//영문이 아닌 문자일시에는 잘못된 넘버라고 표시하고 영문이 들어왔다면 넘버 사용가능이라는 alert()을 띄우시오
		var pno = document.getElementById('pno').value;
		if (pno == "") {
			alert("영문으로 작성해주십시오.");
		} else {
			//해당 캐릭터가 없다면
			var flag = true;
			for (var i = 0; i < pno.length; i++) {
				var result = data.match(pno.charAt(i));
				//캐릭터 하나마다 비교를 해줌(해당 캐릭터가 있는지 비교)
				if (result == null) {//해당 문자가 없다면
					alert("영문으로만 작성해주십시오.")
					flag = false;
					break;
				}
			}
			//한번만 사용자에게 알려주어야 하기에 맨 마지막에 출력
			if (flag == true) {
				alert("사용 가능합니다.")
			}
		}
	}
</script>
<body>
	<c:if test="${msg==1 }">
		<script type="text/javascript">
			alert("해당 상품 Pno가 이미 존재 합니다.");
		</script>
	</c:if>
	<center>
		<h1>상품 등록</h1>
		<form action="itemreserve.do" method="post"
			enctype="multipart/form-data">
			<table width="520" border="1">
				<tr height="40">
					<td align="center" width="150">상품번호</td>
					<td><input type="text" name="pno" size="5" id="pno" maxlength="10">&nbsp;&nbsp; 
						<input type="button"onclick="checkpno()" value="체크">
					</td>
				</tr>
				<tr height="40">
					<td align="center" width="150">상품 이름</td>
					<td><input type="text" name="pname" size="15"></td>
				</tr>
				<tr height="40">
					<td align="center" width="150">상품 가격</td>
					<td><input type="text" maxlength="8" name="pprice"
						onKeypress="if(event.keyCode < 45 || event.keyCode > 57) event.returnValue = false;"
						style="IME-MODE: disabled;">원
					</td>
				</tr>
				<tr height="200">
					<td align="center" width="150">상품 설명</td>
					<td><textarea rows="20" cols="40" name="pinfo"></textarea></td>
				</tr>
				<tr height="40">
					<td align="center" width="150">상품 메인 이미지</td>
					<td><input type="file" name="pmainimg" size="25"></td>
				</tr>
				<tr height="40">
					<td align="center" width="150">상품 서브 이미지</td>
					<td><input type="file" name="psubimg" size="25"></td>
				</tr>
				<tr height="40">
					<td align="center" width="150">상품 카테고리</td>
					<td><input type="text" name="pcate" size="15" maxlength="2">&nbsp;&nbsp;
						<input type="button" onclick="checkpcate()" value="확인"><br>
						<font size="2" face="고딕체" color="red">아우터:11, 티셔츠:12, 셔츠:13, 맨투맨:14, 바지:15, 
							<br>트레이닝복:16, 신발:17, 가방:18, 악세사리:19를 입력하세요</font>
					</td>
				</tr>
				
				<tr height="40">
					<td align="center" colspan="3">
						<input type="submit" value="상품 등록"> &nbsp;&nbsp;&nbsp; 
						<input type="reset"value="다시 작성">
					</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>