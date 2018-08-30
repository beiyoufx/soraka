package com.soraka.admin.model.domain;

import lombok.Data;

/**
 * 部门
 *
 * @author yongjie.teng
 * @date 2018/8/16
 * @package com.soraka.admin.model.domain
 */
@Data
public class DeptDO extends BaseDO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 父部门ID
     */
    private Long parentId;

    /**
     * 状态：0不可用1可用
     */
    private Integer status;

    /**
     * 排序
     */
    private Integer sequence;

    /**
     * 是否已删除
     */
    private Boolean deleted;
}
