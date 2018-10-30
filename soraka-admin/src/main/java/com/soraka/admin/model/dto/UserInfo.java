package com.soraka.admin.model.dto;

import com.soraka.common.model.domain.UserDO;
import lombok.Data;

import java.util.List;

/**
 * 系统用户信息
 *
 * @author yongjie.teng
 * @date 2018/8/16
 * @package com.soraka.admin.model.dto
 */
@Data
public class UserInfo extends BaseDTO {
    /**
     * 用户信息
     */
    private UserDO user;

    /**
     * 权限标识集合
     */
    private List<String> permissions;
}
