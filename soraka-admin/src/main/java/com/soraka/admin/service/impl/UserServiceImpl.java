package com.soraka.admin.service.impl;

import com.soraka.admin.dao.UserDAO;
import com.soraka.common.model.domain.UserDO;
import com.soraka.common.model.domain.UserRoleDO;
import com.soraka.common.model.dto.Page;
import com.soraka.admin.model.dto.QueryParam;
import com.soraka.admin.service.UserRoleService;
import com.soraka.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yongjie.teng
 * @date 2018/8/16
 * @package com.soraka.admin.service.impl
 */
@Transactional(rollbackFor = {RuntimeException.class})
@Service
public class UserServiceImpl implements UserService {
    private PasswordEncoder encoder = new BCryptPasswordEncoder();
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private UserRoleService userRoleService;

    /**
     * 根据主键获取用户信息
     *
     * @param id 主键
     * @return {@link UserDO}
     */
    @Transactional(readOnly = true, rollbackFor = {RuntimeException.class})
    @Override
    public UserDO get(Long id) {
        UserDO userDO = userDAO.get(id);
        if (userDO != null) {
            userDO.setRoles(userRoleService.findRoleIdsByUserId(userDO.getId()));
        }
        return userDO;
    }

    /**
     * 根据用户名获取用户
     *
     * @param username 用户名
     * @return {@link UserDO}
     */
    @Transactional(readOnly = true, rollbackFor = {RuntimeException.class})
    @Override
    public UserDO getByUsername(String username) {
        UserDO userDO = userDAO.getByUsername(username);
        if (userDO != null) {
            userDO.setRoles(userRoleService.findRoleIdsByUserId(userDO.getId()));
        }
        return userDO;
    }

    /**
     * 根据手机号获取用户
     *
     * @param mobilephone 手机号
     * @return {@link UserDO}
     */
    @Transactional(readOnly = true, rollbackFor = {RuntimeException.class})
    @Override
    public UserDO getByMobilephone(String mobilephone) {
        UserDO userDO = userDAO.getByMobilephone(mobilephone);
        if (userDO != null) {
            userDO.setRoles(userRoleService.findRoleIdsByUserId(userDO.getId()));
        }
        return userDO;
    }

    /**
     * 根据邮箱获取用户
     *
     * @param email 邮箱
     * @return {@link UserDO}
     */
    @Transactional(readOnly = true, rollbackFor = {RuntimeException.class})
    @Override
    public UserDO getByEmail(String email) {
        UserDO userDO = userDAO.getByEmail(email);
        if (userDO != null) {
            userDO.setRoles(userRoleService.findRoleIdsByUserId(userDO.getId()));
        }
        return userDO;
    }

    /**
     * 查询用户列表页
     *
     * @param queryParam 查询参数
     * @return {@link Page}
     */
    @Transactional(readOnly = true, rollbackFor = {RuntimeException.class})
    @Override
    public Page findPage(@NotNull QueryParam queryParam) {
        Page page = new Page();
        List<UserDO> users;
        int total = userDAO.count(queryParam);
        page.setTotal(total);
        if (total > 0) {
            users = userDAO.find(queryParam);
            page.setRows(users);
        } else {
            page.setRows(new ArrayList<>());
        }
        return page;
    }

    /**
     * 生成用户密码加密串
     *
     * @param password 密码
     * @return 加密密码串
     */
    @Override
    public String encryptPassword(String password) {
        return encoder.encode(password);
    }

    /**
     * 新增用户
     *
     * @param userDO
     * @return true 成功 false 失败
     */
    @Override
    public boolean save(UserDO userDO) {
        int count = userDAO.save(userDO);
        if (count < 1) {
            return false;
        }
        Long userId = userDO.getId();
        userRoleService.deleteByUserId(userId);
        List<Long> roleIds = userDO.getRoles();
        List<UserRoleDO> userRoles = new ArrayList<>();
        for (Long roleId : roleIds) {
            UserRoleDO ur = new UserRoleDO();
            ur.setUserId(userId);
            ur.setRoleId(roleId);
            userRoles.add(ur);
        }
        if (!userRoles.isEmpty()) {
            userRoleService.batchSave(userRoles);
        }
        return true;
    }

    /**
     * 更新用户
     *
     * @param userDO
     * @return true 成功 false 失败
     */
    @Override
    public boolean update(UserDO userDO) {
        int count = userDAO.update(userDO);
        if (count < 1) {
            return false;
        }
        Long userId = userDO.getId();
        userRoleService.deleteByUserId(userId);
        List<Long> roleIds = userDO.getRoles();
        List<UserRoleDO> userRoles = new ArrayList<>();
        for (Long roleId : roleIds) {
            UserRoleDO ur = new UserRoleDO();
            ur.setUserId(userId);
            ur.setRoleId(roleId);
            userRoles.add(ur);
        }
        if (!userRoles.isEmpty()) {
            userRoleService.batchSave(userRoles);
        }
        return true;
    }

    /**
     * 删除用户
     *
     * @param id 用户ID
     * @return true 成功 false 失败
     */
    @Override
    public boolean delete(Long id) {
        userDAO.delete(id);
        userRoleService.deleteByUserId(id);
        return true;
    }
}
