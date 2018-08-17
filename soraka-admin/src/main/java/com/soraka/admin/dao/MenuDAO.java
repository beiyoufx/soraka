package com.soraka.admin.dao;

import com.soraka.admin.model.domain.MenuDO;

import java.util.List;

/**
 * 菜单
 *
 * @author yongjie.teng
 * @date 2018/8/15
 * @package com.soraka.admin.dao
 */
public interface MenuDAO {
    /**
     * 通过主键获取菜单
     *
     * @param id 主键
     * @return {@link MenuDO}
     */
    MenuDO get(Long id);

    /**
     * 获取用户菜单
     *
     * @param userId 用户ID
     * @return List<MenuDO>
     */
    List<MenuDO> findByUserId(Long userId);
}
