package com.seocks.shopping.web;

import com.seocks.shopping.constans.ProductType;
import com.seocks.shopping.model.Shopping;
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
import java.util.List;

/**
 * Created by com on 2016-10-03.
 */
@Controller
@RequestMapping(path = "/shop")
public class ShopController {

    @Autowired
    private ShoppingService shoppingService;

    @RequestMapping(path = "/list.do" , method = RequestMethod.GET)
    public String list(@RequestParam(value = "pcate") String pcate, Model model)
    {
        List<Shopping> results = shoppingService.list(pcate);

        model.addAttribute("items" , results);
        model.addAttribute("title" , "안녕하세요.");
        model.addAttribute("page" , "/main/center");
        return "/include/layout";
    }

    @RequestMapping(path = "/list.do" , method = RequestMethod.POST)
    public @ResponseBody List<Shopping> list(@RequestParam(value = "pcate") String pcate)
    {
        return shoppingService.list(pcate);
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

    @RequestMapping(path = "/match.do" , method = RequestMethod.GET)
    public String matching(Model model,
                           HttpSession session)
    {
        List<Shopping> shirtList = shoppingService.list(ProductType.SHIRT);
        List<Shopping> pantsList = shoppingService.list(ProductType.PANTS);
        List<Shopping> shoesList = shoppingService.list(ProductType.SHOES);

        Integer shirtIndex = (Integer)session.getAttribute("matchShirtIndex");
        Integer pantsIndex = (Integer)session.getAttribute("matchPantsIndex");
        Integer shoesIndex = (Integer)session.getAttribute("matchShoesIndex");

        if(shirtIndex == null)
        {
            shirtIndex = 0;
            session.setAttribute("matchShirtIndex" , 0);
        }

        if(pantsIndex == null)
        {
            pantsIndex = 0;
            session.setAttribute("matchPantsIndex" , 0);
        }

        if(shoesIndex == null)
        {
            shoesIndex = 0;
            session.setAttribute("matchShoesIndex" , 0);
        }

        model.addAttribute("title" , "코디매칭");
        model.addAttribute("shirt" , shirtList.get(shirtIndex));
        model.addAttribute("pants" , pantsList.get(pantsIndex));
        model.addAttribute("shoes" , shoesList.get(shoesIndex));
        model.addAttribute("page" , "/shop/matching");
        return "/include/layout";
    }

    @RequestMapping(path = "/match.do" , method = RequestMethod.POST)
    public String matching(@RequestParam(value = "pcate") String pcate,
                           @RequestParam(value = "next") boolean next,
                           Model model,
                           HttpSession session)
    {
        List<Shopping> shirtList = shoppingService.list(ProductType.SHIRT);
        List<Shopping> pantsList = shoppingService.list(ProductType.PANTS);
        List<Shopping> shoesList = shoppingService.list(ProductType.SHOES);


        Integer shirtIndex = (Integer)session.getAttribute("matchShirtIndex");
        Integer pantsIndex = (Integer)session.getAttribute("matchPantsIndex");
        Integer shoesIndex = (Integer)session.getAttribute("matchShoesIndex");

        Integer cursor = 0;
        List<Shopping> cursorList = null;

        if(ProductType.SHIRT.equals(pcate))
        {
            cursor = shirtIndex;
            cursorList = shirtList;
        }
        else if(ProductType.PANTS.equals(pcate))
        {
            cursor = pantsIndex;
            cursorList = pantsList;
        }
        else if(ProductType.SHOES.equals(pcate))
        {
            cursor = shoesIndex;
            cursorList = shoesList;
        }

        cursor = next ? cursor + 1 : cursor - 1;

        if(cursor < 0)
            cursor = cursorList.size() - 1;
        else if(cursor == cursorList.size())
            cursor = 0;

        if(ProductType.SHIRT.equals(pcate))
            shirtIndex = cursor;
        else if(ProductType.PANTS.equals(pcate))
            pantsIndex = cursor;
        else if(ProductType.SHOES.equals(pcate))
            shoesIndex = cursor;


        session.setAttribute("matchShirtIndex" , shirtIndex);
        session.setAttribute("matchPantsIndex" , pantsIndex);
        session.setAttribute("matchShoesIndex" , shoesIndex);

        model.addAttribute("title" , "코디매칭");
        model.addAttribute("shirt" , shirtList.get(shirtIndex));
        model.addAttribute("pants" , pantsList.get(pantsIndex));
        model.addAttribute("shoes" , shoesList.get(shoesIndex));
        model.addAttribute("page" , "/shop/matching");
        return "/include/layout";
    }

}
