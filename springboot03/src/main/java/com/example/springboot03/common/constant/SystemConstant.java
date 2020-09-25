package com.example.springboot03.common.constant;

/**
 * @author liqin
 * @date 2020/9/24 14:07
 */
public class SystemConstant {
    /**
     * 默认过期天数
     */
    public static final int DEFAULT_EXPIRE_DAYS = 365;

    /**
     * 默认密码长度6位
     */
    public static final int DEFAULT_PASSWORD_LENGTH = 6;

    /**
     * 默认license长度32位
     */
    public static final int DEFAULT_LICENSE_LENGTH = 32;

    /**
     * 默认密码
     */
    public static final String DEFAULT_PASSWORD = "123456";

    /**
     * 默认密码,6-16位 大小写字母和数字都至少一位
     */
    public static final String DEFAULT_PASSWORD_REX = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z\\d]{6,16}$";

    /**
     * 用户id
     */
    public static final String USER_ID = "userId";
    /**
     * 角色id
     */
    public static final String ROLE_ID = "roleId";

    /**
     * 访问权限token
     */
    public static final String TOKEN = "token";
    /**
     * 验证码
     */
    public static final String VERIFY_CODE = "verifyCode";
    /**
     * 公司邮箱后缀
     */
    public static final String COMPANY_EMAIL_SUFFIX = "@pystandard.com";
    /**
     * 邮箱正则
     */
    public static final String EMAIL_REX = "[a-z0-9A-Z]+[-|a-z0-9A-Z._]+@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
    /**
     * 大写字母
     */
    public static final String[] UPPER_ALPHABET = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

}
