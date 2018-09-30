package com.soraka.admin.model.dto;

import com.soraka.admin.model.domain.MenuDO;
import lombok.Data;

/**
 * vue router
 *
 * @author yongjie.teng
 * @date 2018/9/25
 * @package com.soraka.admin.model.vo
 */
@Data
public class VueRouter extends TreeNode {
    /**
     * 路由名称
     */
    private String name;

    /**
     * 路径
     */
    private String path;

    /**
     * 组件
     */
    private String component;

    /**
     * 重定向地址，在面包屑中点击会重定向去的地址
     * 当设置 noredirect 的时候该路由在面包屑导航中不可被点击
     */
    private String redirect;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 元信息
     */
    private Meta meta;

    public VueRouter() {
    }

    public VueRouter(MenuDO menuDO) {
        setId(menuDO.getId());
        setParentId(menuDO.getParentId());
        this.name = menuDO.getName();
        this.component = menuDO.getComponent();
        this.path = menuDO.getUrl();
        this.redirect = menuDO.getRedirect();
        this.sort = menuDO.getSequence();

        Meta meta = new Meta();
        meta.icon = menuDO.getIco();
        meta.title = menuDO.getName();
        this.meta = meta;
    }

    @Data
    class Meta {
        /**
         * 图标
         */
        private String icon;

        /**
         * 路由标题（菜单显示名称）
         */
        private String title;

        /**
         * 不会被 <keep-alive> 缓存
         */
        private boolean noCache;
    }
}
