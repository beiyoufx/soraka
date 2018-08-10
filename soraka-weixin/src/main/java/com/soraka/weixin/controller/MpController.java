package com.soraka.weixin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yongjie.teng
 * @date 2018/8/10
 * @package com.soraka.weixin.controller
 */
@Api(tags = "媒体服务")
@RestController
public class MpController {
    @ApiOperation("Hello接口")
    @GetMapping("hello")
    public String hello() {
        return "hello world! here is mp";
    }
}
