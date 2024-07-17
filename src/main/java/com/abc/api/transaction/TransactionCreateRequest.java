package com.abc.api.transaction;

import lombok.Data;

@Data
public class TransactionCreateRequest {

    public String type;

    public int quantity;
}
