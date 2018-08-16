package com.soraka.admin.dao;

import com.soraka.admin.domain.RoleDO;

/**
 * 角色
 *
 * @author yongjie.teng
 * @date 2018/8/16
 * @package com.soraka.admin.dao
 */
public interface RoleDAO {
    /**
     * 通过主键获取角色
     *
     * @param id 主键
     * @return {@link RoleDO}
     */
    RoleDO get(Long id);
}
