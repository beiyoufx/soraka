package com.soraka.common.model.domain;

import lombok.Data;

/**
 * 菜单
 *
 * @author yongjie.teng
 * @date 2018/8/16
 * @package com.soraka.common.model.domain
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
     * 重定向地址，在面包屑中点击会重定向去的地址
     * 当设置 noredirect 的时候该路由在面包屑导航中不可被点击
     */
    private String redirect;

    /**
     * 组件
     */
    private String component;

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
