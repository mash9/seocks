package com.seocks.shopping.web;

import com.seocks.shopping.model.Shopping;
import com.seocks.shopping.model.ShoppingItem;
import com.seocks.shopping.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(path = "/itemCart.do" , method = RequestMethod.GET)
    public String itemcart(@RequestParam(value = "pno" , required = false) String pno,
                           @RequestParam(value = "psize" , required = false) String psize,
                           @RequestParam(value = "qty" , required = false) Integer qty,
                           HttpSession session,
                           Model model)
    {
        HashMap<String , ShoppingItem> cartMap = (HashMap<String , ShoppingItem>)session.getAttribute("cartMap");

        String cartKey = pno + "-" + psize;

        if(cartMap == null)
        {
            cartMap = new HashMap<String , ShoppingItem>();
            session.setAttribute("cartMap" , cartMap);
        }

        if(!StringUtils.isEmpty(pno) && !StringUtils.isEmpty(cartKey))
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

        model.addAttribute("title" , "장바구니");
        model.addAttribute("cartList" , cartMap.values());
        model.addAttribute("page" , "/payment/cartlist");
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

    @RequestMapping(path = "/itembuy.do" , method = RequestMethod.GET)
    public String itembuy(Model model)
    {
        model.addAttribute("title" , "구매하기");
        model.addAttribute("page" , "/payment/itembuy");
        return "/include/layout";
    }
}
