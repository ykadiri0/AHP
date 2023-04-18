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

    public FuzzyNumber[][] DtoF(double[][][] d) {
        FuzzyNumber[][] result = new FuzzyNumber[d.length][d[0].length];
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[0].length; j++) {
                result[i][j] = new FuzzyNumber(d[i][j][0], d[i][j][1], d[i][j][2]);
            }
        }
        return result;
    }

    public FuzzyNumber[] flatten(FuzzyNumber[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;
        FuzzyNumber[] flatArr = new FuzzyNumber[rows * cols];
        int k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                flatArr[k++] = arr[i][j];
            }
        }
        return flatArr;
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
