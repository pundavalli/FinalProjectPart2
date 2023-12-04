package com.example.finalprojectparttwo;

import java.util.ArrayList;
import java.util.Date;

public class Advisor extends People {
    private String title = " ";
    private double annualSalary;//We know that this has an updated value,initialize with 0.
    private Date hiredDate; //Date object for hired Date of Advisor
    private ArrayList<Advisee> advisees; //Need at least 3 students for Advisor.

    public Advisor() {
        title = "";
        annualSalary = 0.0;
        hiredDate = null;
        advisees = new ArrayList<>();
    }

    public Advisor(String name, String ID) {
        super(name, ID);
        advisees = new ArrayList<>();
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String Title) {
        this.title = Title;
    }

    public double getAnnualSalary() {
        return this.annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    public Date getHiredDate() {
        return this.hiredDate;
    }

    public void setHiredDate(Date HiredDate) {
        this.hiredDate = HiredDate;
    }

    public ArrayList<Advisee> getAdvisees() {
        return this.advisees;
    }

    public void setAdvisees(ArrayList<Advisee> advisees) {
        this.advisees = advisees;
    }

    @Override
    public void Payment() {
        //calculate annual salary
        annualSalary = 30000;
    }

    @Override
    public void Display() {
        System.out.printf("%s %s\n" + "ID: %s\n" + "%s\n" + "%s\n", title, getName(), getID(), getEmail(), getAddress());
        System.out.println("Advisees for " + getName() + ":");
        if (advisees.isEmpty()) {
            System.out.println("none");
        } else {
            for (Advisee a : advisees) {
                System.out.println(a.getName());
            }
        }
    }
}