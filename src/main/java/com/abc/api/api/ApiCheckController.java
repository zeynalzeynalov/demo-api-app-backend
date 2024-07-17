package com.abc.api.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class ApiCheckController {
    
    @GetMapping
    public ResponseEntity checkApi() {

        return ResponseEntity.ok("ApiApplication API is active.");
    }
}
