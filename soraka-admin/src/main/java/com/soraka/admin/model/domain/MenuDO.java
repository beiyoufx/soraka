package com.soraka.admin.model.domain;

import lombok.Data;

/**
 * 菜单
 *
 * @author yongjie.teng
 * @date 2018/8/16
 * @package com.soraka.admin.model.domain
 */
@Data
public class MenuDO extends BaseDO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 类型：1菜单2按钮
     */
    private Integer type;

    /**
     * 资源地址
     */
    private String url;

    /**
     * 权限字符串
     */
    private String permission;

    /**
     * 菜单图标
     */
    private String ico;

    /**
     * 菜单等级
     */
    private Integer level;

    /**
     * 父节点ID
     */
    private Long parentId;

    /**
     * 排序
     */
    private Integer sequence;

    /**
     * 状态：0不可用1可用
     */
    private Integer status;
}
