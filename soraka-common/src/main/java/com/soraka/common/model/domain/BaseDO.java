package com.soraka.common.model.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础领域模型
 *
 * @author yongjie.teng
 * @date 2018/8/16
 * @package com.soraka.common.model.domain
 */
@Data
public abstract class BaseDO implements Serializable {

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
    @ApiModelProperty(value = "字符串日期", example = "2018-05-09 12:00:00")
    private Date createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "字符串日期", example = "2018-05-09 12:00:00")
    private Date modifyTime;
}
