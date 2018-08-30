package com.soraka.admin.dao;

import com.soraka.admin.model.domain.UserRoleDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户角色
 *
 * @author yongjie.teng
 * @date 2018/8/30
 * @package com.soraka.admin.dao
 */
public interface UserRoleDAO {

    /**
     * 获取用户角色ID集合
     *
     * @param userId 用户主键
     * @return List<Long>
     */
    List<Long> findRoleIdsByUserId(Long userId);

    /**
     * 删除用户角色关系
     *
     * @param userId 用户主键
     * @return 受影响行数
     */
    Integer deleteByUserId(Long userId);

    /**
     * 批量保存用户角色关系
     *
     * @param userRoles 用户角色
     * @return 受影响行数
     */
    Integer batchSave(@Param("userRoles") List<UserRoleDO> userRoles);
}
