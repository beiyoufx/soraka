package com.soraka.admin.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础领域模型
 *
 * @author yongjie.teng
 * @date 2018/8/16
 * @package com.soraka.admin.domain
 */
@Data
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
}
