package com.soraka.common.exception;

/**
 * 业务异常编码
 *
 * @author yongjie.teng
 * @date 2018/8/27
 * @package com.soraka.admin.exception
 */
public enum BuzCode {
    /**
     * 0 成功
     */
    SUCCEED(0, "操作成功"),

    /**
     * 9999 失败
     */
    FAILED(9999, "操作失败"),

    /**
     * 1*** 用户相关业务异常
     */
    USER_NOT_FOUND(1001, "用户不存在"),
    USER_PWD_ERROR(1002, "密码不正确"),
    USER_IS_BLOCKED(1003, "用户被锁定");

    /**
     * 业务异常编码
     */
    private int code;

    /**
     * 异常信息
     */
    private String message;

    BuzCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
