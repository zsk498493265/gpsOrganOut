package com.organOld.oService.constant;

public class Constant {
    /**
     * 成功
     */
    public static final int RESCODE_SUCCESS = 1000;//成功(无返回数据)

    /**
     * 失败
     */
    public static final int RESCODE_EXCEPTION = 1001;//请求抛出异常
    public static final int RESCODE_NOLOGIN = 1002;	//未登陆状态
    public static final int RESCODE_NOAUTH = 1003;//无操作权限
    public static final int RESCODE_LOGINEXPIRE = 1004;//登录过期

    /**
     * token
     */
    public static final int JWT_ERRCODE_EXPIRE = 1005;//Token过期
    public static final int JWT_ERRCODE_FAIL = 1006;//验证不通过

    /**
     * jwt
     */
    public static final String JWT_ISS = "organOldOut";	//jwt签发者
    public static final String JWT_SECERT = "46cc793c53dc451b8a4fe2cd0bb00847";//密匙
    public static final long JWT_TTL = 2 *60*60*1000;//token有效时间,单位毫秒

    public static final String url = "http://47.101.138.13:81/";
}
