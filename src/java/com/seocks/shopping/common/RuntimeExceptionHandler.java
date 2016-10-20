package com.seocks.shopping.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by com on 2016-10-03.
 */
@ControllerAdvice
public class RuntimeExceptionHandler {

    @ExceptionHandler(value = ShopException.class)
    private @ResponseBody String doHandler(HttpServletResponse response, Exception ex)
    {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setStatus(404);

        try(PrintWriter writer = response.getWriter())
        {
            writer.println(ex.getMessage());
            writer.close();
        }
        catch (IOException e)
        {
        }

        return ex.getMessage();
    }
}
