package com.seocks.shopping.web;

import com.seocks.shopping.common.ShopException;
import com.seocks.shopping.model.Code;
import com.seocks.shopping.model.DealOrder;
import com.seocks.shopping.model.Jspmember;
import com.seocks.shopping.model.Shopping;
import com.seocks.shopping.service.CodeService;
import com.seocks.shopping.service.JspmemberService;
import com.seocks.shopping.service.PaymentService;
import com.seocks.shopping.service.ShoppingService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.List;

/**
 * Created by com on 2016-10-06.
 */
@Controller
@RequestMapping(path = "/admin")
public class AdminController {

    @Value("#{config['upload.image.path']}")
    private String uploadPath;

    @Autowired
    private CodeService codeService;

    @Autowired
    private JspmemberService jspmemberService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private ShoppingService shoppingService;

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
    public String saleList(@RequestParam(value = "startDate" , required = false) String startDate,
                           @RequestParam(value = "endDate" , required = false) String endDate,
                           Model model)
    {
        model.addAttribute("title" , "판매현황");
        model.addAttribute("startDate" , startDate);
        model.addAttribute("endDate" , endDate);
        model.addAttribute("groups" , paymentService.boughtGroup("" , startDate , endDate));
        model.addAttribute("items" , paymentService.boughtList("" , startDate , endDate));
        model.addAttribute("page" , "/admin/saleList");
        return "/include/layout";
    }

    @RequestMapping(path = "/order.do" , method = RequestMethod.GET)
    public String order(@RequestParam(value = "startDate" , required = false) String startDate,
                        @RequestParam(value = "endDate" , required = false) String endDate,
                        Model model)
    {
        List<Code> codes = codeService.getProductCodes();
        model.addAttribute("title" , "거래처");
        model.addAttribute("startDate" , startDate);
        model.addAttribute("endDate" , endDate);
        model.addAttribute("codes" , codes);
        model.addAttribute("products" , shoppingService.list(codes.get(0).getCode()));
        model.addAttribute("orders" , shoppingService.listDealOrder(startDate , endDate));
        model.addAttribute("page" , "/admin/order");
        return "/include/layout";
    }

    @RequestMapping(path = "/deal/order.do" , method = RequestMethod.POST)
    public @ResponseBody boolean dealOrder(@RequestParam(value = "pno") String pno,
                                           @RequestParam(value = "qty") Integer qty)
    {
        Shopping product = shoppingService.info(pno);

        DealOrder dealOrder = new DealOrder();
        dealOrder.setPno(pno);
        dealOrder.setQty(qty);
        shoppingService.dealOrder(dealOrder);

        product.setPocunt(product.getPocunt() + qty);
        shoppingService.updateShopping(product);
        return true;
    }

    @RequestMapping(path = "/product/add.do" , method = RequestMethod.GET)
    public String productAdd(Model model)
    {
        List<Code> codes = codeService.getProductCodes();
        model.addAttribute("title" , "상품등록");
        model.addAttribute("codes" , codes);
        model.addAttribute("page" , "/admin/productAdd");
        return "/include/layout";
    }

    @RequestMapping(path = "/product/add.do" , method = RequestMethod.POST)
    public @ResponseBody boolean productAdd(@RequestParam(value = "pcate") String pcate,
                                            @RequestParam(value = "pname" , required = false) String pname,
                                            @RequestParam(value = "pprice" , required = false) Integer pprice,
                                            @RequestParam(value = "pmainimg" , required = false) MultipartFile pmainimg,
                                            @RequestParam(value = "psubimg" , required = false) MultipartFile psubimg,
                                            @RequestParam(value = "pinfo") String pinfo) throws ShopException
    {
        if(pname == null) throw new ShopException("상품명을 입력하세요.");
        if(pprice == null) throw new ShopException("가격을 입력하세요.");
        if(pmainimg == null) throw new ShopException("상품 이미지를 선택하세요.");
        if(psubimg == null) throw new ShopException("상세 이미지를 선택하세요.");

        String pmainimgName = FilenameUtils.getName(pmainimg.getOriginalFilename());
        String psubimgName = FilenameUtils.getName(psubimg.getOriginalFilename());

        String extensions = "bmp|jpg|png|gif";
        if(extensions.indexOf(FilenameUtils.getExtension(pmainimgName).toLowerCase()) < 0) throw new ShopException("상품 이미지 파일 오류");
        if(extensions.indexOf(FilenameUtils.getExtension(psubimgName).toLowerCase()) < 0) throw new ShopException("상세 이미지 파일 오류");

        String separator = FileSystems.getDefault().getSeparator();
        String pno = shoppingService.generatePno(pcate);

        String pmainimgPath = uploadPath + separator + pno + ".jpg";



        try(ByteArrayInputStream inputStream = new ByteArrayInputStream(pmainimg.getBytes());
            FileOutputStream outputStream = new FileOutputStream(pmainimgPath)){

            File file = new File(pmainimgPath);
            if(file.exists()) file.delete();

            FileCopyUtils.copy(inputStream , outputStream);
        }catch(IOException ex)
        {
            throw new ShopException("시스템 에러가 발생했습니다.");
        }

        String psubimgPath = uploadPath + separator + pno + "SUB.jpg";
        try(ByteArrayInputStream inputStream = new ByteArrayInputStream(psubimg.getBytes());
            FileOutputStream outputStream = new FileOutputStream(psubimgPath)){

            File file = new File(psubimgPath);
            if(file.exists()) file.delete();

            FileCopyUtils.copy(inputStream , outputStream);
        }catch(IOException ex)
        {
            throw new ShopException("시스템 에러가 발생했습니다.");
        }

        Shopping newOne = new Shopping();
        newOne.setPno(pno);
        newOne.setPname(pname);
        newOne.setPprice(pprice);
        newOne.setPinfo(pinfo);
        newOne.setPmainimg(pno + ".jpg");
        newOne.setPsubimg(pno + "SUB.jpg");
        newOne.setPocunt(0);
        newOne.setPcate(pcate);
        newOne.setPtemp(pno.substring(0 , 1));

        shoppingService.create(newOne);
        return true;
    }

}
