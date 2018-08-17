package com.soraka.admin.dao;

import com.soraka.admin.model.domain.UserDO;

/**
 * 系统用户
 *
 * @author yongjie.teng
 * @date 2018/8/15
 * @package com.soraka.admin.dao
 */
public interface UserDAO {
    /**
     * 通过主键获取用户
     *
     * @param id 主键
     * @return {@link UserDO}
     */
    UserDO get(Long id);
}
