package com.soraka.admin.service;

import com.soraka.admin.domain.MenuDO;
import org.springframework.stereotype.Service;

/**
 * 菜单
 *
 * @author yongjie.teng
 * @date 2018/8/16
 * @package com.soraka.admin.service
 */
@Service
public interface MenuService {
    /**
     * 根据主键获取菜单
     *
     * @param id 主键
     * @return {@link MenuDO}
     */
    MenuDO get(Long id);
}
