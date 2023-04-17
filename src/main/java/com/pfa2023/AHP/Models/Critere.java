package com.pfa2023.AHP.Models;
public class Critere {

    private String id;

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    private Projet projet;
    private int numSoucritere;
    private int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    private Double poids;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumSoucritere() {
        return numSoucritere;
    }

    public void setNumSoucritere(int numSoucritere) {
        this.numSoucritere = numSoucritere;
    }

    public Double getPoids() {
        return poids;
    }

    public void setPoids(Double poids) {
        this.poids = poids;
    }
}
