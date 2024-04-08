package ashes.accountservice.controller;

import ashes.accountservice.service.AccountService;
import ashes.registercore.core.AccountDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService service;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody AccountDTO dto) {
        service.add(dto);
        return ResponseEntity.ok().build();
    }
}
