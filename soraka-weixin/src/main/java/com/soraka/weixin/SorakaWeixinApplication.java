package com.soraka.weixin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Soraka微信服务
 *
 * @author yongjie.teng
 * @date 2018/8/10
 * @package com.soraka.weixin
 */
@EnableEurekaClient
@SpringBootApplication
public class SorakaWeixinApplication {

    public static void main(String[] args) {
        SpringApplication.run(SorakaWeixinApplication.class, args);
    }
}
