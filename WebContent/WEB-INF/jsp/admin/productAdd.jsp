<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="/js/jquery.form.min.js"></script>
<script type="text/javascript">

    $(document).ready(function() {


        $("#formUpload").ajaxForm({
            success: function(){
                alert("상품이 등록되었습니다.")
            }
        });



    });

</script>



<center>

    <br>

    <h2><span style="color: blue;font-family:고딕체">상품등록</span></h2>

    <form id="formUpload" action="/admin/product/add.do" method="post" enctype="multipart/form-data">
    <table class="form-table">
        <tr>
            <td>상품종류</td>
            <td>
                <select name="pno">
                    <c:forEach var="code" items="${codes}">
                        <option value="${code.code}">${code.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>상품명</td>
            <td>
                <input type="text" name="pname">
            </td>

        </tr>
        <tr>
            <td>가격</td>
            <td>
                <input type="number" name="pprice">
            </td>
        </tr>
        <tr>
            <td>상품 이미지</td>
            <td>
                <input type="file" name="pmainimg">
            </td>
        </tr>
        <tr>
            <td>상세 이미지</td>
            <td>
                <input type="file" name="psubimg">
            </td>
        </tr>
        <tr>
            <td>설명</td>
            <td>
                <textarea name="pinfo" style="width: 100%;height: 100px"></textarea>
            </td>
        </tr>
    </table>

    <br>
    <input type="submit" value="등록하기">
    <br>
    </form>

</center>
