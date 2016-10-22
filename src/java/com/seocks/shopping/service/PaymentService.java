package com.seocks.shopping.service;

import com.seocks.shopping.common.ShopException;
import com.seocks.shopping.mapper.PaymentMapper;
import com.seocks.shopping.mapper.ShoppingMapper;
import com.seocks.shopping.model.Bought;
import com.seocks.shopping.model.Payment;
import com.seocks.shopping.model.PaymentDelivery;
import com.seocks.shopping.model.Shopping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by com on 2016-10-13.
 */
@Service
public class PaymentService {

    @Autowired
    private ShoppingMapper shoppingMapper;

    @Autowired
    private PaymentMapper mapper;

    @Transactional
    public void buy(PaymentDelivery paymentDelivery) throws ShopException
    {
        mapper.createPaymentDelivery(paymentDelivery);

        for(Payment payment : paymentDelivery.getItems())
        {
            Shopping shopping = shoppingMapper.info(payment.getPno());

            if(shopping.getPocunt() < payment.getQty())
                throw new ShopException("재고가 부족합니다.");

            shoppingMapper.decreaseShoppingQty(payment.getPno() , payment.getQty());

            payment.setPayId(paymentDelivery.getPayId());
            mapper.createPayment(payment);
        }
    }

    public List<Bought> boughtList(String userId , String startDate , String endDate)
    {
        return mapper.selectBought(userId , startDate , endDate);
    }

    public List<Bought> boughtGroup(String userId , String startDate , String endDate)
    {
        return mapper.selectBoughtGroup(userId , startDate , endDate);
    }
}
