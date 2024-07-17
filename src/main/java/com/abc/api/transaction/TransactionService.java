package com.abc.api.transaction;

import com.abc.api.datagenerator.DataGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Handles the transaction operations.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public Transaction createTransaction(TransactionCreateRequest request) {

        log.trace("createTransaction(request={})", request);
        Transaction transaction = DataGenerator.getTransaction();
        transaction.setType(request.type);
        transaction.setQuantity(request.quantity);

        return transactionRepository.save(transaction);
    }

    public Iterable<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
}
