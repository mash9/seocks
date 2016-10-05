package com.seocks.shopping.mapper;

import com.seocks.shopping.model.Jspmember;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by com on 2016-10-03.
 */
@Repository
public interface JspmemberMapper {

    int createUser(@Param(value = "user") Jspmember jspmember);

    Jspmember getUser(@Param(value = "id") String id);

    int updateUser(@Param(value = "user") Jspmember jspmember);
}
