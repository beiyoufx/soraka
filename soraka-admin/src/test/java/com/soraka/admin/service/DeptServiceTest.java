package com.soraka.admin.service;

import com.soraka.admin.model.domain.DeptDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeptServiceTest {

    @Autowired
    DeptService deptService;

    @Test
    public void get() {
        DeptDO dept = deptService.get(1L);
        Assert.assertNotNull(dept);
    }
}
