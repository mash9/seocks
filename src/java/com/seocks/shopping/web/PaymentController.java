package com.seocks.shopping.web;

import com.seocks.shopping.common.ShopException;
import com.seocks.shopping.model.PaymentDelivery;
import com.seocks.shopping.model.Shopping;
import com.seocks.shopping.model.ShoppingItem;
import com.seocks.shopping.service.PaymentService;
import com.seocks.shopping.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by com on 2016-10-04.
 */
@Controller
@RequestMapping(path = "/pay")
public class PaymentController {

    @Autowired
    private ShoppingService shoppingService;

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(path = "/itemCart.do" , method = RequestMethod.GET)
    public String itemcart(@RequestParam(value = "pno" , required = false) String pno,
                           @RequestParam(value = "psize" , required = false) String psize,
                           @RequestParam(value = "qty" , required = false) Integer qty,
                           HttpSession session,
                           Model model)
    {
        model.addAttribute("title" , "장바구니");
        model.addAttribute("cartList" , getCartList(session , pno , psize , qty));
        model.addAttribute("page" , "/payment/cartlist");
        return "/include/layout";
    }

    @RequestMapping(path = "/addCart.do" , method = RequestMethod.POST)
    public @ResponseBody boolean addCart(@RequestParam(value = "pno") String pno,
                                         @RequestParam(value = "psize") String psize,
                                         @RequestParam(value = "qty") Integer qty,
                                         HttpSession session)
    {
        getCartList(session , pno , psize , qty);
        return true;
    }

    @RequestMapping(path = "/itembuy.do" , method = RequestMethod.GET)
    public String itembuy(@RequestParam(value = "pno" , required = false) String pno,
                          @RequestParam(value = "psize" , required = false) String psize,
                          @RequestParam(value = "qty" , required = false) Integer qty,
                          HttpSession session,
                          Model model)
    {
        model.addAttribute("title" , "구매하기");
        model.addAttribute("user" , session.getAttribute("user"));
        model.addAttribute("cartList" , getCartList(session , pno , psize , qty));
        model.addAttribute("page" , "/payment/itembuy");
        return "/include/layout";
    }

    @RequestMapping(path = "/clearCart.do" , method = RequestMethod.POST)
    public @ResponseBody boolean clearCart(@RequestParam(value = "pno" , required = false) String pno,
                                           @RequestParam(value = "psize" , required = false) String psize,
                                           HttpSession session)
    {
        HashMap<String , ShoppingItem> cartMap = (HashMap<String , ShoppingItem>)session.getAttribute("cartMap");

        if(!StringUtils.isEmpty(pno))
        {
            String cartKey = pno + "-" + psize;
            cartMap.remove(cartKey);
        }
        else
        {
            session.removeAttribute("cartMap");
        }

        return true;
    }

    @RequestMapping(path = "/buy.do" , method = RequestMethod.POST)
    public @ResponseBody boolean buy(@RequestBody PaymentDelivery payment, HttpSession session) throws ShopException
    {
        payment.setUserId((String)session.getAttribute("userId"));
        paymentService.buy(payment);

        session.removeAttribute("cartMap");
        return true;
    }

    private Collection<ShoppingItem> getCartList(HttpSession session , String pno , String psize , Integer qty)
    {
        HashMap<String , ShoppingItem> cartMap = (HashMap<String , ShoppingItem>)session.getAttribute("cartMap");

        String cartKey = pno + "-" + psize;

        if(cartMap == null)
        {
            cartMap = new HashMap<String , ShoppingItem>();
            session.setAttribute("cartMap" , cartMap);
        }

        if(!StringUtils.isEmpty(pno))
        {
            ShoppingItem newCartItem;

            if(cartMap.containsKey(cartKey))
            {
                newCartItem = cartMap.get(cartKey);
                newCartItem.setQty(newCartItem.getQty() + qty);
                newCartItem.setTotalprice(newCartItem.getQty() * newCartItem.getPprice());
            }
            else
            {
                Shopping shopping = shoppingService.info(pno);

                newCartItem = new ShoppingItem();
                newCartItem.setPno(pno);
                newCartItem.setPname(shopping.getPname());
                newCartItem.setPprice(shopping.getPprice());
                newCartItem.setPmainimg(shopping.getPmainimg());
                newCartItem.setPcate(shopping.getPcate());
                newCartItem.setPsize(psize);
                newCartItem.setQty(qty);
                newCartItem.setTotalprice(shopping.getPprice() * qty);
                cartMap.put(cartKey , newCartItem);
            }
        }

        return cartMap.values();
    }

    @RequestMapping(path = "/boughtList.do" , method = RequestMethod.GET)
    public String boughtList(HttpSession session, Model model)
    {
        String userId = (String)session.getAttribute("userId");

        model.addAttribute("title" , "거래내역");
        model.addAttribute("groups" , paymentService.boughtGroup(userId));
        model.addAttribute("items" , paymentService.boughtList(userId));
        model.addAttribute("page" , "/payment/boughtList");
        return "/include/layout";
    }
}
