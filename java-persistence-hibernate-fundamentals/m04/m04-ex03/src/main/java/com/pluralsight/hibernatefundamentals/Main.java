package com.pluralsight.hibernatefundamentals;

import com.pluralsight.hibernatefundamentals.airport.Department;
import com.pluralsight.hibernatefundamentals.airport.Manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m04.ex03");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Manager john = new Manager("John Smith");
        Department accounting = new Department("Accounting");

        john.setDepartment(accounting);

        em.persist(accounting);
        em.persist(john);

        tx.commit();
        em.close();
        emf.close();
    }
}
