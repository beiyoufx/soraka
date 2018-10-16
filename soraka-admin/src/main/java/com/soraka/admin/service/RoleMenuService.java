package com.soraka.admin.service;

import com.soraka.admin.model.domain.RoleMenuDO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色菜单
 *
 * @author yongjie.teng
 * @date 2018/10/16
 * @package com.soraka.admin.service
 */
@Service
public interface RoleMenuService {

    /**
     * 获取角色菜单ID集合
     *
     * @param roleId 角色主键
     * @return List<Long>
     */
    List<Long> findMenuIdsByRoleId(Long roleId);

    /**
     * 删除角色菜单关系
     *
     * @param roleId 角色主键
     * @return 受影响行数
     */
    Integer deleteByRoleId(Long roleId);

    /**
     * 批量保存角色菜单关系
     *
     * @param roleMenus 角色菜单
     * @return 受影响行数
     */
    Integer batchSave(List<RoleMenuDO> roleMenus);
}
