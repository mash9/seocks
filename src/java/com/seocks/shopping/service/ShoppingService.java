package com.seocks.shopping.service;

import com.seocks.shopping.mapper.ShoppingMapper;
import com.seocks.shopping.model.DealOrder;
import com.seocks.shopping.model.Shopping;
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

    public Shopping info(String pno)
    {
        return mapper.info(pno);
    }

    public int updateShopping(Shopping shopping)
    {
        return mapper.updateShopping(shopping);
    }

    public List<DealOrder> listDealOrder()
    {
        return mapper.selectDealOrder();
    }

    public int dealOrder(DealOrder order)
    {
        return mapper.dealOrder(order);
    }
}
