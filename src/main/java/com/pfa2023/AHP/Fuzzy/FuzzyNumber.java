package com.pfa2023.AHP.Fuzzy;


public class FuzzyNumber {
    private  double lowerBound;

    private  double midlbound;
    private  double upperBound;

    public FuzzyNumber(double lowerBound, double midlbound, double upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.midlbound=midlbound;
    }

    @Override
    public String toString() {
        return "FuzzyNumber{" +
                "lowerBound=" + lowerBound +
                ", midlbound=" + midlbound +
                ", upperBound=" + upperBound +
                '}';
    }

    public double[] fuzzytodb(FuzzyNumber f){
        double[] d={f.lowerBound, f.midlbound,f.upperBound};
        return d;

    }
    public FuzzyNumber() {

    }
    public double[][][] FtoD(FuzzyNumber[][] f){
        double[][][] fcOMPAHP= new double[f.length][f.length][3];
        for (int i=0;i<f.length;i++){
            for (int j=0;j<f.length;j++){
                fcOMPAHP[i][j]=fuzzytodb(f[i][j]);
            }
        }
        return fcOMPAHP;

    }
    public   FuzzyNumber inv(FuzzyNumber f){
        double i=0;
        i=1.0/f.lowerBound;
        f.lowerBound= 1.0/f.upperBound;
        f.midlbound=1.0/ f.midlbound;
        f.upperBound=i;
        return f;
    }

    public void setLowerBound(double lowerBound) {
        this.lowerBound = lowerBound;
    }

    public double getMidlbound() {
        return midlbound;
    }

    public void setMidlbound(double midlbound) {
        this.midlbound = midlbound;
    }

    public void setUpperBound(double upperBound) {
        this.upperBound = upperBound;
    }

    public double getLowerBound() {
        return lowerBound;
    }

    public double getUpperBound() {
        return upperBound;
    }

    public double getMidpoint() {
        return (lowerBound + upperBound) / 2;
    }

    public double getWidth() {
        return upperBound - lowerBound;
    }


}
