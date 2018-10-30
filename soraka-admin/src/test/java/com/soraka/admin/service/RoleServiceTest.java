package com.soraka.admin.service;

import com.soraka.common.model.domain.RoleDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceTest {

    @Autowired
    RoleService roleService;

    @Test
    public void get() {
        RoleDO role = roleService.get(1L);
        Assert.assertNotNull(role);
    }

    @Test
    public void findByUserId() {
        List<RoleDO> roles = roleService.findByUserId(1L);
        Assert.assertEquals(1, roles.size());
    }

    @Test
    public void findAll() {
        List<RoleDO> roles = roleService.findAll();
        Assert.assertEquals(1, roles.size());
    }
}
