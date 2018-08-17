package com.soraka.admin.dao;

import com.soraka.admin.model.domain.UserDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDAOTest {

    @Autowired
    UserDAO userDAO;

    @Test
    public void get() {
        UserDO user = userDAO.get(1L);
        Assert.assertNotNull(user);
    }
}
