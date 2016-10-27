package com.seocks.shopping.service;

import com.seocks.shopping.mapper.ShoppingMapper;
import com.seocks.shopping.model.DealOrder;
import com.seocks.shopping.model.Shopping;
import com.seocks.shopping.model.chart.ChartElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by com on 2016-10-03.
 */
@Service
public class ShoppingService {

    @Autowired
    private ShoppingMapper mapper;

    public List<Shopping> list()
    {
        return mapper.selectShopping();
    }

    public List<Shopping> list(String pcate)
    {
        return mapper.selectShoppingByPcate(pcate);
    }

    public List<Shopping> remains()
    {
        return mapper.selectRemainShopping();
    }

    public Shopping info(String pno)
    {
        return mapper.info(pno);
    }

    public int updateShopping(Shopping shopping)
    {
        return mapper.updateShopping(shopping);
    }

    public List<DealOrder> listDealOrder(String startDate , String endDate)
    {
        return mapper.selectDealOrder(startDate , endDate);
    }

    public int dealOrder(DealOrder order)
    {
        return mapper.dealOrder(order);
    }

    public String generatePno(String pcate)
    {
        return mapper.getGeneratePno(pcate);
    }

    public int create(Shopping newOne)
    {
        return mapper.createShopping(newOne);
    }

}
