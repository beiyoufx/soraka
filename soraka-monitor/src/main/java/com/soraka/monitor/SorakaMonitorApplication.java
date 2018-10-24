package com.soraka.monitor;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@Configurable
@EnableDiscoveryClient
@EnableAdminServer
@SpringBootApplication
public class SorakaMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SorakaMonitorApplication.class, args);
    }
}
