package com.organOld.web;

import com.alibaba.fastjson.JSONObject;
import com.organOld.oService.contract.Conse;
import com.organOld.oService.exception.OtherServiceException;
import com.organOld.oService.exception.ServiceException;
import com.organOld.oService.service.ComService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class GlobalExceptionHandler {
    @Autowired
    ComService comService;
    private  static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    /**
     * 处理所有不可知的异常
     * @param  e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    Conse handleException(Exception e){
        logger.error(e.getMessage(),e);
        Conse conse = new Conse(false);
        conse.setError(e.getMessage());
        return conse;
    }
    /**
     * 处理所有业务异常
     * @param  se
     * @return
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    Conse handleServiceException(ServiceException se){
        logger.error(se.getMessage(),se);
        Conse conse = new Conse(false);
        conse.setError(se.getMessage());
        return conse;
    }

    @ExceptionHandler(OtherServiceException.class)
    @ResponseBody
    String handleOtherServicwException(OtherServiceException ose){
        logger.error(ose.getMessage(),ose);
        JSONObject getObj = new JSONObject();
        getObj.put("error",ose.getMessage());
        return getObj.toString();
    }
}
