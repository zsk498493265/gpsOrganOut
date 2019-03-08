package com.organOld.web.controller;

import com.organOld.oService.contract.Conse;
import com.organOld.oService.tool.OssClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/img")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ImgController {
    @Autowired
    OssClientUtil ossClient;

    @ResponseBody
    @RequestMapping(value = "/upload",method = RequestMethod.GET)
    public Conse uploadImg(MultipartFile multipartFile){
        String name = ossClient.uploadImg2Oss(multipartFile);
        String imgUrl = ossClient.getImgUrl(name);
        return new Conse(true,imgUrl);
    }
}
