package ashes.accountservice.feign;

import ashes.registercore.core.AccountDTO;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "http://localhost:8080/", name = "InternalAPI")
public interface InternalAPI {
    @PostMapping("/account/add")
    JsonNode addUser(@RequestBody AccountDTO dto);
}
