package com.soraka.admin.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 树节点
 *
 * @author yongjie.teng
 * @date 2018/9/27
 * @package com.soraka.admin.model.dto
 */
@Data
public class TreeNode implements Serializable {
    private long id;
    private long parentId;
    /**
     * 子节点
     */
    private List<TreeNode> children = new ArrayList<>();

    public void addChild(TreeNode node) {
        children.add(node);
    }
}
