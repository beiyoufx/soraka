package com.soraka.admin.controller;

import com.soraka.admin.model.domain.RoleDO;
import com.soraka.admin.model.domain.UserDO;
import com.soraka.admin.model.dto.Page;
import com.soraka.admin.model.dto.QueryParam;
import com.soraka.admin.model.dto.R;
import com.soraka.admin.model.vo.UserVO;
import com.soraka.admin.service.RoleService;
import com.soraka.admin.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping("{id}")
    @ApiOperation("获取用户详情")
    public R get(@PathVariable("id") Long id) {
        UserDO user = userService.get(id);
        R r = R.success();
        r.setData(user);
        return r;
    }

    @GetMapping("{id}/role")
    @ApiOperation("获取用户角色详情")
    public R getUserRole(@PathVariable("id") Long id) {
        List<RoleDO> roles = roleService.findByUserId(id);
        R r = R.success();
        r.setData(roles);
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

    @PostMapping
    @ApiOperation("添加用户")
    public R save(@Valid @RequestBody UserVO userVO) {
        userVO.setSalt(userService.randomSalt());
        userVO.setPassword(userService.encryptPassword(userVO.getUsername(), userVO.getNewPassword(), userVO.getSalt()));
        return R.operate(userService.save(userVO));
    }

    @PutMapping
    @ApiOperation("更新用户信息")
    public R update(@RequestBody UserVO userVO) {
        if (StringUtils.isNotBlank(userVO.getNewPassword())) {
            userVO.setSalt(userService.randomSalt());
            userVO.setPassword(userService.encryptPassword(userVO.getUsername(), userVO.getNewPassword(), userVO.getSalt()));
        }
        return R.operate(userService.update(userVO));
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "删除用户", notes = "根据用户ID删除")
    public R delete(@PathVariable("id") Long id) {
        return R.operate(userService.delete(id));
    }
}
