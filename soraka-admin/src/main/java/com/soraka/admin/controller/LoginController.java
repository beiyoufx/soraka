package com.soraka.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 * @author yongjie.teng
 * @date 2018/8/9
 * @package com.soraka.admin.controller
 */
@Api(tags = "登陆服务")
@RestController
public class LoginController {

    @ApiOperation("Hello接口")
    @GetMapping("hello")
    public String hello() {
        return "hello world! here is admin";
    }
}
