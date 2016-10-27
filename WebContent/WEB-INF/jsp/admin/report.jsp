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

        function legendsText(chart)
        {
            return "11";
        }


        function showChart()
        {
            var arg = {
                startDate:$("#startDate").val(),
                endDate:$("#endDate").val()
            }

            $.post("/chart/data.do" , arg , function(result){

                var ctx = document.getElementById("chart");
                var myChart = new Chart(ctx, {
                    type: 'bar',
                    data: result,
                    options: {
                        legend : {
                            display:true,
                            labels:{
                                generateLabels:function(data){
                                    return [{
                                        text:"판매금액",
                                        fillStyle:"#0000FF",
                                        index:0
                                    },{
                                        text:"구매금액",
                                        fillStyle:"#FF0000",
                                        index:1
                                    }];
                                }
                            }
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

            });



        }

        showChart();



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
