package com.soraka.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Soraka网关
 *
 * @author yongjie.teng
 * @date 2018/8/10
 * @package com.soraka.gateway
 */
@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class SorakaGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SorakaGatewayApplication.class, args);
    }
}
