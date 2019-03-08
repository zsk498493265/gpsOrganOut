package com.organOld.web.controller;

import com.organOld.oService.contract.*;
import com.organOld.oService.service.CartService;
import com.organOld.oService.service.ComService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/cart")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CartController {
    @Autowired
    CartService cartService;
    @Autowired
    ComService comService;
    @ResponseBody
    @RequestMapping(value="/save",method= RequestMethod.GET)
    public Conse saveCart(HttpServletRequest request, CartRequest cartRequest){
        cartRequest.setOldmanId(comService.getUserByToken(request));
        return cartService.SaveInCart(cartRequest);
    }

    @ResponseBody
    @RequestMapping(value = "/getCartInfo",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    public String getCartProducts(HttpServletRequest request,BTableRequest bTableRequest,Integer oldmanId){
        oldmanId = comService.getUserByToken(request);
        CartRequest cartRequest = new CartRequest();
        cartRequest.setOldmanId(oldmanId);
        return cartService.getProByOldmanId(bTableRequest,cartRequest);
    }

    @ResponseBody
    @RequestMapping(value = "/saveInBook",method = RequestMethod.GET)
    public Conse saveBook(HttpServletRequest request, ProductBookRequest productBookRequest,
                          @RequestParam(value = "bookIds_array[]",required = false) String bookIdsArray[]){
        Integer oldmanId = comService.getUserByToken(request);
        productBookRequest.setOldmanId(oldmanId);
        productBookRequest.setBookIds(bookIdsArray);
        return cartService.SaveInBook(productBookRequest);
    }
    @ResponseBody
    @RequestMapping( value = "/delete",method = RequestMethod.GET)
    public Conse DeleteGoods(String[] ids){
        return cartService.delByIds(ids);
    }
}
