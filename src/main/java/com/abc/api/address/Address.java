package com.abc.api.address;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.abc.api.transaction.Transaction;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    private Integer id;

    public String fullName;

    public String street;

    public String zip;

    public String city;

    public String state;

    public String country;


    @OneToMany(mappedBy="deliveryAddress")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    private Collection<Transaction> deliveryAddresses;

    @OneToMany(mappedBy="billingAddress")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    private Collection<Transaction> billingAddresses;

    @OneToMany(mappedBy="senderAddress")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    private Collection<Transaction> senderAddresses;
}
