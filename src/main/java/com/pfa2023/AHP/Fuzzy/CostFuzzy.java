package com.pfa2023.AHP.Fuzzy;

public class CostFuzzy {
    private FuzzyNumber fuzzyNumber;
    private Boolean costOrbenef;

    public CostFuzzy() {
    }

    public CostFuzzy(FuzzyNumber fuzzyNumber, Boolean costOrbenef) {
        this.fuzzyNumber = fuzzyNumber;
        this.costOrbenef = costOrbenef;
    }

    public FuzzyNumber getFuzzyNumber() {
        return fuzzyNumber;
    }

    public void setFuzzyNumber(FuzzyNumber fuzzyNumber) {
        this.fuzzyNumber = fuzzyNumber;
    }

    public Boolean getCostOrbenef() {
        return costOrbenef;
    }

    public void setCostOrbenef(Boolean costOrbenef) {
        this.costOrbenef = costOrbenef;
    }


}
