package com.taxdoo.taxdooapi.transaction;

import lombok.Data;

@Data
public class TransactionCreateRequest {

    public String type;

    public int quantity;
}
