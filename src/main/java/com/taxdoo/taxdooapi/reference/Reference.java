package com.taxdoo.taxdooapi.reference;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.taxdoo.taxdooapi.transaction.Transaction;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "reference")
public class Reference {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    private Integer id;

    public String identifier;

    public Long transactionNumber;

    public Long itemNumber;

    @OneToMany(mappedBy="channel")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    private Collection<Transaction> channels;

    @OneToMany(mappedBy="source")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    private Collection<Transaction> sources;
}
