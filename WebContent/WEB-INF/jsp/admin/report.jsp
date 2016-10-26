<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript" src="/js/jqueryui/jquery-ui.min.js"></script>
<script type="text/javascript" src="/js/jqueryui.config.js"></script>
<script type="text/javascript" src="/js/Chart.min.js"></script>

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

            window.location = "/admin/report.do?" + $.param(arg);
        });



    });

</script>



<center>

    <br>

    <h2><span style="color: blue;font-family:고딕체">통계</span></h2>

    <div>
        <input id="startDate" class="datePicker" type="text" style="margin-right: 10px;width: 100px;text-align: center" value="${startDate}">~
        <input id="endDate" class="datePicker" type="text" style="margin-left: 10px;width: 100px;text-align: center" value="${endDate}">
        <input id="buttonSearch" type="button" value="조회" style="padding: 0px;width: 50px;margin-left: 5px;top: -1px;position: relative">
    </div>
    <br>
    <div style="width: 700px;height: 300px">
    <canvas id="chart" style="width: 100%;height: 100%">
        <script>

            var ctx = document.getElementById("chart");
            var myChart = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: ["Red", "Blue", "Yellow", "Green", "Purple", "Orange","Red", "Blue", "Yellow", "Green", "Purple", "Orange"],
                    datasets: [{
                        type:'bar',
                        data: [120, 190, 30, 50, 20, 30 , 120, 190, 30, 50, 20, 30],
                        backgroundColor: [
                            'rgba(255, 99, 132, 0.2)',
                            'rgba(54, 162, 235, 0.2)',
                            'rgba(255, 206, 86, 0.2)',
                            'rgba(75, 192, 192, 0.2)',
                            'rgba(153, 102, 255, 0.2)',
                            'rgba(255, 159, 64, 0.2)'
                        ],
                        borderColor: [
                            'rgba(255,99,132,1)',
                            'rgba(54, 162, 235, 1)',
                            'rgba(255, 206, 86, 1)',
                            'rgba(75, 192, 192, 1)',
                            'rgba(153, 102, 255, 1)',
                            'rgba(255, 159, 64, 1)'
                        ],
                        borderWidth: 1
                    },
                        {
                            type:'bar',
                            data: [120, 190, 30, 50, 20, 30 , 120, 190, 30, 50, 20, 30],
                            backgroundColor: [
                                'rgba(255, 99, 132, 0.2)',
                                'rgba(54, 162, 235, 0.2)',
                                'rgba(255, 206, 86, 0.2)',
                                'rgba(75, 192, 192, 0.2)',
                                'rgba(153, 102, 255, 0.2)',
                                'rgba(255, 159, 64, 0.2)'
                            ],
                            borderColor: [
                                'rgba(255,99,132,1)',
                                'rgba(54, 162, 235, 1)',
                                'rgba(255, 206, 86, 1)',
                                'rgba(75, 192, 192, 1)',
                                'rgba(153, 102, 255, 1)',
                                'rgba(255, 159, 64, 1)'
                            ],
                            borderWidth: 1
                        }]
                },
                options: {
                    legend : {
                        display:false
                    },
                    scales: {
                        yAxes: [{
                            ticks: {
                                beginAtZero:true
                            }
                        }]
                    }
                }
            });

        </script>
    </canvas>
    </div>

    <br>
    <br>
    <br>
    <br>

    <table class="form-table" style="width: 400px">
        <tr>
            <td>판매량</td>
            <td style="text-align: right"><fmt:formatNumber value="${saleQty}" type="number"/>개</td>
        </tr>
        <tr>
            <td>판매금액</td>
            <td style="text-align: right"><span style="color: blue;font-size: 15px;font-weight: bold"><fmt:formatNumber value="${salePrice}" type="number"/>원</span></td>
        </tr>
        <tr>
            <td>구매량</td>
            <td style="text-align: right"><fmt:formatNumber value="${buyQty}" type="number"/>개</td>
        </tr>
        <tr>
            <td>구매금액</td>
            <td style="text-align: right"><span style="color: red;font-size: 15px;font-weight: bold">-<fmt:formatNumber value="${buyPrice}" type="number"/>원</span></td>
        </tr>
        <tr>
            <td>이윤</td>
            <td style="text-align: right"><span style="color: green;font-size: 15px;font-weight: bold"><fmt:formatNumber value="${profitPrice}" type="number"/>원</span></td>
        </tr>
    </table>

</center>
