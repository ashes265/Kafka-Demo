package ashes.accountservice.processor;

import ashes.accountservice.feign.ApiClient;
import ashes.accountservice.feign.InternalAPI;
import ashes.registercore.core.AccountDTO;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Slf4j
public class ExternalAPIProcessor {

    final RestTemplate restTemplate;
    final ApiClient apiClient;
    final InternalAPI internalAPI;

    public Object getByRestTemplate() {
        String apiUrl = "https://api.apis.guru/v2/list.json";

        // Gửi GET request và nhận response dưới dạng ResponseEntity
        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, String.class);
        // Lấy status code từ response
        int statusCode = response.getStatusCode().value();
        // Lấy body từ response
        return response.getBody();
    }

    public void addUserByRT() {
        try {
            AccountDTO dto = AccountDTO.builder().name("Hai").email("cammpus265@gmail.com").build();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<AccountDTO> request = new HttpEntity<>(dto, headers);
            restTemplate.exchange("http://localhost:8080/account/add", HttpMethod.POST, request, String.class);
            log.info("Add Successfully");
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }

    public JsonNode getByFeign() {
        return apiClient.getData();
    }

    public JsonNode addByFeign() {
        return internalAPI.addUser(AccountDTO.builder().name("A").email("campus265@gmail.com").build());
    }
}
