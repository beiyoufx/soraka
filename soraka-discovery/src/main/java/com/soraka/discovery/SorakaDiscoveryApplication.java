package com.soraka.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Soraka注册中心
 *
 * @author yongjie.teng
 * @date 2018/8/9
 * @package com.soraka.discovery
 */
@EnableEurekaServer
@SpringBootApplication
public class SorakaDiscoveryApplication {
    public static void main(String[] args) {
        SpringApplication.run(SorakaDiscoveryApplication.class, args);
    }
}
