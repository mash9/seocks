<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">

   $(document).ready(function() {



      $(".item-delete").click(function(){
         if(!confirm("삭제하시겠습니까?")) return;

         var arg = {
            pno: $(this).attr("pno"),
            psize: $(this).attr("psize")
         };

         $.post("/pay/clearCart.do" , arg , function(){
            alert("삭제되었습니다.");
            window.location = "/pay/itembuy.do";
         });
      });

      //우편번호 검색
      $("#buttonPostCheck").click(function(){
         new daum.Postcode(
                 {//다음 주소코드실행후
                    //선택을 했다면
                    oncomplete : function(data) {

                       var table = $("#recvTable");
                       $("input[name=postNumber]" , table).val(data.zonecode);
                       $("input[name=address1]" , table).val(data.roadAddress);
                    }
                 }).open();
      });

      $("#buttonPay").click(function(){
         if(!confirm("결제를 진행하시겠습니까?")) return;


         var arg = {
            name: $("input[name=name]").val(),
            postNumber: $("input[name=postNumber]").val(),
            address1: $("input[name=address1]").val(),
            address2: $("input[name=address2]").val(),
            phone: $("input[name=phone]").val(),
            message: $("#message").text(),
            payType: $("input[name=payType]:checked").val()
         };

         var payItems = [];

         $("#payItemTable > tbody > tr").each(function(index , row){
            payItems.push({
               pno:$("input[name=pno]" , row).val(),
               psize:$("input[name=psize]" , row).val(),
               qty:$("input[name=qty]" , row).val(),
               price:$("input[name=price]" , row).val()
            });
         });

         arg.items = payItems;

         $.ajax({
            url:"/pay/buy.do",
            type:"post",
            data: JSON.stringify(arg),
            contentType:"application/json; charset=utf-8",
            dataType:"json",
            success: function()
            {
               alert("결제되었습니다.");
               window.location = "/";
            }
         });

      });

   });
</script>

   <center>
      <h2>
         <font face="고딕체" color="gray">제품즉시 구매정보</font>
      </h2>
      <br>

      <h3>주문 내역</h3>
      <br>
      <table id="payItemTable" width="100%">
         <thead>
            <tr height="40">
               <th style="text-align: center">이미지</th>
               <th style="text-align: center">상품명</th>
               <th style="text-align: center">수량</th>
               <th style="text-align: center">사이즈</th>
               <th style="text-align: center">가격</th>
               <th style="text-align: center">삭제</th>
            </tr>
         </thead>
         <tbody>
         <c:set var="totalprice" value="0"/>
         <c:forEach var="item" items="${cartList}">
            <tr height="100">
               <input type="hidden" name="pno" value="${item.pno}">
               <input type="hidden" name="psize" value="${item.psize}">
               <input type="hidden" name="qty" value="${item.qty}">
               <input type="hidden" name="price" value="${item.pprice}">

               <td width="200" align="center" valign="middle">
                  <a href="/shop/info.do?pno=${item.pno}">
                     <img src="/img/${item.pmainimg}" style="width: 150px;height: 90px"/>
                  </a>
               </td>
               <td width="400" align="center" valign="middle">
                  <a href="/shop/info.do?pno=${item.pno}">${item.pname}</a>
               </td>
               <td width="200" align="center" valign="middle">${item.qty}</td>
               <td width="200" align="center" valign="middle">${item.psize}</td>
               <td width="200" align="center" valign="middle"><fmt:formatNumber value="${item.pprice}" type="number"/></td>
               <td width="200" align="center" valign="middle">
                  <input class="item-delete" type="button" value="삭제" pno="${item.pno}" psize="${item.psize}">
               </td>
            </tr>

            <c:set var="totalprice" value="${totalprice + item.totalprice}"/>
         </c:forEach>
         </tbody>
         <tfoot>
            <tr>
               <td colspan="6" style="text-align: center"><font
                       color="red" size="6">총 금액 : <fmt:formatNumber value="${totalprice}" type="number"/>원</font></td>
            </tr>
         </tfoot>
      </table>
      <br>
      <br>
      <h3>주문자 정보</h3>
      <br>
      <table style="width: 600px">
         <tbody>
            <tr>
               <td>주문하시는분</td>
               <td>${user.name}</td>
            </tr>
            <tr>
               <td>주소</td>
               <td>${user.maddress1}<br>${user.maddress2}</td>
            </tr>
            <tr>
               <td>휴대전화</td>
               <td></td>
            </tr>
            <tr>
               <td>이메일</td>
               <td>${user.email}</td>
            </tr>
         </tbody>
      </table>

      <h3>받으시는 분</h3>
      <br>
      <table id="recvTable" class="form-table">
         <tbody>
            <tr>
               <td>이름</td>
               <td>
                  <input type="text" name="name" style="padding-bottom: 10px" value="${user.name}">
               </td>
            </tr>
            <tr>
               <td>우편번호</td>
               <td>
                  <input type="text" name="postNumber" style="padding-bottom: 10px" value="${user.mtemp}">
                  <input id="buttonPostCheck" type="button" value="검색">
               </td>
            </tr>
            <tr>
               <td>주소</td>
               <td>
                  <input type="text" name="address1" style="width: 100%;padding-bottom: 10px" value="${user.maddress1}">
                  <br>
                  <input type="text" name="address2" style="width: 100%;padding-bottom: 10px;margin-top: 5px" value="${user.maddress2}">
               </td>
            </tr>
            <tr>
               <td>휴대전화</td>
               <td>
                  <input type="text" name="phone" style="padding-bottom: 10px" value="${user.phone}">
               </td>
            </tr>
            <tr>
               <td>배송메세지</td>
               <td>
                  <textarea id="message" style="height: 100px;width: 100%"></textarea>
               </td>
            </tr>
         </tbody>
      </table>
      <h3>결제수단</h3>
      <br>
      <div>
         <label><input type="radio" value="DEPOSIT" name="payType" checked>무통장 입금</label>
         <label><input type="radio" value="CARD" name="payType" style="margin-left: 10px">카드결제</label>
         <label><input type="radio" value="PHONE" name="payType" style="margin-left: 10px">휴대폰 결제</label>
      </div>
      <br>
      <input id="buttonPay" type="button" value="결제하기">

   </center>
