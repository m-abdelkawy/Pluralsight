package com.pluralsight.hibernatefundamentals;

import com.pluralsight.hibernatefundamentals.airport.Payment;
import com.pluralsight.hibernatefundamentals.airport.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m04.ex04");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Ticket ticket = new Ticket();
        ticket.setNumber("AA1234");
        ticket.setOrigin("Cairo");
        ticket.setDestination("ORD");

        Payment payment = new Payment();
        payment.setTicket(ticket);
        payment.setAmount(540);

        em.persist(ticket);
        em.persist(payment);

        tx.commit();
        em.close();
        emf.close();
    }
}
