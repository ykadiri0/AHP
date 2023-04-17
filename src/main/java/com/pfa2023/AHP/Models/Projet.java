package com.pfa2023.AHP.Models;

import org.springframework.context.annotation.ComponentScan;

import java.util.Date;

public class Projet {
    @Override
    public String toString() {
        return "Projet{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", numCritere='" + numCritere + '\'' +
                ", numAlternative='" + numAlternative + '\'' +
                ", date=" + date +
                '}';
    }

    private String id;
    private String name;
    private String numCritere;
    private String numAlternative;
    private Date date;

    public Projet(String name, String numCritere, String numAlternative, Date date) {
        this.name = name;
        this.numCritere = numCritere;
        this.numAlternative = numAlternative;
        this.date = date;
    }
    public Projet() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumCritere() {
        return numCritere;
    }

    public void setNumCritere(String numCritere) {
        this.numCritere = numCritere;
    }

    public String getNumAlternative() {
        return numAlternative;
    }

    public void setNumAlternative(String numAlternative) {
        this.numAlternative = numAlternative;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
