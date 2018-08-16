package com.soraka.admin.domain;

import lombok.Data;

/**
 * 部门
 *
 * @author yongjie.teng
 * @date 2018/8/16
 * @package com.soraka.admin.domain
 */
@Data
public class DeptDO extends BaseDO {
    /**
     * 主键
     */
    private String id;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 父部门ID
     */
    private String parentId;

    /**
     * 状态：0不可用1可用
     */
    private String status;

    /**
     * 排序
     */
    private String sequence;

    /**
     * 是否已删除
     */
    private String deleted;
}
