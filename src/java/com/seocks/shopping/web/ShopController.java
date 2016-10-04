package com.seocks.shopping.web;

import com.seocks.shopping.model.Shopping;
import com.seocks.shopping.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by com on 2016-10-03.
 */
@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShoppingService shoppingService;

    @RequestMapping(path = "/list.do" , method = RequestMethod.GET)
    public String list(@RequestParam(value = "pcate") String pcate, Model model)
    {
        List<Shopping> results = shoppingService.list(pcate);

        model.addAttribute("v" , results);
        model.addAttribute("title" , "안녕하세요.");
        model.addAttribute("page" , "/main/center");
        return "/include/layout";
    }

    @RequestMapping(path = "/info.do" , method = RequestMethod.GET)
    public String info(@RequestParam(value = "pno") String pno, Model model)
    {
        Shopping product = shoppingService.info(pno);

        model.addAttribute("product" , product);
        model.addAttribute("title" , product.getPname());
        model.addAttribute("page" , "/shop/info");
        return "/include/layout";
    }

}
