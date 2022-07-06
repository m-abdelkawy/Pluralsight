package com.pluralsight.hibernatefundamentals;

import com.pluralsight.hibernatefundamentals.airport.Passenger;
import com.pluralsight.hibernatefundamentals.airport.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m04.ex02");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Passenger john = new Passenger("John Smith");
        Passenger mike = new Passenger("Michael Johnson");

        Ticket ticket1 = new Ticket("AA1234");
        Ticket ticket2 = new Ticket("BB4567");

        ticket1.addPassenger(john);
        ticket1.addPassenger(mike);
        ticket2.addPassenger(john);
        ticket2.addPassenger(mike);

        john.addTicket(ticket1);
        mike.addTicket(ticket1);
        john.addTicket(ticket2);
        mike.addTicket(ticket2);

        em.persist(john);
        em.persist(mike);
        em.persist(ticket1);
        em.persist(ticket2);

        tx.commit();
        em.close();
        emf.close();
    }
}
