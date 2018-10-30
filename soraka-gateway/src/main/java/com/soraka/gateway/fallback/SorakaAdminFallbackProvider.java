package com.soraka.gateway.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/**
 * 模块降级回调
 *
 * @author yongjie.teng
 * @date 2018/10/29
 * @package com.soraka.gateway.fallback
 */
@Component
public class SorakaAdminFallbackProvider implements FallbackProvider {
    private static final String SERVICE_NAME = "soraka-admin";
    private static final String SERVICE_DISABLE = "服务不可用";
    
    @Override
    public ClientHttpResponse fallbackResponse(Throwable cause) {
        return new SorakaFallbackResponse(cause, SERVICE_NAME, SERVICE_DISABLE);
    }

    @Override
    public String getRoute() {
        return SERVICE_NAME;
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return fallbackResponse(null);
    }
}
