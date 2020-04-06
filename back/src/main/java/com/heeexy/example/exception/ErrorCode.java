package com.heeexy.example.exception;

public class ErrorCode {

    /**
     *  公共异常错误码
     */
    public static final String UNKNOWN_ERROR="未知异常";
    public static final String DATABASE_ERROR="数据库异常";
    public static final String SESSION_TIMEOUT="请登录后访问";
    public static final String NO_PERMISSION="没有权限进行该项操作！";
    /**
     * 用户
     */
    public static final String USER_NOT_EXIST="用户名错误";
    public static final String USER_PWD_NOT_MATCH="密码错误";
    public static final String USER_NOT_VERIFY="用户未审核通过";
    public static final String USERNAME_EXIST="账号已存在";
    public static final String USER_NOT_ENABLE="用户未激活";
    public static final String USER_OLD_PWD_NOT_MATCH="原始密码错误";

}
