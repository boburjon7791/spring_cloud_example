package org.example.proxy.feign_clients;

import org.example.proxy.utils.Utils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = Utils.SERVICE)
public interface HelloClient {
    @GetMapping("/hello")
    String hello();
}
