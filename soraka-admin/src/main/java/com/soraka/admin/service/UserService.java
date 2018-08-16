package com.soraka.admin.service;

import com.soraka.admin.domain.UserDO;
import org.springframework.stereotype.Service;

/**
 * 系统用户
 *
 * @author yongjie.teng
 * @date 2018/8/16
 * @package com.soraka.admin.service
 */
@Service
public interface UserService {
    /**
     * 根据主键获取用户信息
     *
     * @param id 主键
     * @return {@link UserDO}
     */
    UserDO get(Long id);
}
