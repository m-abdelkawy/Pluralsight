package com.pluralsight.hibernatefundamentals;

import com.pluralsight.hibernatefundamentals.airport.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m03.ex04");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Ticket ticket1 = new Ticket();
        ticket1.setSeries("AA");
        ticket1.setNumber("1234");
        ticket1.setOrigin("Cairo");
        ticket1.setDestination("ORD");

        em.persist(ticket1);

        tx.commit();
        em.close();
        emf.close();
    }
}
