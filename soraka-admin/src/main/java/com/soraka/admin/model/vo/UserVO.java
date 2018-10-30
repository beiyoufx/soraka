package com.soraka.admin.model.vo;

import com.soraka.common.model.domain.UserDO;
import lombok.Data;

/**
 * @author yongjie.teng
 * @date 2018/8/30
 * @package com.soraka.admin.model.vo
 */
@Data
public class UserVO extends UserDO {
    /**
     * 用户密码
     */
    private String newPassword;
}
