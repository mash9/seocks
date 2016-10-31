package com.seocks.shopping.utils;

import com.seocks.shopping.common.ShopException;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by com on 2016-10-31.
 */
public class DateUtil {

    public static boolean validateDates(String startDate , String endDate) throws ShopException
    {
        if(StringUtils.isEmpty(startDate)) return false;
        if(StringUtils.isEmpty(endDate)) return false;

        try
        {
            Date sDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
            Date eDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);

            if(sDate.getTime() > eDate.getTime()) throw new ShopException("종료일이 시작일보다 빠릅니다.");
        }
        catch(ParseException ex)
        {
            return false;
        }


        return true;
    }
}
