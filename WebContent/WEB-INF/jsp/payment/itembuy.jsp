<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

   <center>
      <h2>
         <font face="고딕체" color="gray"> 제품즉시 구매정보</font>
      </h2>

      <h3>주문 내역</h3>
      <br>
      <table width="100%">
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
               <td width="200" align="center" valign="middle">${item.pprice}</td>
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
                       color="red" size="6">총 금액 : ${totalprice}원</font></td>
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
               <td>
                  <input type="text">
               </td>
            </tr>
            <tr>
               <td>이메일</td>
               <td>${user.email}</td>
            </tr>
         </tbody>
      </table>
      <h3>배송지 정보</h3>
      <br>
      <table>
         <tbody>
            <tr>
               <td>배송지 선택</td>
               <td>
                  <input type="text">
               </td>
            </tr>
         </tbody>
      </table>
      <h3>받으시는분</h3>
      <br>
      <table>
         <tbody>
            <tr>
               <td>주소</td>
               <td>
                  <input type="text">
                  <br>
                  <input type="text">
                  <input type="button">
               </td>
            </tr>
            <tr>
               <td>휴대전화</td>
               <td>
                  <input type="text">
               </td>
            </tr>
            <tr>
               <td>배송메세지</td>
               <td>
                  <textarea></textarea>
               </td>
            </tr>
         </tbody>
      </table>
      <h3>결제수단</h3>
      <br>
      <div>
         <label><input type="radio" value="무통장 입금">무통장 입금</label>
         <label><input type="radio" value="카드결제">카드결제</label>
         <label><input type="radio" value="휴대폰 결제">휴대폰 결제</label>
      </div>
      <br>
      <input type="button" value="결제하기">


   </center>
