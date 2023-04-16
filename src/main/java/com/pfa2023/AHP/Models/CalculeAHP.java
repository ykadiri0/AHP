package com.pfa2023.AHP.Models;


import com.pfa2023.AHP.Fuzzy.FuzzyNumber;
import com.pfa2023.AHP.Models.Projet;

public class CalculeAHP {
    private String id;

    private FuzzyNumber[]  fn;
    private Projet projet;

    private int nbr;


    public CalculeAHP(FuzzyNumber[] fn, Projet projet, int nbr) {
        this.fn = fn;
        this.projet = projet;
        this.nbr=nbr;
    }


    public FuzzyNumber[] getFn() {
        return fn;
    }

    public void setFn(FuzzyNumber[] fn) {
        this.fn = fn;
    }

}
