package com.soraka.admin.service;

import com.soraka.common.model.domain.UserDO;
import com.soraka.common.model.dto.Page;
import com.soraka.admin.model.dto.QueryParam;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void get() {
        UserDO user = userService.get(1L);
        Assert.assertNotNull(user);
    }

    @Test
    public void findPage() {
        QueryParam param = new QueryParam();
        param.setQueryText("soraka");
        Page page = userService.findPage(param);
    }
}
