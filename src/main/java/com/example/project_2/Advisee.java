package com.example.project_2;

import java.util.ArrayList;
import java.util.Date;

public class Advisee extends People{
    private String major;
    private double tuitionSem;
    private Date admittedDate;
    private ArrayList<Course> subjects;

    public Advisee() {
        major = "";
        tuitionSem = 0.0;
        admittedDate = null;
        subjects = new ArrayList<>();
    }

    public Advisee(String name, String ID) {
        super(name, ID);
        subjects = new ArrayList<>();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getTuition() {
        return this.tuitionSem;
    }

    public void setTuition(double Tuition_Sem) {
        this.tuitionSem = Tuition_Sem;
    }

    public Date getAdmittedDate() {
        return this.admittedDate;
    }

    public void setAdmittedDate(Date admittedDate) {
        this.admittedDate = admittedDate;
    }

    public ArrayList<Course> getCourses() {
        return this.subjects;
    }

    public void setCourses(ArrayList<Course> subjects) {
        this.subjects = subjects;
    }

    @Override
    public void Payment() {
        //calculate tuition from price of list of courses - price per credit
        tuitionSem = 0.0;
        for (Course c : subjects) {
            tuitionSem += c.getNumOfCredits() * c.getPrice();
        }
    }

    @Override
    public void Display() {
        System.out.printf("%s\n" + "%s\n" + "%s\n" + "%s\n" + "Major: %s\n", getName(), getID(), getEmail(), getAddress(), major);
    }

    @Override
    public String toString() {
        return getID() + ": " + getName();
    }
}
