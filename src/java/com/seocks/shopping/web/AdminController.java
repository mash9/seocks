package com.seocks.shopping.web;

import com.seocks.shopping.common.ShopException;
import com.seocks.shopping.model.Jspmember;
import com.seocks.shopping.service.JspmemberService;
import com.seocks.shopping.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by com on 2016-10-06.
 */
@Controller
@RequestMapping(path = "/admin")
public class AdminController {

    @Autowired
    private JspmemberService jspmemberService;

    @Autowired
    private PaymentService paymentService;

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

    @RequestMapping(path = "/memberEdit.do" , method = RequestMethod.GET)
    public String memberEdit(@RequestParam(value = "id") String id,
                             Model model)
    {
        model.addAttribute("member" , jspmemberService.getUser(id));
        model.addAttribute("title" , "회원 정보수정");
        model.addAttribute("page" , "/admin/memberEdit");
        return "/include/layout";
    }

    @RequestMapping(path = "/memberEdit.do" , method = RequestMethod.POST)
    public @ResponseBody boolean memberEdit(@RequestBody Jspmember member)
    {
        jspmemberService.updateUser(member);
        return true;
    }

    @RequestMapping(path = "/memberDelete.do" , method = RequestMethod.POST)
    public @ResponseBody boolean memberDelete(@RequestParam("id") String id) throws Exception
    {
        if("admin".equals(id)) throw new ShopException("관리자는 삭제 할 수 없습니다.");

        jspmemberService.deleteUser(id);
        return true;
    }

    @RequestMapping(path = "/saleList.do" , method = RequestMethod.GET)
    public String saleList(Model model)
    {
        model.addAttribute("title" , "판매현황");
        model.addAttribute("groups" , paymentService.boughtGroup(""));
        model.addAttribute("items" , paymentService.boughtList(""));
        model.addAttribute("page" , "/admin/saleList");
        return "/include/layout";
    }
}
