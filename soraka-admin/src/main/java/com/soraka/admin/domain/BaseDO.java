package com.soraka.admin.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础领域模型
 *
 * @author yongjie.teng
 * @date 2018/8/16
 * @package com.soraka.admin.domain
 */
public class BaseDO implements Serializable {

    /**
     * 创建人ID
     */
    private Long createUser;

    /**
     * 修改人ID
     */
    private Long modifyUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Long getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(Long modifyUser) {
        this.modifyUser = modifyUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
