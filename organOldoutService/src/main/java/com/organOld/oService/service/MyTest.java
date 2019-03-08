package com.organOld.oService.service;



import com.organOld.dao.entity.AutoValue;
import com.organOld.dao.entity.Card;
import com.organOld.dao.entity.oldman.Linkman;
import com.organOld.oService.contract.*;
import com.organOld.oService.exception.OtherServiceException;
import com.organOld.oService.model.LinkmanModel;
import com.organOld.oService.model.OldsHealthModel;
import com.organOld.oService.model.PersonalInfoModel;
import com.organOld.oService.tool.ImgUpload;
import com.organOld.oService.tool.OssClientUtil;
import org.apache.http.entity.ContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml"})
public class MyTest {
    @Autowired
    AutoValService autoValService;
    @Autowired
    FileService fileService;

    @Autowired
    GoodsService goodsService;

    @Autowired
    OutVisualService outVisualService;
    @Autowired
    OrganService organService;
    @Autowired
    CartService cartService;
    @Autowired
    OldsUserService oldsUserService;
    @Autowired
    ProductTypeService productTypeService;

    @Autowired
    OssClientUtil ossClient;

    @Test
    public void myTest() {
        OldsHealthModel oldmanHealth = fileService.getOldmanHealth(36);
        oldmanHealth.getAbiliInfo();
    }

    @Test
    public void testLabel() {
        Conse conse = fileService.getByLabel(36);
        conse.getData();
    }
    @Test
    public void testPersonalInfo(){
        PersonalInfoModel personalInfoModel = fileService.getPersonalInfo(36);
        personalInfoModel.getHome();
    }

    @Test
    public void testReocrd(){
        BTableRequest bTableRequest = new BTableRequest();
        CardLogsRequest cardLogsRequest = new CardLogsRequest();
        cardLogsRequest.setOldmanId(3374);
       // cardLogsRequest.setType(9);
        bTableRequest.setiDisplayLength(10);
        bTableRequest.setiDisplayStart(0);
        String result = fileService.getByCardPage(bTableRequest,cardLogsRequest);
        String tesxt= result;
    }

    @Test
    public void testLog(){
        BTableRequest bTableRequest = new BTableRequest();
        LogsRequest logsRequest = new LogsRequest();
        logsRequest.setOldmanId(3374);
        bTableRequest.setiDisplayLength(10);
        bTableRequest.setiDisplayStart(0);
        String result = fileService.getByLogPage(logsRequest,bTableRequest);
        result.length();
    }
    @Test
    public void testProduct(){
        GoodsRequest goodsRequest = new GoodsRequest();
        goodsRequest.setType(46);
        Conse result = goodsService.getByProductPage(goodsRequest,1);
        result.getData();

    }

    @Test
    public void testProductA(){
        BTableRequest bTableRequest = new BTableRequest();
        GoodsRequest goodsRequest = new GoodsRequest();
        bTableRequest.setiDisplayLength(10);
        bTableRequest.setiDisplayStart(0);
        //String result = goodsService.getAllProduct();
        //String text = result;
    }

    @Test
    public void testProductB(){

        GoodsRequest goodsRequest = new GoodsRequest();

        goodsRequest.setOrganId(6);
        Conse result = goodsService.getProductByOrganId(goodsRequest,1);
        result.getData();
    }

    @Test
    public void testPruductC(){
        Conse conse = goodsService.getOrganByProduct(16);
        conse.getData();
    }

    @Test
    public void testProductD(){
        Conse conse = goodsService.getTypeByParent(22);
        conse.getData();
    }

    @Test
    public void testCartA(){
        CartRequest cartRequest = new CartRequest();
        cartRequest.setOldmanId(36);
        cartRequest.setOrganId(9);
        cartRequest.setProductId(3);
        Conse conse = cartService.SaveInCart(cartRequest);
        conse.getClass();
    }

//    @Test
//    public void testCartB(){
//        BTableRequest bTableRequest = new BTableRequest();
//        bTableRequest.setiDisplayLength(10);
//        bTableRequest.setiDisplayStart(0);
//        String result = cartService.getProByOldmanId(bTableRequest);
//        String text = result;
//    }

//    @Test
//    public void testCartC(){
//        Conse conse = cartService.SaveInBook();
//        conse.getData();
//    }
    @Test
    public void testOutVisual(){
        BTableRequest bTableRequest = new BTableRequest();
        bTableRequest.setiDisplayLength(10);
        bTableRequest.setiDisplayStart(0);
        OldmanRequest oldmanRequest = new OldmanRequest();
        String[] jwIds = {"1","58","59","2"};
        oldmanRequest.setJw(jwIds);
        Conse conse = outVisualService.getNeiborComAndNum(oldmanRequest,bTableRequest);
        conse.getData();
    }

    @Test
    public void testProductBook(){
        BTableRequest bTableRequest = new BTableRequest();
        bTableRequest.setiDisplayLength(10);
        bTableRequest.setiDisplayStart(0);
        ProductBookRequest productBookRequest = new ProductBookRequest();
        productBookRequest.setOldmanId(36);
        String text = goodsService.getBookByPage(productBookRequest,bTableRequest);
        String result = text;
    }
    @Test
    public void testUser(){
        String name = "202018";
        Card user = oldsUserService.getByUsername(name);
        user.getMoney();
    }

    @Test
    public void testProductType(){
        Conse conse = productTypeService.getProductType();
        conse.getData();
    }
    @Test
    public void testJwTypes(){
        Conse conse = organService.getTypes();
        conse.getData();
    }

    @Test
    public void testImg() {
        try {
        File file = new File("D:/akira.png");
        FileInputStream fileInputStream = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile(file.getName(), file.getName(), ContentType.APPLICATION_OCTET_STREAM.toString(), fileInputStream);
        String name = OssClientUtil.uploadImg2Oss(multipartFile);
        String imgUrl = OssClientUtil.getImgUrl(name);
        String result = imgUrl;
        } catch (Exception e) {
            throw new OtherServiceException("shibai");
        }
    }

    @Test
    public void saveInTheBook(){
        ProductBookRequest productBookRequest = new ProductBookRequest();
        productBookRequest.setOldmanId(3374);
        String[] ids = {"6"};
        productBookRequest.setBookIds(ids);
        cartService.SaveInBook(productBookRequest);
    }
}
