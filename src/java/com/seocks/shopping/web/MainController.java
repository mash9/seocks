package com.seocks.shopping.web;

import com.seocks.shopping.model.Shopping;
import com.seocks.shopping.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by com on 2016-10-03.
 */
@Controller
public class MainController {

    @Autowired
    private ShoppingService shoppingService;

    @RequestMapping(path = "/main.do" , method = RequestMethod.GET)
    public String main(Model model)
    {
        List<Shopping> results = shoppingService.list();

        model.addAttribute("v" , results);
        model.addAttribute("title" , "안녕하세요");
        model.addAttribute("page" , "/main/center");
        return "/include/layout";
    }
}
