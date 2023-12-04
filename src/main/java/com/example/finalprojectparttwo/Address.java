package com.example.finalprojectparttwo;

public class Address {
    private int house_number, zip_code;
    private String street, town, state;

    public Address() {
    }

    public Address(int house_number, String street, String town, String state, int zip_code) {
        this.house_number = house_number;
        this.street = street;
        this.town = town;
        this.state = state;
        this.zip_code = zip_code;
    }

    public int getHouse_number() {
        return house_number;
    }

    public void setHouse_number(int house_number) {
        this.house_number = house_number;
    }

    public int getZip_code() {
        return zip_code;
    }

    public void setZip_code(int zip_code) {
        this.zip_code = zip_code;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return String.format("%d %s\n" +
                        "%s, %s\n" +
                        "%d",
                house_number, street, town, state, zip_code);
    }
}
