package com.soraka.admin.model.vo;

import com.soraka.common.model.domain.DeptDO;
import com.soraka.admin.model.dto.TreeNode;
import lombok.Data;

import java.util.Date;

/**
 * 部门树
 *
 * @author yongjie.teng
 * @date 2018/10/16
 * @package com.soraka.admin.model.vo
 */
@Data
public class DeptTreeVO extends TreeNode {
    /**
     * 部门名称
     */
    private String name;

    /**
     * 部门编码
     */
    private String code;

    /**
     * 状态：0不可用1可用
     */
    private Integer status;

    /**
     * 排序
     */
    private Integer sequence;


    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    public DeptTreeVO(DeptDO deptDO) {
        setId(deptDO.getId());
        setParentId(deptDO.getParentId());
        this.code = deptDO.getCode();
        this.name = deptDO.getName();
        this.sequence = deptDO.getSequence();
        this.status = deptDO.getStatus();
        this.createTime = deptDO.getCreateTime();
        this.modifyTime = deptDO.getModifyTime();
    }
}
