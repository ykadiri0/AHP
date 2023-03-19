package com.pfa2023.AHP.Models;

public class FAHP {
    double [][] pcomp;
    double [][][] fcOMPAHP;
    double [][] widths;

    public FAHP(double [][][] pcomp,double [][] widths){
        this.fcOMPAHP=pcomp;
        this.widths=widths;
        //affctW(pcomp,widths);
    }


    public void affctW(double [][] mc, double [][] wm){
        int r=0;
        this.fcOMPAHP= new double[mc.length][mc[0].length][wm.length];
        for(int i=0; i<mc.length;i++){
            for(int j=0; j<mc[0].length; j++){
                this.fcOMPAHP[i][j]=wm[r];
                r++;
            }
        }
    }

    public double[] step1(){
        double[][][] arr3D = this.fcOMPAHP;
        int dim1 = arr3D.length;
        int dim2 = arr3D[0].length;
        int dim3 = arr3D[0][0].length;
        double[][] arr2D = new double[dim1][dim3];

        for (int i = 0; i < dim1; i++) {
            for (int k = 0; k < dim3; k++) {
                double sum = 0.0;
                for (int j = 0; j < dim2; j++) {
                    sum += arr3D[i][j][k];
                }
                arr2D[i][k] = sum;
            }
        }
        int numRows = arr2D.length;
        int numCols = arr2D[0].length;
        double[] arrSum = new double[numCols];

        for (int j = 0; j < numCols; j++) {
            double sum = 0.0;
            for (int i = 0; i < numRows; i++) {
                sum += arr2D[i][j];
            }
            arrSum[j] = sum;
        }

        int length = arrSum.length;
        double[] inverse = new double[length];

        for (int i = 0; i <length; i++) {
            inverse[i] = 1.0 / arrSum[length-i-1];
        }


        double[][] fp=new double[arr2D.length][inverse.length];
        int r1=0;
        for (double [] j: arr2D){

            int len=j.length;
            for (int i=0; i<len; i++){
                fp[r1][i]=j[i]*inverse[i];
            }
            r1++;
        }


        double [][] vs=new double[this.fcOMPAHP.length][this.fcOMPAHP.length-1];
        int p=0;
        for (double[] r:fp){
            int w=0;
            for(double[] e:fp){
                if (r == e) {
                    continue;
                }else {
                    if(r[1]>=e[1]){
                        vs[p][w]=1;
                        w++;
                    } else if (e[0]>=r[2]) {
                        vs[p][w]=0;
                        w++;
                    }else{
                        vs[p][w]=(e[0]-r[2])/(r[1]-r[2]-e[1]+e[0]);
                        w++;
                    }
                }

            }
            p++;
        }
        for (int i = 0; i < vs.length; i++) {
            for (int j = 0; j < vs[i].length; j++) {
                System.out.print(vs[i][j] + " ");
            }
            System.out.println();
        }


        double[] output = new double[vs.length];

        for (int i = 0; i < vs.length; i++) {
            double min = Double.MAX_VALUE;
            for (int j = 0; j < vs[i].length; j++) {
                if (vs[i][j] < min) {
                    min = vs[i][j];
                }
            }
            output[i] = min;
        }

        double somme=0;
        for(double i:output){
            somme+=i;
        }
        double[] a=new double[output.length];
        for(int i=0;i<output.length;i++){
            a[i]=output[i]/somme;
        }
        for(double i:a) {
            System.out.println(i);
        }
        return a;
    }

    public static void main(String[] args) {
        double [][] m1={ { 1, 3, 5 ,1}, {3, 1.5, 2,1}, { 0.2, 0.5, 1,1}, { 0.2, 0.5, 1,1}};
        double [][][] m2={
                { {1,1,1},{2,3,4},{2,3,4}},
        {{1.0/4.0,1.0/3.0,0.5},{1,1,1},{4,5,6}},
        {{1.0/4.0,1.0/3.0,0.5},{1.0/6,1.0/5,0.25},{1,1,1}}
        };
        FAHP f1= new FAHP(m2, m1);
        double[] e=f1.step1();
        System.out.println("////////////////////////////:::::");
        for(double i:e) {
            System.out.println(i);
            System.out.println("double matrix return");
        }
}


}
