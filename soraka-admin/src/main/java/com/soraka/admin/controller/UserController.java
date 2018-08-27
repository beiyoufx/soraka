package com.soraka.admin.controller;

import com.soraka.admin.model.domain.UserDO;
import com.soraka.admin.model.dto.Page;
import com.soraka.admin.model.dto.QueryParam;
import com.soraka.admin.model.dto.R;
import com.soraka.admin.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    @ApiOperation("查询用户列表")
    public R find(QueryParam queryParam) {
        Page page = userService.findPage(queryParam);
        R r = R.success();
        r.setData(page);
        return r;
    }
}
