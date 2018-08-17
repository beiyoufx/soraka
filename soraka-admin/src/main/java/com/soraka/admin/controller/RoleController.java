package com.soraka.admin.controller;

import com.soraka.admin.model.domain.RoleDO;
import com.soraka.admin.model.dto.Page;
import com.soraka.admin.model.dto.R;
import com.soraka.admin.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yongjie.teng
 * @date 2018/8/17
 * @package com.soraka.admin.controller
 */
@Api(tags = "角色服务")
@RequestMapping("role")
@RestController
public class RoleController extends BaseController {
    @Autowired
    RoleService roleService;

    @GetMapping
    @ApiOperation("获取所有角色")
    public R findAll() {
        Page page = new Page();
        List<RoleDO> roles;
        int total = roleService.countAll();
        page.setTotal(total);
        if (total > 0) {
            roles = roleService.findAll();
            page.setRows(roles);
        } else {
            page.setRows(new ArrayList<>());
        }
        R r = R.success();
        r.setData(page);
        return r;
    }

    @GetMapping("{id}")
    @ApiOperation("获取角色详情")
    public R get(@PathVariable("id") Long id) {
        RoleDO role = roleService.get(id);
        R r = R.success();
        r.setData(role);
        return r;
    }
}
