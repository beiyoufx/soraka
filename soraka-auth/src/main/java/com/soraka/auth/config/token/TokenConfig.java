package com.soraka.auth.config.token;

import com.soraka.common.constant.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.HashMap;
import java.util.Map;

/**
 * 凭证配置
 *
 * @author yongjie.teng
 * @date 2018/10/26
 * @package com.soraka.auth.config.token
 */
@Configuration
public class TokenConfig {
    /**
     * 生成token 定制化处理
     *
     * @return TokenEnhancer
     */
    @Bean
    public TokenEnhancer tokenEnhancer() {
        return (accessToken, authentication) -> {
            final Map<String, Object> additionalInfo = new HashMap<>(1);
            additionalInfo.put("license", Constants.SORAKA_LICENSE);
            ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
            return accessToken;
        };
    }

    /**
     * JWT
     *
     * @return JwtAccessTokenConverter
     */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        SorakaJwtAccessTokenConverter jwtAccessTokenConverter = new SorakaJwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey(Constants.JWT_SIGN_KEY);
        return jwtAccessTokenConverter;
    }
}
