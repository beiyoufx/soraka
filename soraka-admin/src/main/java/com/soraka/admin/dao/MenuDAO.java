package com.soraka.admin.dao;

import com.soraka.admin.domain.MenuDO;

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
}
