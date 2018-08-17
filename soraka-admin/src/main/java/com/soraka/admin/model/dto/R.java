package com.soraka.admin.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 统一返回值
 *
 * @author yongjie.teng
 * @date 2018/8/17
 * @package com.soraka.admin.model.dto
 */
@Data
public class R implements Serializable {
    /**
     * 返回码
     */
    private String code = "0";

    /**
     * 返回信息
     */
    private String message = "success";

    /**
     * 返回数据
     */
    private Object data;

    public static R success() {
        return new R();
    }

    public static R fail() {
        return new R("400", "fail");
    }

    public R() {
    }

    public R(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public R(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
