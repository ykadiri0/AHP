package com.pfa2023.AHP.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

public class SousCritere {

    private String id;

    private Critere critere;
    private String name;
    private Double poids;
    private int index;

    public void setPoids(Double poids) {
        this.poids = poids;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Critere getCritere() {
        return critere;
    }

    public void setCritere(Critere critere) {
        this.critere = critere;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPoids() {
        return poids;
    }

    public void setPoinds(Double poids) {
        this.poids = poids;
    }
}
