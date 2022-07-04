package com.pluralsight.hibernatefundamentals;

import com.pluralsight.hibernatefundamentals.airport.Passenger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m03.ex02");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Passenger john = new Passenger(1, "John smith");
        john.setStreet("N 6th St.");
        john.setNumber("513");
        john.setCity("Iowa City");
        john.setZipCode("58778");

        Passenger mike = new Passenger(2, "Michael Harris");
        mike.setStreet("S 4th St.");
        mike.setNumber("406");
        mike.setCity("Des Moines");
        mike.setZipCode("57652");

        em.persist(john);
        em.persist(mike);

        tx.commit();
        em.close();
        emf.close();
    }
}
