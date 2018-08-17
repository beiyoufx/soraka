package com.soraka.admin.controller;

import com.soraka.admin.model.domain.UserDO;
import com.soraka.admin.model.dto.R;
import com.soraka.admin.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yongjie.teng
 * @date 2018/8/17
 * @package com.soraka.admin.controller
 */
@Api(tags = "用户服务")
@RequestMapping("user")
@RestController
public class UserController extends BaseController {
    @Autowired
    UserService userService;

    @GetMapping("{id}")
    @ApiOperation("获取用户详情")
    public R get(@PathVariable("id") Long id) {
        UserDO user = userService.get(id);
        R r = R.success();
        r.setData(user);
        return r;
    }
}
