package com.soraka.admin.model.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 登录参数
 * @author yongjie.teng
 * @date 2018/8/27
 * @package com.soraka.admin.model.dto
 */
@Data
public class LoginDTO {
    /**
     * 用户名
     */
    @NotNull
    private String username;

    /**
     * 密码
     */
    @NotNull
    private String password;

    /**
     * 验证码
     */
    private String captcha;
}
