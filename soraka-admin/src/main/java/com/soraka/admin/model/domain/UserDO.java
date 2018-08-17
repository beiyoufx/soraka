package com.soraka.admin.model.domain;

import lombok.Data;

import java.util.List;

/**
 * 系统用户
 *
 * @author yongjie.teng
 * @date 2018/8/15
 * @package com.soraka.admin.model.domain
 */
@Data
public class UserDO extends BaseDO {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String mobilephone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐值
     */
    private String salt;

    /**
     * 性别：0未知1女2男
     */
    private Integer gender;

    /**
     * 状态：0不可用1可用
     */
    private Integer status;

    /**
     * 部门ID
     */
    private Long deptId;

    /**
     * 是否已删除
     */
    private Boolean deleted;

    /**
     * 角色集合
     */
    private List<RoleDO> roles;
}
