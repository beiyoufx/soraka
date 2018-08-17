package com.soraka.admin.service;

import com.soraka.admin.model.domain.MenuDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
}
