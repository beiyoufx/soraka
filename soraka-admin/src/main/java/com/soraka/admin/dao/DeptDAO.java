package com.soraka.admin.dao;

import com.soraka.admin.model.domain.DeptDO;

/**
 * 部门
 *
 * @author yongjie.teng
 * @date 2018/8/15
 * @package com.soraka.admin.dao
 */
public interface DeptDAO {
    /**
     * 通过主键获取部门
     *
     * @param id 主键
     * @return {@link DeptDO}
     */
    DeptDO get(Long id);
}
