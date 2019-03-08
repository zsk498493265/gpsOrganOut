package com.organOld.web.intercept;

import com.organOld.dao.entity.Card;
import com.organOld.dao.repository.CardDao;
import com.organOld.oService.constant.Constant;
import com.organOld.oService.exception.ServiceException;
import com.organOld.oService.service.TokenMgrService;
import com.organOld.oService.tool.Cache;
import io.jsonwebtoken.Claims;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


public class WebIntercepter implements HandlerInterceptor {
    @Autowired
    TokenMgrService tokenMgrService;
    @Autowired
    CardDao cardDao;


    private static final Logger logger = LoggerFactory.getLogger(WebIntercepter.class);

    @Override
    public void afterCompletion(HttpServletRequest arg0,
                                HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {

    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        //请求URL
        String url = request.getServletPath().toString();

        //如果是登录则不拦截开始
        if (url.equals("/organOut/login")) {
            return true;
        } else {
//            String tokenStr = request.getParameter("token");
//            if (tokenStr == null || tokenStr.equals("")) {
//                PrintWriter printWriter = response.getWriter();
//                printWriter.print("用户未登录");
//                printWriter.flush();
//                printWriter.close();
              return true;
         }

//            Claims claims = null;
//            claims = tokenMgrService.parseJWT(tokenStr);
//            String username = claims.getId();
//            if (Cache.checkCacheName(username))
//
//                return true;
//        }
           // return true;

            // 验证JWT的签名，返回CheckResult对象
            //CheckResult checkResult = tokenMgrService.validateJWT(tokenStr);
//        if (checkResult.isSuccess()) {
//            Claims claims = checkResult.getClaims();
//            logger.info("token校检通过checkResult："+GsonUtil.objectToJsonStr(checkResult));
//            SubjectModel user = GsonUtil.jsonStrToObject(claims.getSubject(), SubjectModel.class);
//            logger.info("token校检通过user："+GsonUtil.objectToJsonStr(user));
//            return true;
//        } else {
//            switch (checkResult.getErrCode()) {
//                // 签名过期，返回过期提示码
//                case Constant.JWT_ERRCODE_EXPIRE:
//                    PrintWriter printWriter = response.getWriter();
//                    printWriter.print(ResponseMgr.loginExpire());
//                    printWriter.flush();
//                    printWriter.close();
//                    break;
//                // 签名验证不通过
//                case Constant.JWT_ERRCODE_FAIL:
//                    PrintWriter printWriter2 = response.getWriter();
//                    printWriter2.print(ResponseMgr.noAuth());
//                    printWriter2.flush();
//                    printWriter2.close();
//                    break;
//                default:
//                    break;
//            }

        }

    }

