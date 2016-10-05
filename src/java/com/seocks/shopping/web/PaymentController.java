package com.seocks.shopping.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by com on 2016-10-04.
 */
@Controller
@RequestMapping("/pay")
public class PaymentController {

    @RequestMapping(path = "/itemcart.do" , method = RequestMethod.GET)
    public String itemcart(Model model)
    {
        model.addAttribute("title" , "장바구니");
        model.addAttribute("page" , "/payment/cartlist");
        return "/include/layout";
    }

    @RequestMapping(path = "/itembuy.do" , method = RequestMethod.GET)
    public String itembuy(Model model)
    {
        model.addAttribute("title" , "구매하기");
        model.addAttribute("page" , "/payment/itembuy");
        return "/include/layout";
    }
}
