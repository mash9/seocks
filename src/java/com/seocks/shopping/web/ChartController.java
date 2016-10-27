package com.seocks.shopping.web;

import com.seocks.shopping.common.ShopException;
import com.seocks.shopping.model.chart.ChartData;
import com.seocks.shopping.model.chart.ChartElement;
import com.seocks.shopping.model.chart.DataSet;
import com.seocks.shopping.service.PaymentService;
import com.seocks.shopping.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by com on 2016-10-26.
 */
@Controller
@RequestMapping(path = "/chart")
public class ChartController {

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(path = "/data.do" , method = RequestMethod.POST)
    public @ResponseBody ChartData data(@RequestParam(value = "startDate" , required = false) String startDate,
                                        @RequestParam(value = "endDate" , required = false) String endDate) throws ShopException
    {
        if(StringUtils.isEmpty(startDate)) throw new ShopException("시작일을 입력하세요.");
        if(StringUtils.isEmpty(endDate)) throw new ShopException("종료일을 입력하세요.");



        List<String> labels = new ArrayList<>();

        try
        {
            Date sDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
            Date eDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);

            if(sDate.getTime() > eDate.getTime()) throw new ShopException("종료일이 시작일보다 빠릅니다.");

            sDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDate.substring(0 , 7) + "-01");
            eDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDate.substring(0 , 7) + "-01");


            Calendar startCalendar = Calendar.getInstance();
            startCalendar.setTime(sDate);



            SimpleDateFormat df = new SimpleDateFormat("yyyy.MM");

            while(sDate.getTime() != eDate.getTime())
            {
                labels.add(df.format(sDate));
                startCalendar.add(Calendar.MONTH , 1);
                sDate = startCalendar.getTime();
            }

            labels.add(df.format(sDate));
        }
        catch (ParseException ex)
        {
            throw new ShopException("날짜가 잘못되었습니다.");
        }

        ChartData retn = new ChartData();
        retn.setLabels(labels);


        List<ChartElement> sales = paymentService.selectSalesChart(startDate , endDate);

        Map<String , Integer> salesMap = new HashMap<String , Integer>();
        for(ChartElement element : sales)
            salesMap.put(element.getBuyDate() , element.getPrice());

        List<ChartElement> deals = paymentService.selectDealChart(startDate , endDate);

        Map<String , Integer> dealMap = new HashMap<String , Integer>();
        for(ChartElement element : deals)
            dealMap.put(element.getBuyDate() , element.getPrice());



        List<DataSet> dataSets = new ArrayList<DataSet>();


        DataSet chart1 = new DataSet();
        chart1.setType("bar");
        chart1.setBorderWidth(1);

        List<Integer> data1 = new ArrayList<Integer>();
        List<String> backgroundColor1 = new ArrayList<String>();
        List<String> borderColor1 = new ArrayList<String>();
        for(int i = 0 ; i < labels.size() ; i++)
        {
            String label = labels.get(i);

            if(salesMap.containsKey(label))
                data1.add(salesMap.get(label));
            else
                data1.add(0);

            backgroundColor1.add("rgba(0, 0, 255, 1)");
            borderColor1.add("rgba(0,0,255,1)");
        }

        chart1.setData(data1);
        chart1.setBackgroundColor(backgroundColor1);
        chart1.setBorderColor(borderColor1);
        dataSets.add(chart1);





        DataSet chart2 = new DataSet();
        chart2.setType("bar");
        chart2.setBorderWidth(1);

        List<Integer> data2 = new ArrayList<Integer>();
        List<String> backgroundColor2 = new ArrayList<String>();
        List<String> borderColor2 = new ArrayList<String>();
        for(int i = 0 ; i < labels.size() ; i++)
        {
            String label = labels.get(i);

            if(dealMap.containsKey(label))
                data2.add(dealMap.get(label));
            else
                data2.add(0);

            backgroundColor2.add("rgba(255, 0, 0, 1)");
            borderColor2.add("rgba(255, 0, 0, 1)");
        }

        chart2.setData(data2);
        chart2.setBackgroundColor(backgroundColor2);
        chart2.setBorderColor(borderColor2);
        dataSets.add(chart2);

        retn.setDatasets(dataSets);

        return retn;
    }
}
