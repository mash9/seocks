package com.seocks.shopping.web;

import com.seocks.shopping.common.ShopException;
import com.seocks.shopping.model.Jspmember;
import com.seocks.shopping.service.JspmemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by com on 2016-10-03.
 */
@Controller
@RequestMapping(path = "/login")
public class LoginController
{
    @Autowired
    private JspmemberService jspmemberService;

    @RequestMapping(path = "/join.do" , method = RequestMethod.GET)
    public String join(Model model)
    {
        model.addAttribute("title" , "회원가입");
        model.addAttribute("page" , "/login/joinform");
        return "/include/layout";
    }

    @RequestMapping(path = "/regist.do" , method = RequestMethod.POST)
    public @ResponseBody int regist(@RequestBody Jspmember member) throws Exception
    {
        if(StringUtils.isEmpty(member.getId()))
            throw new ShopException("아이디를 입력하세요.");

        if(StringUtils.isEmpty(member.getPass()))
            throw new ShopException("비밀번호를 입력하세요.");

        if(StringUtils.isEmpty(member.getName()))
            throw new ShopException("이름을 입력하세요.");

        if(StringUtils.isEmpty(member.getMaddress1()))
            throw new ShopException("주소를 입력하세요.");

        if(StringUtils.isEmpty(member.getMaddress2()))
            throw new ShopException("상세주소를 입력하세요.");

        if(StringUtils.isEmpty(member.getPhone()))
            throw new ShopException("전화번호를 입력하세요.");

        if(StringUtils.isEmpty(member.getBirthday()))
            throw new ShopException("생년월일을 입력하세요.");

        return jspmemberService.createUser(member);
    }

    @RequestMapping(path = "/duplicate.do" , method = RequestMethod.POST)
    public @ResponseBody boolean duplicate(@RequestParam("userId") String userId)
    {
        return jspmemberService.getUser(userId) != null;
    }

    @RequestMapping(path = "/login.do" , method = RequestMethod.GET)
    public String login(Model model)
    {
        model.addAttribute("title" , "로그인");
        model.addAttribute("page" , "/login/loginform");
        return "/include/layout";
    }

    @RequestMapping(path = "/login.do" , method = RequestMethod.POST)
    public @ResponseBody boolean login(@RequestBody Jspmember member , HttpSession session) throws Exception
    {
        Jspmember user = jspmemberService.getUser(member.getId());

        if(member.getId() == null || "".equals(member.getId())) throw new ShopException("아이디를 입력하세요.");
        if(member.getPass() == null || "".equals(member.getPass())) throw new ShopException("비밀번호를 입력하세요.");

        if(user == null) throw new ShopException("아이디 또는 비밀번호를 확인하세요.");
        if(!user.getPass().equals(member.getPass())) throw new ShopException("아이디 또는 비밀번호를 확인하세요.");


        session.setAttribute("user" , user);
        session.setAttribute("userId" , user.getId());
        session.setAttribute("userName" , user.getName());
        return true;
    }

    @RequestMapping(path = "/logout.do" , method = RequestMethod.POST)
    public @ResponseBody boolean logout(HttpSession session)
    {
        session.invalidate();
        return true;
    }

    @RequestMapping(path = "/edit.do" , method = RequestMethod.GET)
    public String edit(Model model)
    {
        model.addAttribute("title" , "회원 정보수정");
        model.addAttribute("page" , "/login/editform");
        return "/include/layout";
    }

    @RequestMapping(path = "/edit.do" , method = RequestMethod.POST)
    public @ResponseBody boolean edit(@RequestBody Jspmember member , HttpSession session) throws Exception
    {
        if(StringUtils.isEmpty(member.getPass()))
            throw new ShopException("비밀번호를 입력하세요.");

        if(StringUtils.isEmpty(member.getName()))
            throw new ShopException("이름을 입력하세요.");

        if(StringUtils.isEmpty(member.getMaddress1()))
            throw new ShopException("주소를 입력하세요.");

        if(StringUtils.isEmpty(member.getMaddress2()))
            throw new ShopException("상세주소를 입력하세요.");

        if(StringUtils.isEmpty(member.getPhone()))
            throw new ShopException("전화번호를 입력하세요.");

        if(StringUtils.isEmpty(member.getBirthday()))
            throw new ShopException("생년월일을 입력하세요.");

        member.setId((String)session.getAttribute("userId"));
        jspmemberService.updateUser(member);

        Jspmember user = jspmemberService.getUser(member.getId());
        session.setAttribute("user" , user);
        session.setAttribute("userId" , user.getId());
        session.setAttribute("userName" , user.getName());
        return true;
    }
}
