package com.soraka.admin.model.domain;

import lombok.Data;

/**
 * 角色
 *
 * @author yongjie.teng
 * @date 2018/8/16
 * @package com.soraka.admin.model.domain
 */
@Data
public class RoleDO extends BaseDO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 角色key
     */
    private String key;

    /**
     * 描述
     */
    private String description;

    /**
     * 状态：0不可用1可用
     */
    private Integer status;
}
