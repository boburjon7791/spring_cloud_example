package org.example.service_1;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class Service1Application {

    public static void main(String[] args) {
        SpringApplication.run(Service1Application.class, args);
    }

    @GetMapping("/hello")
    public Map<String, Object> hello(HttpServletRequest request) throws Exception{
//        TimeUnit.SECONDS.sleep(15);
        return Map.of(
                "response", "Hello from service 1",
                "ipAddress", request.getRemoteAddr(),
                "User-Agent", request.getHeader("User-Agent")
        );
    }
}
