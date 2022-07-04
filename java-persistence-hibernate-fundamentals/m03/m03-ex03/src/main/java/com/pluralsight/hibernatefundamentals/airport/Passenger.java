package com.pluralsight.hibernatefundamentals.airport;

import javax.persistence.*;

@Entity
@Table(name = "PASSENGERS")
@SecondaryTables(
        {
                @SecondaryTable(name = "ADDRESSES",
                        pkJoinColumns = @PrimaryKeyJoinColumn(name = "PASSENGER_ID", referencedColumnName = "ID")),
                @SecondaryTable(name = "PHONES",
                        pkJoinColumns = @PrimaryKeyJoinColumn(name = "PASSENGER_ID", referencedColumnName = "ID"))
        }
)
public class Passenger {
    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "PASSENGER_NAME", table = "PASSENGERS")
    private String name;

    @Column(name = "STREET", table = "ADDRESSES", columnDefinition = "VARCHAR(25) NOT NULL")
    private String street;

    @Column(name = "NUMBER", table = "ADDRESSES", columnDefinition = "VARCHAR(10) NOT NULL")
    private String number;

    @Column(name = "ZIP_CODE", table = "ADDRESSES", columnDefinition = "VARCHAR(10) NOT NULL")
    private String zipCode;

    @Column(name = "CITY", table = "ADDRESSES", columnDefinition = "VARCHAR(25) NOT NULL")
    private String city;

    @Column(name = "AREA_CODE", table = "PHONES", columnDefinition = "VARCHAR(5) NOT NULL")
    private String areaCode;

    @Column(name = "PREFIX", table = "PHONES", columnDefinition = "VARCHAR(5) NOT NULL")
    private String prefix;

    @Column(name = "LINE_NUMBER", table = "PHONES", columnDefinition = "VARCHAR(10) NOT NULL")
    private String lineNumber;

    public Passenger() {
    }

    public Passenger(int id, String name) {
        this.id = id;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String phoneNumber) {
        this.lineNumber = phoneNumber;
    }
}
