<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	function checkemail() {
		var data = "abcdefghijklmnopqrstuvwxyz0123456789";

		//������ ���ڰ� �ƴ� �����Ͻÿ��� �߸��� ���̵��� ǥ���ϰ� ������ ���ڰ� ���Դٸ� ���̵� ��밡���̶�� alert()�� ���ÿ�
		var id = document.getElementById('id').value;
		//�ش� ĳ���Ͱ� ���ٸ�
		var flag = true;

		for (var i = 0; i < id.length; i++) {
			var result = data.match(id.charAt(i));
			//ĳ���� �ϳ����� �񱳸� ����(�ش� ĳ���Ͱ� �ִ��� ��)
			if (result == null) {//�ش� ���ڰ� ���ٸ�
				alert("����Ҽ� ���� ���̵� �Դϴ�.")
				flag = false;
				break;
			}
		}

		//�ѹ��� ����ڿ��� �˷��־�� �ϱ⿡ �� �������� ���
		if (flag == true) {
			alert("��밡�� ���̵� �Դϴ�.")
		}
	}
</script>
<!-- ���������ȣ �������� �ڹٽ�ũ��Ʈ ���� -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js">
</script>
<script>
	//��ưŬ���� ����Ǵ� �Լ�
	function openAddr() {
		daum.postcode
				.load(function() {
					new daum.Postcode(
							{//���� �ּ��ڵ������
								//������ �ߴٸ�
								oncomplete : function(data) {
									//�˻��� �����ȣ���� �����ȣ �ؽ�Ʈ�� �����ֽÿ�    
									document.getElementsByName("mtemp")[0].value = data.zonecode;
									document.getElementsByName("maddress1")[0].value = data.roadAddress;
								}
							}).open();
				});
	}
</script>
</head>
<body>
	<center>
		<h1>ȸ�� ���� ���</h1>

		<form action="memberjoin.do" method="get">
			<table width="400" border="1">
				<tr height="40">
					<td align="center" width="150">���̵�</td>
					<td><input type="text" name="id" size="20" id="id"><input
						type="button" onclick="checkemail()" value="IDüũ"></td>
				</tr>
				<tr height="40">
					<td align="center" width="150">�н�����</td>
					<td><input type="password" name="pass" size="30"></td>
				</tr>
				<tr height="40">
					<td align="center" width="150">�̸�</td>
					<td><input type="text" name="name" size="30"></td>
				</tr>
				<tr height="40">
					<td align="center" width="150">�̸���</td>
					<td><input type="email" name="email" size="30"></td>
				</tr>
				<tr height="40">
					<td width="150" align="center">�����ȣ �˻�</td>
					<td><input type="text" name="mtemp" size="20" id="mtemp">
						&nbsp;&nbsp;&nbsp;<input type="button" value="�ּҰ˻�"
						onclick="openAddr();"></td>
				</tr>
				<tr height="40">
					<td width="150" align="center">�ּ�</td>
					<td><input type="text" name="maddress1" size="30" id="m1">
						&nbsp; <input type="text" name="maddress2" size="30" id="m2"
						placeholder="���ּ�"></td>
				</tr>

				<tr height="40">
					<td align="center" width="150">����</td>
					<td><input type="radio" name="gender" value="��">��
						&nbsp;&nbsp; <input type="radio" name="gender" value="��">��
					</td>
				</tr>

				<tr height="40">
					<td align="center" width="150">�������</td>
					<td><input type="date" name="birthday" size="30"></td>
				</tr>
				<tr height="40">
					<td align="center" width="150">�ڱ�Ұ�</td>
					<td><textarea rows="5" cols="30" name="info"></textarea></td>
				</tr>
				<tr height="40">
					<td align="center" colspan="2"><input type="submit"
						value=" ȸ������ "> &nbsp;&nbsp;&nbsp; <input type="reset"
						value=" �ٽ��ۼ� "></td>
				</tr>
			</table>
		</form>

	</center>
</body>
</html>