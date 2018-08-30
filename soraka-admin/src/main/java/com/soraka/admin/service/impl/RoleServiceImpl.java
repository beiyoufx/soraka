package com.soraka.admin.service.impl;

import com.soraka.admin.dao.RoleDAO;
import com.soraka.admin.model.domain.RoleDO;
import com.soraka.admin.model.dto.Page;
import com.soraka.admin.model.dto.QueryParam;
import com.soraka.admin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yongjie.teng
 * @date 2018/8/16
 * @package com.soraka.admin.service.impl
 */
@Transactional(rollbackFor = {RuntimeException.class})
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDAO roleDAO;
    /**
     * 根据主键获取角色
     *
     * @param id 主键
     * @return {@link RoleDO}
     */
    @Transactional(readOnly = true, rollbackFor = {RuntimeException.class})
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
    @Transactional(readOnly = true, rollbackFor = {RuntimeException.class})
    @Override
    public List<RoleDO> findByUserId(Long userId) {
        return roleDAO.findByUserId(userId);
    }

    /**
     * 获取所有角色
     *
     * @return List<RoleDO>
     */
    @Transactional(readOnly = true, rollbackFor = {RuntimeException.class})
    @Override
    public List<RoleDO> findAll() {
        return roleDAO.find(new QueryParam());
    }

    /**
     * 查询角色列表页
     *
     * @param queryParam 查询参数
     * @return {@link Page}
     */
    @Transactional(readOnly = true, rollbackFor = {RuntimeException.class})
    @Override
    public Page findPage(QueryParam queryParam) {
        Page page = new Page();
        List<RoleDO> roles;
        int total = roleDAO.count(queryParam);
        page.setTotal(total);
        if (total > 0) {
            roles = roleDAO.find(queryParam);
            page.setRows(roles);
        } else {
            page.setRows(new ArrayList<>());
        }
        return page;
    }

    /**
     * 新增角色
     *
     * @param roleDO
     * @return true 成功 false 失败
     */
    @Override
    public boolean save(RoleDO roleDO) {
        return roleDAO.save(roleDO) > 0;
    }

    /**
     * 更新角色
     *
     * @param roleDO
     * @return true 成功 false 失败
     */
    @Override
    public boolean update(RoleDO roleDO) {
        return roleDAO.update(roleDO) > 0;
    }

    /**
     * 删除角色
     *
     * @param id 角色ID
     * @return true 成功 false 失败
     */
    @Override
    public boolean delete(Long id) {
        return roleDAO.delete(id) > 0;
    }

}
