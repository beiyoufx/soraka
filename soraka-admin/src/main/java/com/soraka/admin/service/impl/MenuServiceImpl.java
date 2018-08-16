package com.soraka.admin.service.impl;

import com.soraka.admin.dao.MenuDAO;
import com.soraka.admin.domain.MenuDO;
import com.soraka.admin.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yongjie.teng
 * @date 2018/8/16
 * @package com.soraka.admin.service.impl
 */
@Transactional(rollbackFor = {RuntimeException.class})
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuDAO menuDAO;

    /**
     * 根据主键获取菜单
     *
     * @param id 主键
     * @return {@link MenuDO}
     */
    @Override
    public MenuDO get(Long id) {
        return menuDAO.get(id);
    }
}
