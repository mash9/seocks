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
      <h2>
         <font face="���ü" color="gray"> ��ǰ��� ��������</font>
      </h2>
      <form action="itembuyresult2.do" method="post">
      <table width="1200">
         <tr height="100">
            <td width="200" align="center" valign="middle">�̹���</td>
            <td width="400" align="center" valign="middle">��ǰ��</td>
            <td width="200" align="center" valign="middle">����</td>
            <td width="200" align="center" valign="middle">������</td>
         </tr>
         <tr height="100">
            <td width="200" align="center" valign="middle">
            <img alt="" src="img/${bean.pmainimg}" width="150" height="90"></td>
            <td width="400" align="center" valign="middle">${bean.pname}</td>
            <td width="200" align="center" valign="middle">${qty}</td>
            <td width="200" align="center" valign="middle">${psize}</td>

         </tr>
         <tr height="100">
            <td colspan="4" align="center" valign="middle"><font
               color="red" size="6"> �ѱݾ� : ${bean.pprice*qty}��</font>
            </td>
         </tr>
         <tr height="100">
            <td colspan="4" align="center" valign="middle">
            
            <input type="submit" value="�����ϱ�"></td>
         </tr>
      </table>
      <input type="hidden" name="qty" value="${qty}">
      <input type="hidden" name="psize" value="${psize}">
      <input type="hidden" name="pno" value="${pno}">
      </form>
   </center>

</body>
</html>