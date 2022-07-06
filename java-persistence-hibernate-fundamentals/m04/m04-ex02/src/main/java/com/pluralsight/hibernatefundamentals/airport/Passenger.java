package com.pluralsight.hibernatefundamentals.airport;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "PASSENGERS")
public class Passenger {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @Column(name = "PASSENGER_NAME")
    private String name;

    @ManyToMany(mappedBy = "passengers")
    private List<Ticket> tickets = new ArrayList<>();

    public Passenger() {
    }

    public Passenger(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ticket> getTickets() {
        return Collections.unmodifiableList(tickets);
    }

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }
}
