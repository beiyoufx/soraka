package com.soraka.admin.dao;

import com.soraka.admin.model.domain.UserDO;
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
}
