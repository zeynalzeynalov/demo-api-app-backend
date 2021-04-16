package com.taxdoo.taxdooapi.transaction;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.taxdoo.taxdooapi.address.Address;
import com.taxdoo.taxdooapi.reference.Reference;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;

@Data
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    private Integer id;

    public String type;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "channel_id", referencedColumnName = "id")
    public Reference channel;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "source_id", referencedColumnName = "id")
    public Reference source;

    @CreatedDate
    public Date paymentDate;

    @CreatedDate
    public Date sentDate;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "deliveryAddress_id", referencedColumnName = "id")
    public Address deliveryAddress;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "billingAddress_id", referencedColumnName = "id")
    public Address billingAddress;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "senderAddress_id", referencedColumnName = "id")
    public Address senderAddress;

    public int quantity;

    public String productIdentifier;

    public String description;

    public String transactionCurrency;

    public Double itemPrice;
}

