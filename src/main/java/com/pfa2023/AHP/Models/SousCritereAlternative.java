package com.pfa2023.AHP.Models;

import com.pfa2023.AHP.Fuzzy.FuzzyNumber;

public class SousCritereAlternative {

    private String id;

    private SousCritere sousCritere;

    private Alternative alternative;
    private Users users;
    private FuzzyNumber poids;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SousCritere getSousCritere() {
        return sousCritere;
    }

    public void setSousCritere(SousCritere sousCritere) {
        this.sousCritere = sousCritere;
    }

    public Alternative getAlternative() {
        return alternative;
    }

    public void setAlternative(Alternative alternative) {
        this.alternative = alternative;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public FuzzyNumber getPoids() {
        return poids;
    }

    public void setPoids(FuzzyNumber poids) {
        this.poids = poids;
    }
}
