package com.soraka.gateway.service.impl;

import com.soraka.gateway.service.PermissionService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yongjie.teng
 * @date 2018/10/25
 * @package com.soraka.gateway.service.impl
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {
    /**
     * 判断请求是否有权限
     *
     * @param request        HttpServletRequest
     * @param authentication 认证信息
     * @return 是否有权限
     */
    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        return true;
    }
}
