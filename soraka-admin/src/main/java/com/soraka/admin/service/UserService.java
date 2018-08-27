package com.soraka.admin.service;

import com.soraka.admin.model.domain.UserDO;
import com.soraka.admin.model.dto.Page;
import com.soraka.admin.model.dto.QueryParam;
import com.soraka.admin.model.dto.R;
import org.springframework.stereotype.Service;

/**
 * 系统用户
 *
 * @author yongjie.teng
 * @date 2018/8/16
 * @package com.soraka.admin.service
 */
@Service
public interface UserService {
    /**
     * 根据主键获取用户信息
     *
     * @param id 主键
     * @return {@link UserDO}
     */
    UserDO get(Long id);

    /**
     * 根据用户名获取用户
     *
     * @param username 用户名
     * @return {@link UserDO}
     */
    UserDO getByUsername(String username);

    /**
     * 根据手机号获取用户
     *
     * @param mobilephone 手机号
     * @return {@link UserDO}
     */
    UserDO getByMobilephone(String mobilephone);

    /**
     * 根据邮箱获取用户
     *
     * @param email 邮箱
     * @return {@link UserDO}
     */
    UserDO getByEmail(String email);

    /**
     * 查询用户列表页
     *
     * @param queryParam 查询参数
     * @return {@link Page}
     */
    Page findPage(QueryParam queryParam);

    /**
     * 登录
     *
     * @param username 用户名/手机/邮箱
     * @param password 密码
     * @return
     */
    R login(String username, String password);
}
