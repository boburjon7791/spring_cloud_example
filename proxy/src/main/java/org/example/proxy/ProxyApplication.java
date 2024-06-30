package org.example.proxy;

import jakarta.servlet.http.HttpServletRequest;
import org.example.proxy.feign_clients.HelloClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

@EnableFeignClients
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class ProxyApplication {
    private final HelloClient helloClient;

    public ProxyApplication(HelloClient helloClient) {
        this.helloClient = helloClient;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProxyApplication.class, args);
    }

    @GetMapping("/hello")
    public Map<String, Object> hello(HttpServletRequest request){
        return Map.of(
                "response",helloClient.hello(),
                "ipAddress", request.getRemoteAddr(),
                "User-Agent", request.getHeader("User-Agent")
        );
    }
}
