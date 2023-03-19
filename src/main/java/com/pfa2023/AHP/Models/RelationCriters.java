package com.pfa2023.AHP.Models;

import com.pfa2023.AHP.Fuzzy.FuzzyNumber;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

public class RelationCriters {
    private String id;
    private Critere critere1;

    private Critere critere2;
    private Users users;
    private FuzzyNumber poids;

    public FuzzyNumber getPoids() {
        return poids;
    }

    public void setPoids(FuzzyNumber poids) {
        this.poids = poids;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Critere getCritere1() {
        return critere1;
    }

    public void setCritere1(Critere critere1) {
        this.critere1 = critere1;
    }

    public Critere getCritere2() {
        return critere2;
    }

    public void setCritere2(Critere critere2) {
        this.critere2 = critere2;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }



}
