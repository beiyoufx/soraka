package com.soraka.admin.service;

import com.soraka.admin.domain.RoleDO;
import org.springframework.stereotype.Service;

/**
 * 角色
 *
 * @author yongjie.teng
 * @date 2018/8/16
 * @package com.soraka.admin.service
 */
@Service
public interface RoleService {
    /**
     * 根据主键获取角色
     *
     * @param id 主键
     * @return {@link RoleDO}
     */
    RoleDO get(Long id);
}
