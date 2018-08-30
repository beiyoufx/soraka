package com.soraka.admin.service.impl;

import com.soraka.admin.dao.MenuDAO;
import com.soraka.admin.model.domain.MenuDO;
import com.soraka.admin.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

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
    @Transactional(readOnly = true, rollbackFor = {RuntimeException.class})
    @Override
    public MenuDO get(Long id) {
        return menuDAO.get(id);
    }

    /**
     * 获取用户菜单
     *
     * @param userId 用户ID
     * @return List<MenuDO>
     */
    @Transactional(readOnly = true, rollbackFor = {RuntimeException.class})
    @Override
    public List<MenuDO> findByUserId(Long userId) {
        return menuDAO.findByUserId(userId);
    }

    /**
     * 获取用户权限集合
     *
     * @param userId 用户ID
     * @return List<MenuDO>
     */
    @Transactional(readOnly = true, rollbackFor = {RuntimeException.class})
    @Override
    public List<String> getUserPermission(Long userId) {
        List<MenuDO> menus = findByUserId(userId);
        List<String> perms = new ArrayList<String>();
        for (MenuDO menu : menus) {
            if (!StringUtils.isEmpty(menu.getPermission())) {
                perms.add(menu.getPermission());
            }
        }
        return perms;
    }
}
