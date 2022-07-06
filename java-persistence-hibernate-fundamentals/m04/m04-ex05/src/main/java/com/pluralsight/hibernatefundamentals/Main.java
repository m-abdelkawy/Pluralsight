package com.pluralsight.hibernatefundamentals;

import com.pluralsight.hibernatefundamentals.airport.Address;
import com.pluralsight.hibernatefundamentals.airport.Passenger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m04.ex05");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Passenger john = new Passenger("John Smith");
        Address address = new Address();

        address.setStreet("Flowers Street");
        address.setNumber("3");
        address.setCity("Boston");
        address.setZipCode("589878");

        john.setAddress(address);

        em.persist(john);

        tx.commit();
        em.close();
        emf.close();
    }
}
