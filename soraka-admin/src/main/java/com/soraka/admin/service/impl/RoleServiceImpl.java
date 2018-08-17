package com.soraka.admin.service.impl;

import com.soraka.admin.dao.RoleDAO;
import com.soraka.admin.model.domain.RoleDO;
import com.soraka.admin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yongjie.teng
 * @date 2018/8/16
 * @package com.soraka.admin.service.impl
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDAO roleDAO;
    /**
     * 根据主键获取角色
     *
     * @param id 主键
     * @return {@link RoleDO}
     */
    @Override
    public RoleDO get(Long id) {
        return roleDAO.get(id);
    }

    /**
     * 获取用户角色集合
     *
     * @param userId 用户主键
     * @return List<RoleDO>
     */
    @Override
    public List<RoleDO> findByUserId(Long userId) {
        return roleDAO.findByUserId(userId);
    }

    /**
     * 获取所有角色
     *
     * @return List<RoleDO>
     */
    @Override
    public List<RoleDO> findAll() {
        return roleDAO.findAll();
    }

    /**
     * 获取角色总数
     *
     * @return {@link Integer}
     */
    @Override
    public Integer countAll() {
        return roleDAO.countAll();
    }
}
