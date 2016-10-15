<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">

	$(document).ready(function() {

		$("#prevShirt").click(function(){
			matching("13" , false);
		});

		$("#nextShirt").click(function(){
			matching("13" , true);
		});

		$("#prevPants").click(function(){
			matching("15" , false);
		});

		$("#nextPants").click(function(){
			matching("15" , true);
		});

		$("#prevShoes").click(function(){
			matching("17" , false);
		});

		$("#nextShoes").click(function(){
			matching("17" , true);
		});

		function matching(pcate , next)
		{
			var form = $("#matchForm");
			$("input[name=pcate]" , form).val(pcate);
			$("input[name=next]" , form).val(next);
			form.submit();
		}

	});

</script>

<form id="matchForm" action="/shop/match.do" method="post" style="display: none">
	<input name="pcate">
	<input name="next">
</form>


<center>
	<table width="500" style="border-collapse: separate;border-spacing: 10px">
		<tr height="100">
			<td width="100"></td>
			<td width="300" valign="bottom" align="center"><img alt="" src="/img/face.JPG" width="100" height="120"></td>
			<td width="100"></td>
		</tr>
		<tr>
			<td width="100"><a id="prevShirt">이전셔츠</a></td>
			<td width="300" align="center"><img alt="" src="/img/${shirt.pmainimg}" height="150" width="150"></td>
			<td width="100"><a id="nextShirt">다음셔츠</a></td>
		</tr>
		<tr>
			<td width="100"><a id="prevPants">이전바지</a></td>
			<td width="300" align="center"><img alt="" src="/img/${pants.pmainimg}" height="150" width="150"></td>
			<td width="100"><a id="nextPants">다음바지</a></td>
		</tr>
		<tr>
			<td width="100"><a id="prevShoes">이전신발</a></td>
			<td width="300" align="center"><img alt="" src="/img/${shoes.pmainimg}" height="150" width="150"></td>
			<td width="100"><a id="nextShoes">다음신발</a></td>
		</tr>
	</table>
</center>
