package com.soraka.admin.service.impl;

import com.soraka.admin.constants.Constants;
import com.soraka.admin.dao.UserDAO;
import com.soraka.admin.exception.BuzCode;
import com.soraka.admin.model.domain.RoleDO;
import com.soraka.admin.model.domain.UserDO;
import com.soraka.admin.model.dto.Page;
import com.soraka.admin.model.dto.QueryParam;
import com.soraka.admin.model.dto.R;
import com.soraka.admin.model.dto.UserInfo;
import com.soraka.admin.service.MenuService;
import com.soraka.admin.service.RoleService;
import com.soraka.admin.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    UserDAO userDAO;
    @Autowired
    RoleService roleService;
    @Autowired
    MenuService menuService;

    /**
     * 根据主键获取用户信息
     *
     * @param id 主键
     * @return {@link UserDO}
     */
    @Override
    public UserDO get(Long id) {
        UserDO userDO = userDAO.get(id);
        if (userDO != null) {
            userDO.setRoles(roleService.findByUserId(userDO.getId()));
        }
        return userDO;
    }

    /**
     * 根据用户名获取用户
     *
     * @param username 用户名
     * @return {@link UserDO}
     */
    @Override
    public UserDO getByUsername(String username) {
        UserDO userDO = userDAO.getByUsername(username);
        if (userDO != null) {
            userDO.setRoles(roleService.findByUserId(userDO.getId()));
        }
        return userDO;
    }

    /**
     * 根据手机号获取用户
     *
     * @param mobilephone 手机号
     * @return {@link UserDO}
     */
    @Override
    public UserDO getByMobilephone(String mobilephone) {
        UserDO userDO = userDAO.getByMobilephone(mobilephone);
        if (userDO != null) {
            userDO.setRoles(roleService.findByUserId(userDO.getId()));
        }
        return userDO;
    }

    /**
     * 根据邮箱获取用户
     *
     * @param email 邮箱
     * @return {@link UserDO}
     */
    @Override
    public UserDO getByEmail(String email) {
        UserDO userDO = userDAO.getByEmail(email);
        if (userDO != null) {
            userDO.setRoles(roleService.findByUserId(userDO.getId()));
        }
        return userDO;
    }

    /**
     * 查询用户列表页
     *
     * @param queryParam 查询参数
     * @return {@link Page}
     */
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
     * 登录
     *
     * @param username 用户名/手机/邮箱
     * @param password 密码
     * @return
     */
    @Override
    public R login(String username, String password) {
        R r = R.success();
        UserDO user = getByUsername(username);
        if (user == null && username.matches(Constants.EMAIL_PATTERN)) {
            user = getByEmail(username);
        }
        if (user == null && username.matches(Constants.MOBILE_PHONE_PATTERN)) {
            user = getByMobilephone(username);
        }

        if (user == null || Boolean.TRUE.equals(user.getDeleted())) {
            r.setCode(BuzCode.USER_NOT_FOUND.getCode());
            r.setMessage(BuzCode.USER_NOT_FOUND.getMessage());
            return r;
        }

        if (!isMatched(user, password)) {
            r.setCode(BuzCode.USER_PWD_ERROR.getCode());
            r.setMessage(BuzCode.USER_PWD_ERROR.getMessage());
            return r;
        }

        if (Constants.USER_STATUS_BLOCKED == user.getStatus()) {
            r.setCode(BuzCode.USER_IS_BLOCKED.getCode());
            r.setMessage(BuzCode.USER_IS_BLOCKED.getMessage());
            return r;
        }
        UserInfo userInfo = new UserInfo();
        //Todo 实现凭证
        userInfo.setToken("demo-token");
        userInfo.setUser(user);
        userInfo.setPermissions(menuService.getUserPermission(user.getId()));
        r.setData(userInfo);
        return r;
    }

    /**
     * 生成随机盐值
     *
     * @return 盐值
     */
    private String randomSalt() {
        return RandomStringUtils.randomAlphanumeric(8);
    }

    private boolean isMatched(UserDO user, String password) {
        if (user.getPassword().equals(encryptPassword(user.getUsername(), password, user.getSalt()))) {
            return true;
        }
        return false;
    }

    private String encryptPassword(String username, String password, String salt) {
        return DigestUtils.md5Hex(username + password + salt);
    }
}
