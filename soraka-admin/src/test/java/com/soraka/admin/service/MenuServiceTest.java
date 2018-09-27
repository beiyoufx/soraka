package com.soraka.admin.service;

import com.soraka.admin.constants.Constants;
import com.soraka.admin.model.domain.MenuDO;
import com.soraka.admin.model.dto.VueRouter;
import com.soraka.admin.util.TreeUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuServiceTest {

    @Autowired
    MenuService menuService;

    @Test
    public void get() {
        MenuDO menu = menuService.get(1L);
        Assert.assertNotNull(menu);
    }

    @Test
    public void getUserPermission()  {
        List<String> perms = menuService.getUserPermission(1L);
        Assert.assertNotEquals(0, perms.size());
    }

    @Test
    public void getRoleMenu() {
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
        List<VueRouter> tree = TreeUtil.bulid(routers, 0L);
        System.out.println(tree);
        Assert.assertNotEquals(0, menus.size());
    }
}
