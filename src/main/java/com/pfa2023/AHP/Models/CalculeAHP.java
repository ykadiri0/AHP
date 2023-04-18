package com.pfa2023.AHP.Models;


import com.pfa2023.AHP.Fuzzy.FuzzyNumber;
import com.pfa2023.AHP.Models.Projet;

public class CalculeAHP {
    private String id;

    private FuzzyNumber[]  fn;
    private Projet projet;

    private String type;

    private int nbrl;
    private int nbrc;

    public CalculeAHP(FuzzyNumber[] fn, Projet projet, String type, int nbrl, int nbrc) {
        this.fn = fn;
        this.projet = projet;
        this.type = type;
        this.nbrl = nbrl;
        this.nbrc = nbrc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public CalculeAHP() {
    }

    public FuzzyNumber[] getFn() {
        return fn;
    }

    public void setFn(FuzzyNumber[] fn) {
        this.fn = fn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNbrl() {
        return nbrl;
    }

    public void setNbrl(int nbrl) {
        this.nbrl = nbrl;
    }

    public int getNbrc() {
        return nbrc;
    }

    public void setNbrc(int nbrc) {
        this.nbrc = nbrc;
    }
}
