package com.seocks.shopping.service;

import com.seocks.shopping.mapper.PaymentMapper;
import com.seocks.shopping.model.Payment;
import com.seocks.shopping.model.PaymentDelivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by com on 2016-10-13.
 */
@Service
public class PaymentService {

    @Autowired
    private PaymentMapper mapper;

    //@Transactional
    public void buy(PaymentDelivery paymentDelivery)
    {
        mapper.createPaymentDelivery(paymentDelivery);

        for(Payment payment : paymentDelivery.getItems())
        {
            payment.setPayId(paymentDelivery.getPayId());
            mapper.createPayment(payment);
        }
    }
}
