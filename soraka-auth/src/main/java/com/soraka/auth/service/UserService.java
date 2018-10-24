package com.soraka.auth.service;

import com.soraka.common.model.domain.RoleDO;
import com.soraka.common.model.domain.UserDO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户服务
 *
 * @author yongjie.teng
 * @date 2018/10/19
 * @package com.soraka.auth.service
 */
@Service
public class UserService {
    public UserDO getByUsername(String username) {
        UserDO userDO = new UserDO();
        userDO.setId(100L);
        userDO.setUsername(username);
        userDO.setPassword("123456");
        userDO.setStatus(1);
        return userDO;
    }

    public List<RoleDO> getUserRole(Long id) {
        return new ArrayList<>();
    }
}
