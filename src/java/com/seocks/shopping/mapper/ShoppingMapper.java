package com.seocks.shopping.mapper;

import com.seocks.shopping.model.Bought;
import com.seocks.shopping.model.Shopping;
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

    Shopping info(@Param(value = "pno") String pno);
}
