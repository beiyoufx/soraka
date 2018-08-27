package com.soraka.admin.controller;

import com.soraka.admin.model.dto.LoginDTO;
import com.soraka.admin.model.dto.R;
import com.soraka.admin.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 测试
 * @author yongjie.teng
 * @date 2018/8/9
 * @package com.soraka.admin.controller
 */
@Slf4j
@Api(tags = "登录服务")
@RestController
public class LoginController extends BaseController {
    @Autowired
    UserService userService;

    @ApiOperation("登录接口")
    @PostMapping("login")
    public R login(@Valid @RequestBody LoginDTO loginDTO) {
        if (StringUtils.isEmpty(loginDTO.getUsername()) || StringUtils.isEmpty(loginDTO.getPassword())) {
            return R.fail();
        }
        R r = userService.login(loginDTO.getUsername().trim(), loginDTO.getPassword().trim());
        return r;
    }

    @ApiOperation("退出接口")
    @GetMapping("logout")
    public R logout() {
        //todo
        R r = R.success();
        r.setData("退出成功");
        return r;
    }
}
