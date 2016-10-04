<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<script type="text/javascript">
		$(document).ready(function() {

			$("#formLogin").submit(function(event) {
				event.preventDefault();
				event.stopImmediatePropagation();

				var form = $(this);

				var arg = {
					id:$("input[name=id]" , form).val(),
					pass:$("input[name=pass]" , form).val()
				};

				$.ajax({
					url:"/login/login.do",
					type:"post",
					data: JSON.stringify(arg),
					contentType:"application/json; charset=utf-8",
					dataType:"json",
					success: function(result){
						alert("로그인 되었습니다.");
						window.location = '/';
					}
				});

			});

		});
	</script>

	<center>
		<h2>로그인</h2>
		<br>
		<form id="formLogin" action="/login/login.do" method='post'>
			<table width="400" border='1'>
				<tr>
					<td align='center' width='150' height='40'>아이디</td>
					<td><input type='text' name='id' size='25'></td>
				</tr>
				<tr>
					<td align='center' width='150' height='40'>패스워드</td>
					<td><input type="password" name='pass' size='25'></td>
				</tr>
				<tr>
					<td align='center' width='150' height='40' colspan='2'>
						<input type='submit' value='로그인'>
					</td>
				</tr>
			</table>
		</form>
	</center>
