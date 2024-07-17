package com.abc.api.datagenerator;

import com.github.javafaker.Faker;
import com.abc.api.address.Address;
import com.abc.api.reference.Reference;
import com.abc.api.transaction.Transaction;

public class DataGenerator {

    public static Transaction getTransaction() {

        Faker faker = new Faker();
        Transaction transaction = new Transaction();

        transaction.setChannel(getReference());
        transaction.setSource(getReference());

        transaction.setPaymentDate(faker.date().birthday());
        transaction.setSentDate(faker.date().birthday());

        transaction.setDeliveryAddress(getAddress());
        transaction.setBillingAddress(getAddress());
        transaction.setSenderAddress(getAddress());

        transaction.setProductIdentifier(faker.lorem().characters(10).toLowerCase());
        transaction.setDescription(faker.commerce().productName());
        transaction.setTransactionCurrency(faker.currency().code().toUpperCase());
        transaction.setItemPrice(Double.parseDouble(faker.commerce().price()));

        return transaction;
    }

    public static Address getAddress() {

        Faker faker = new Faker();
        Address address = new Address();

        address.setFullName(faker.name().fullName());
        address.setStreet(faker.address().streetAddress());
        address.setZip(faker.address().zipCode());
        address.setCity(faker.address().cityName());
        address.setState(faker.address().state());
        address.setCountry(faker.address().countryCode().toUpperCase());

        return address;
    }

    public static Reference getReference() {

        Faker faker = new Faker();
        Reference reference = new Reference();

        reference.setIdentifier(faker.lorem().characters(3, 4).toUpperCase());
        reference.setTransactionNumber((long)faker.number().numberBetween(10000000, 99999999));
        reference.setItemNumber((long)faker.number().numberBetween(1000000, 9999999));

        return reference;
    }
}
