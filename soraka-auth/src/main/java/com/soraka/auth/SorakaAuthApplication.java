package com.soraka.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * soraka安全模块
 *
 * @author yongjie.teng
 * @date 2018/10/17
 * @package com.soraka.auth
 */
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class SorakaAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SorakaAuthApplication.class, args);
    }
}
