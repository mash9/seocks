<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
	function checkpno() {
		var data = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		//������ �ƴ� �����Ͻÿ��� �߸��� �ѹ���� ǥ���ϰ� ������ ���Դٸ� �ѹ� ��밡���̶�� alert()�� ���ÿ�
		var pno = document.getElementById('pno').value;
		if (pno == "") {
			alert("�������� �ۼ����ֽʽÿ�.");
		} else {
			//�ش� ĳ���Ͱ� ���ٸ�
			var flag = true;
			for (var i = 0; i < pno.length; i++) {
				var result = data.match(pno.charAt(i));
				//ĳ���� �ϳ����� �񱳸� ����(�ش� ĳ���Ͱ� �ִ��� ��)
				if (result == null) {//�ش� ���ڰ� ���ٸ�
					alert("�������θ� �ۼ����ֽʽÿ�.")
					flag = false;
					break;
				}
			}
			//�ѹ��� ����ڿ��� �˷��־�� �ϱ⿡ �� �������� ���
			if (flag == true) {
				alert("��� �����մϴ�.")
			}
		}
	}
</script>
<body>
	<c:if test="${msg==1 }">
		<script type="text/javascript">
			alert("�ش� ��ǰ Pno�� �̹� ���� �մϴ�.");
		</script>
	</c:if>
	<center>
		<h1>��ǰ ���</h1>
		<form action="itemreserve.do" method="post"
			enctype="multipart/form-data">
			<table width="520" border="1">
				<tr height="40">
					<td align="center" width="150">��ǰ��ȣ</td>
					<td><input type="text" name="pno" size="5" id="pno" maxlength="10">&nbsp;&nbsp; 
						<input type="button"onclick="checkpno()" value="üũ">
					</td>
				</tr>
				<tr height="40">
					<td align="center" width="150">��ǰ �̸�</td>
					<td><input type="text" name="pname" size="15"></td>
				</tr>
				<tr height="40">
					<td align="center" width="150">��ǰ ����</td>
					<td><input type="text" maxlength="8" name="pprice"
						onKeypress="if(event.keyCode < 45 || event.keyCode > 57) event.returnValue = false;"
						style="IME-MODE: disabled;">��
					</td>
				</tr>
				<tr height="200">
					<td align="center" width="150">��ǰ ����</td>
					<td><textarea rows="20" cols="40" name="pinfo"></textarea></td>
				</tr>
				<tr height="40">
					<td align="center" width="150">��ǰ ���� �̹���</td>
					<td><input type="file" name="pmainimg" size="25"></td>
				</tr>
				<tr height="40">
					<td align="center" width="150">��ǰ ���� �̹���</td>
					<td><input type="file" name="psubimg" size="25"></td>
				</tr>
				<tr height="40">
					<td align="center" width="150">��ǰ ī�װ�</td>
					<td><input type="text" name="pcate" size="15" maxlength="2">&nbsp;&nbsp;
						<input type="button" onclick="checkpcate()" value="Ȯ��"><br>
						<font size="2" face="���ü" color="red">�ƿ���:11, Ƽ����:12, ����:13, ������:14, ����:15, 
							<br>Ʈ���̴׺�:16, �Ź�:17, ����:18, �Ǽ��縮:19�� �Է��ϼ���</font>
					</td>
				</tr>
				
				<tr height="40">
					<td align="center" colspan="3">
						<input type="submit" value="��ǰ ���"> &nbsp;&nbsp;&nbsp; 
						<input type="reset"value="�ٽ� �ۼ�">
					</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>