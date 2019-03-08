package com.organOld.web.controller;

import com.organOld.oService.contract.Conse;
import com.organOld.oService.contract.OrganRegRequest;
import com.organOld.oService.service.OrganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
@Controller
@RequestMapping("/organ")
@CrossOrigin(origins = "*", maxAge = 3600)
public class OrganController {
    @Autowired
    OrganService organService;
    @ResponseBody
    @RequestMapping(value = "/reg",method = RequestMethod.POST)
    public Conse reg(HttpServletRequest request,
                     @RequestParam(value = "pic",required = false)MultipartFile file){
        OrganRegRequest organRegRequest = new OrganRegRequest();
        organRegRequest.setPersonPhone(request.getParameter("personPhone"));
        organRegRequest.setName(request.getParameter("name"));
        organRegRequest.setEmail(request.getParameter("email"));
        organRegRequest.setOrganTypeId(Integer.parseInt(request.getParameter("organTypeId")));
        organRegRequest.setIntro(request.getParameter("intro"));
        organRegRequest.setWork(request.getParameter("work"));
        organRegRequest.setServiceTime(request.getParameter("serviceTime"));
        organRegRequest.setAddress(request.getParameter("address"));
        organRegRequest.setPhone(request.getParameter("webUrl"));
        if(request.getParameter("num") != null)
        organRegRequest.setNum(Integer.parseInt(request.getParameter("num")));
        organRegRequest.setDistrictId(request.getParameter("districtId"));
        String[] authArray = {"product"};
        organRegRequest.setPicFile(file);
        organRegRequest.setAuthArray(authArray);
        Conse result=organService.reg(organRegRequest,request);
        return result;
    }

//    @RequestMapping(value = "/organReg",method = RequestMethod.GET)
//    public ModelAndView organReg(){
//        ModelAndView mv=new ModelAndView("organ/organ_reg");
//        mv.addObject("info",organService.getRegInfo());
//        return mv;
//    }
}
