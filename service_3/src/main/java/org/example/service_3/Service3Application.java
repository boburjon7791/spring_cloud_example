package org.example.service_3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Service3Application {

    public static void main(String[] args) {
        SpringApplication.run(Service3Application.class, args);
    }

}
