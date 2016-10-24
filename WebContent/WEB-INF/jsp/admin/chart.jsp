<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="/js/jqueryui/jquery-ui.min.js"></script>
<script type="text/javascript" src="/js/jqueryui.config.js"></script>
<link type="text/css" rel="stylesheet" href="/js/jqueryui/jquery-ui.min.css">

<script type="text/javascript">

    $(document).ready(function() {

        $(".datePicker").datepicker({dateFormat: 'yy-mm-dd' });
        $(".datePicker").on('focus', function (e) {
            e.preventDefault();
            $(this).datepicker('show');
            $(this).datepicker('widget').css('z-index', 1051);
        });

        $("#buttonSearch").click(function(){

            var arg = {
                startDate:$("#startDate").val().replace("/-/g" , ""),
                endDate:$("#endDate").val().replace("/-/g" , "")
            }

            window.location = "/admin/chart.do?" + $.param(arg);
        });



    });

</script>



<center>

    <br>

    <h2><span style="color: blue;font-family:고딕체">통계</span></h2>

    <table class="form-table">

        <tr>
            <td>판매기간</td>
            <td>
                <input id="startDate" class="datePicker" type="text" style="margin-right: 10px;width: 100px;text-align: center" value="${startDate}">~
                <input id="endDate" class="datePicker" type="text" style="margin-left: 10px;width: 100px;text-align: center" value="${endDate}">
                <input id="buttonSearch" type="button" value="조회" style="padding: 0px;width: 50px;margin-left: 5px;top: -1px;position: relative">
            </td>

        </tr>
        <tr>
            <td>판매금액</td>
            <td>${salePrice}</td>
        </tr>
        <tr>
            <td>구매금액</td>
            <td>${buyPrice}</td>
        </tr>
        <tr>
            <td>이윤</td>
            <td>${profitPrice}</td>
        </tr>
    </table>

</center>
