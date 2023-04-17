package com.pfa2023.AHP.Models;

import com.pfa2023.AHP.Fuzzy.FuzzyNumber;

public class RelationSousCriteres {
    private String id;
    private SousCritere sousCritere1;
    private SousCritere sousCritere2;
    private Users users;
    private FuzzyNumber poids;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SousCritere getSousCritere1() {
        return sousCritere1;
    }

    public void setSousCritere1(SousCritere sousCritere1) {
        this.sousCritere1 = sousCritere1;
    }

    public SousCritere getSousCritere2() {
        return sousCritere2;
    }

    public void setSousCritere2(SousCritere sousCritere2) {
        this.sousCritere2 = sousCritere2;
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
