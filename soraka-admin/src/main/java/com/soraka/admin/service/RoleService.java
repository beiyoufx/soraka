package com.soraka.admin.service;

import com.soraka.admin.model.domain.RoleDO;
import com.soraka.admin.model.dto.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色
 *
 * @author yongjie.teng
 * @date 2018/8/16
 * @package com.soraka.admin.service
 */
@Service
public interface RoleService {
    /**
     * 根据主键获取角色
     *
     * @param id 主键
     * @return {@link RoleDO}
     */
    RoleDO get(Long id);

    /**
     * 获取用户角色集合
     *
     * @param userId 用户主键
     * @return List<RoleDO>
     */
    List<RoleDO> findByUserId(Long userId);


    /**
     * 获取用户角色ID集合
     *
     * @param userId 用户主键
     * @return List<Long>
     */
    List<Long> findRoleIdsByUserId(Long userId);

    /**
     * 获取所有角色
     *
     * @return List<RoleDO>
     */
    List<RoleDO> findAll();

    /**
     * 获取所有角色页
     *
     * @return {@link Page}
     */
    Page findPage();
}
