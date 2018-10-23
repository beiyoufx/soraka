package com.soraka.admin.controller;

import com.soraka.common.constant.Constants;
import com.soraka.common.model.domain.MenuDO;
import com.soraka.common.model.dto.Page;
import com.soraka.admin.model.dto.QueryParam;
import com.soraka.common.model.dto.R;
import com.soraka.admin.model.dto.VueRouter;
import com.soraka.admin.model.vo.MenuTreeVO;
import com.soraka.admin.service.MenuService;
import com.soraka.admin.util.TreeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
    private MenuService menuService;

    @GetMapping("{id}")
    @ApiOperation("获取菜单详情")
    public R get(@PathVariable("id") Long id) {
        MenuDO menu = menuService.get(id);
        R r = R.success();
        r.setData(menu);
        return r;
    }

    @GetMapping
    @ApiOperation("查询菜单列表")
    public R find(QueryParam queryParam) {
        Page page = menuService.findPage(queryParam);
        R r = R.success();
        r.setData(page);
        return r;
    }

    @PostMapping
    @ApiOperation("添加菜单")
    public R save(@Valid @RequestBody MenuDO menuDO) {
        return R.operate(menuService.save(menuDO));
    }

    @PutMapping
    @ApiOperation("更新菜单信息")
    public R update(@RequestBody MenuDO menuDO) {
        return R.operate(menuService.update(menuDO));
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "删除菜单", notes = "根据菜单ID删除")
    public R delete(@PathVariable("id") Long id) {
        return R.operate(menuService.delete(id));
    }

    @GetMapping("userMenu")
    @ApiOperation("查询用户路由树")
    public R findUserMenu() {
        R r = R.success();
        // TODO 获取用户角色
        List<String> roleKeys = new ArrayList<>();
        roleKeys.add("admin");
        roleKeys.add("tech");
        roleKeys.add("editor");
        List<MenuDO> menus = menuService.getRoleMenu(roleKeys);
        List<VueRouter> routers = new ArrayList<>();
        menus.forEach(menuDO -> {
            if (Constants.MENU == menuDO.getType()) {
                routers.add(new VueRouter(menuDO));
            }
        });
        Collections.sort(routers, Comparator.comparingInt(VueRouter::getSort));
        r.setData(TreeUtil.bulid(routers, 0L));
        return r;
    }

    @GetMapping("tree")
    @ApiOperation("查询菜单树")
    public R findMenuTree() {
        R r = R.success();
        List<MenuDO> menus = menuService.findAll();
        List<MenuTreeVO> menuTrees = new ArrayList<>();
        menus.forEach(menuDO -> {
            menuTrees.add(new MenuTreeVO(menuDO));
        });
        Collections.sort(menuTrees, Comparator.comparingInt(MenuTreeVO::getSequence));
        r.setData(TreeUtil.bulid(menuTrees, 0L));
        return r;
    }
}
