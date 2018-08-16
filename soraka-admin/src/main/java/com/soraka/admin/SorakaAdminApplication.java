package com.soraka.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Soraka管理平台
 *
 * @author yongjie.teng
 * @date 2018/8/9
 * @package com.soraka.admin
 */
@MapperScan("com.soraka.admin.dao")
@EnableEurekaClient
@SpringBootApplication
public class SorakaAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(SorakaAdminApplication.class, args);
    }
}
