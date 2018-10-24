package com.soraka.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 权限地址配置
 *
 * @author yongjie.teng
 * @date 2018/10/18
 * @package com.soraka.auth.config
 */
@Configuration
@EnableWebSecurity
public class SorakaSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
    /**
     * 匹配 "/" 路径，不需要权限即可访问
     * 匹配 "/user" 及其以下所有路径，都需要 "USER" 权限
     * 登录地址为 "/login"，登录成功默认跳转到页面 "/user"
     * 退出登录的地址为 "/logout"，退出成功后跳转到页面 "/login"
     * 默认启用 CSRF
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http
            .requestMatchers()
            .anyRequest()
            .and()
            .authorizeRequests()
            .antMatchers("/oauth/**").permitAll();
    }
}
