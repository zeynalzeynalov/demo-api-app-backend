package com.taxdoo.taxdooapi.transaction;

import com.taxdoo.taxdooapi.address.Address;
import com.taxdoo.taxdooapi.datagenerator.DataGenerator;
import com.taxdoo.taxdooapi.reference.Reference;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Component;

/**
 * Handles the transaction operations.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    private final MapperFacade mapperFacade;

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
