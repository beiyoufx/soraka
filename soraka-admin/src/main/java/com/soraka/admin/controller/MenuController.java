package com.soraka.admin.controller;

import com.soraka.admin.model.domain.MenuDO;
import com.soraka.admin.model.dto.R;
import com.soraka.admin.service.MenuService;
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
@Api(tags = "菜单服务")
@RequestMapping("menu")
@RestController
public class MenuController extends BaseController {
    @Autowired
    MenuService menuService;

    @GetMapping("{id}")
    @ApiOperation("获取菜单详情")
    public R get(@PathVariable("id") Long id) {
        MenuDO menu = menuService.get(id);
        R r = R.success();
        r.setData(menu);
        return r;
    }
}
