package com.seocks.shopping.mapper;

import com.seocks.shopping.model.Code;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by com on 2016-10-15.
 */
@Repository
public interface CodeMapper {

    List<Code> getProductCodes();
}
