package com.seocks.shopping.web;

import com.seocks.shopping.service.JspmemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by com on 2016-10-06.
 */
@Controller
@RequestMapping(path = "/admin")
public class AdminController {

    @Autowired
    private JspmemberService jspmemberService;

    @RequestMapping(path = "/memberList.do" , method = RequestMethod.GET)
    public String memberList(Model model)
    {
        model.addAttribute("members" , jspmemberService.getUsers());
        model.addAttribute("title" , "회원관리");
        model.addAttribute("page" , "/admin/memberList");
        return "/include/layout";
    }

    @RequestMapping(path = "/memberInfo.do" , method = RequestMethod.GET)
    public String memberInfo(@RequestParam(value = "id") String id,
                             Model model)
    {
        model.addAttribute("member" , jspmemberService.getUser(id));
        model.addAttribute("title" , "회원정보");
        model.addAttribute("page" , "/admin/memberInfo");
        return "/include/layout";
    }
}
