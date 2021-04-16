package com.taxdoo.taxdooapi.transaction;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/api/transactions")
@RestController
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping
    public ResponseEntity getAll() {

        return ResponseEntity.ok(new TransactionsResponse("success", transactionService.getAllTransactions()));
    }

    @PostMapping("add")
    public ResponseEntity create(@RequestBody TransactionCreateRequest request) {

        transactionService.createTransaction(request);
        return ResponseEntity.ok().build();
    }
}
