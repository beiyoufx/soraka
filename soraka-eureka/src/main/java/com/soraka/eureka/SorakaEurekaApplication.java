package com.soraka.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Soraka注册中心
 *
 * @author yongjie.teng
 * @date 2018/8/9
 * @package com.soraka.eureka
 */
@EnableEurekaServer
@SpringBootApplication
public class SorakaEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SorakaEurekaApplication.class, args);
    }
}
