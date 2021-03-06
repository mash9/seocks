package com.seocks.shopping.mapper;

import com.seocks.shopping.model.Bought;
import com.seocks.shopping.model.DealOrder;
import com.seocks.shopping.model.Shopping;
import com.seocks.shopping.model.chart.ChartElement;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by com on 2016-10-03.
 */
@Repository
public interface ShoppingMapper {

    List<Shopping> selectShopping();

    List<Shopping> selectShoppingByPcate(@Param(value = "pcate") String pcate);

    List<Shopping> selectRemainShopping();

    Shopping info(@Param(value = "pno") String pno);

    int updateShopping(@Param(value = "item") Shopping shopping);

    List<DealOrder> selectDealOrder(@Param(value = "startDate") String startDate , @Param(value = "endDate") String endDate);

    int dealOrder(@Param(value = "item") DealOrder order);

    String getGeneratePno(@Param(value = "pcate") String pcate);

    int createShopping(@Param(value = "item") Shopping shopping);

    int decreaseShoppingQty(@Param(value = "pno") String pno , @Param(value = "qty") Integer qty);
}
