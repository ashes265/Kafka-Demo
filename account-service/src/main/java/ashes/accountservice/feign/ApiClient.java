package ashes.accountservice.feign;

import com.fasterxml.jackson.databind.JsonNode;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "https://api.apis.guru/v2", name = "ApiClient")
public interface ApiClient {
    @GetMapping("/list.json")
    JsonNode getData();
}
