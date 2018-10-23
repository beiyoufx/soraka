package com.soraka.admin.dao;

import com.soraka.common.model.domain.UserDO;
import com.soraka.admin.model.dto.QueryParam;

import java.util.List;

/**
 * 系统用户
 *
 * @author yongjie.teng
 * @date 2018/8/15
 * @package com.soraka.admin.dao
 */
public interface UserDAO {
    /**
     * 通过主键获取用户
     *
     * @param id 主键
     * @return {@link UserDO}
     */
    UserDO get(Long id);

    /**
     * 查询用户列表
     *
     * @param param 查询参数
     * @return List<UserDO>
     */
    List<UserDO> find(QueryParam param);

    /**
     * 查询用户列表条数
     *
     * @param param 查询参数
     * @return {@link Integer}
     */
    Integer count(QueryParam param);

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
     * 新增用户
     *
     * @param userDO 用户信息
     * @return {@link Integer}
     */
    Integer save(UserDO userDO);

    /**
     * 更新用户
     *
     * @param userDO 用户信息
     * @return {@link Integer}
     */
    Integer update(UserDO userDO);

    /**
     * 删除用户
     *
     * @param id 用户ID
     * @return {@link Integer}
     */
    Integer delete(Long id);
}
