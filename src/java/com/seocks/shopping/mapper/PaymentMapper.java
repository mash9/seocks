package com.seocks.shopping.mapper;

import com.seocks.shopping.model.Payment;
import com.seocks.shopping.model.PaymentDelivery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by com on 2016-10-13.
 */
@Repository
public interface PaymentMapper {

    void createPaymentDelivery(@Param(value = "pay") PaymentDelivery paymentDelivery);

    void createPayment(@Param(value = "pay") Payment payment);
}
