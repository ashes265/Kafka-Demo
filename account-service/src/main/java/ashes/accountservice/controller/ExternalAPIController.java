package ashes.accountservice.controller;

import ashes.accountservice.processor.ExternalAPIProcessor;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@RequestMapping("/crawl")
public class ExternalAPIController {

    final ExternalAPIProcessor externalApiProcessor;

    @GetMapping("/rest-template")
    public ResponseEntity<?> crawlByRestTemplate() {
        return ResponseEntity.ok(externalApiProcessor.getByRestTemplate());
    }

    @PostMapping("/rest-template")
    public ResponseEntity<?> addByRT() {
        externalApiProcessor.addUserByRT();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/feign")
    public ResponseEntity<?> crawlByFeign() {
        return ResponseEntity.ok(externalApiProcessor.getByFeign());
    }

    @PostMapping("/feign")
    public ResponseEntity<?> addByFeign() {
        return ResponseEntity.ok(externalApiProcessor.addByFeign());
    }

    @GetMapping("/web-client")
    public ResponseEntity<?> crawlByWebClient() {
        return null;
    }
}
