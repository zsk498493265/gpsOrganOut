package com.organOld.oService.service;

import com.organOld.oService.contract.BTableRequest;
import com.organOld.oService.contract.CartRequest;
import com.organOld.oService.contract.Conse;
import com.organOld.oService.contract.ProductBookRequest;

import javax.servlet.http.HttpServletRequest;

public interface CartService {
    Conse SaveInCart( CartRequest cartRequest);

    String getProductIds(BTableRequest bTableRequest);

    String getProByOldmanId(BTableRequest bTableRequest,CartRequest cartRequest);

    Conse delByIds(String[] ids);

    Conse SaveInBook(ProductBookRequest productBookRequest);
}
