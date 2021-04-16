package com.taxdoo.taxdooapi.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransactionsResponse {

    String status;

    Iterable<Transaction> transactions;
}
