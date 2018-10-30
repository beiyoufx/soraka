package com.soraka.auth.config.token;

import com.soraka.common.constant.Constants;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.Map;

/**
 * JSON Web Token配置
 *
 * @author yongjie.teng
 * @date 2018/10/26
 * @package com.soraka.auth.config
 */
public class SorakaJwtAccessTokenConverter extends JwtAccessTokenConverter {
    @Override
    public Map<String, ?> convertAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication) {
        Map<String, Object> representation = (Map<String, Object>) super.convertAccessToken(token, authentication);
        representation.put("license", Constants.SORAKA_LICENSE);
        return representation;
    }
}
