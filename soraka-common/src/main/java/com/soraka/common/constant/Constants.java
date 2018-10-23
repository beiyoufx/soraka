package com.soraka.common.constant;

/**
 * @author yongjie.teng
 * @date 2018/8/27
 * @package com.soraka.admin.constants
 */
public class Constants {
    /**
     * 用户相关常量
     */
    public static final int USER_STATUS_NORMAL = 1;
    public static final int USER_STATUS_BLOCKED = 0;
    /**
     * 各种正则表达式
     */
    public static final String USERNAME_PATTERN = "^[\\u4E00-\\u9FA5\\uf900-\\ufa2d_a-zA-Z][\\u4E00-\\u9FA5\\uf900-\\ufa2d\\w]{1,19}$";
    public static final String MOBILE_PHONE_PATTERN = "^0{0,1}(13[0-9]|15[0-9]|14[0-9]|18[0-9])[0-9]{8}$";
    public static final String EMAIL_PATTERN = "^\\w+([-.]\\w+)*@\\w+([-]\\w+)*\\.(\\w+([-]\\w+)*\\.)*[a-z]{2,3}$";
    /**
     * 菜单类型
     */
    public static final int MENU = 1;
    public static final int BUTTON = 2;
    /**
     * 基本角色
     */
    public static final String BASE_ROLE = "ROLE_USER";
    /**
     * 安全相关
     */
    public static final String SORAKA_LICENSE = "Made By SORAKA";
}
