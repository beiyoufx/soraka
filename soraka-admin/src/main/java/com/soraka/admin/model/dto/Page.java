package com.soraka.admin.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页模型
 *
 * @author yongjie.teng
 * @date 2018/8/17
 * @package com.soraka.admin.model.dto
 */
@Data
public class Page implements Serializable {
    /**
     * 总条数
     */
    private int total;

    /**
     * 集合
     */
    private List<?> rows;
}
