package com.pfa2023.AHP.Fuzzy;

import com.pfa2023.AHP.Models.RelationCriters;
import com.pfa2023.AHP.Models.RelationSousCriteres;

import java.util.List;

public class MatrixConstructor {
    public static FuzzyNumber[][] matrix(List<RelationCriters> list){
        int listsize= list.size();
        FuzzyNumber[][] mat=new FuzzyNumber[listsize][listsize];
        for(int i=0;i<listsize;i++){
            mat[i][i]=new FuzzyNumber(1,1,1);

            mat[list.get(i).getCritere1().getIndex()][list.get(i).getCritere2().getIndex()]=list.get(i).getPoids();


            }
        for(int i=0;i<mat.length;i++) {
            for (int j = 0; j < mat.length; j++) {

                System.out.println(mat[i][j]);
            }
        }


        for(int i=0;i<listsize;i++) {
            if (mat[list.get(i).getCritere2().getIndex()][list.get(i).getCritere1().getIndex()] == null) {
                System.out.println("times");
                FuzzyNumber f=new FuzzyNumber();
                System.out.println(mat[list.get(i).getCritere2().getIndex()][list.get(i).getCritere1().getIndex()]);
                mat[list.get(i).getCritere2().getIndex()][list.get(i).getCritere1().getIndex()] = new FuzzyNumber(1.0/list.get(i).getPoids().getUpperBound(),1.0/list.get(i).getPoids().getMidlbound(),1.0/list.get(i).getPoids().getLowerBound());
                System.out.println(list.get(i).getCritere2().getIndex() + "    " + list.get(i).getCritere1().getIndex());
            }
        }






        return mat;

    }
    public static FuzzyNumber[][] matrixSC(List<RelationSousCriteres> list){
        int listsize= list.size();
        FuzzyNumber[][] mat = new FuzzyNumber[0][];
        if(listsize==1){
            mat=new FuzzyNumber[2][2];
        } else if (listsize==3) {
            mat=new FuzzyNumber[3][3];
        } else if (listsize==6) {
            mat=new FuzzyNumber[4][4];
        }
        System.out.println("MATTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT   "+listsize+"    " +mat.length+"    "+mat[0].length);
        for(int i=0;i<listsize;i++){

            mat[list.get(i).getSousCritere1().getIndex()][list.get(i).getSousCritere2().getIndex()]=list.get(i).getPoids();


        }
        for(int i=0;i<mat.length;i++){

            mat[i][i]=new FuzzyNumber(1,1,1);


        }
        for(int i=0;i<mat.length;i++) {
            for (int j = 0; j < mat.length; j++) {

                System.out.println(mat[i][j]);
            }
        }


        for(int i=0;i<listsize;i++) {
            if (mat[list.get(i).getSousCritere2().getIndex()][list.get(i).getSousCritere1().getIndex()] == null) {
                System.out.println("times");
                FuzzyNumber f=new FuzzyNumber();
                System.out.println(mat[list.get(i).getSousCritere2().getIndex()][list.get(i).getSousCritere1().getIndex()]);
                mat[list.get(i).getSousCritere2().getIndex()][list.get(i).getSousCritere1().getIndex()] = new FuzzyNumber(1.0/list.get(i).getPoids().getUpperBound(),1.0/list.get(i).getPoids().getMidlbound(),1.0/list.get(i).getPoids().getLowerBound());
                System.out.println(list.get(i).getSousCritere2().getIndex() + "    " + list.get(i).getSousCritere1().getIndex());
            }
        }


        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        for(int i=0;i<mat.length;i++) {
            for (int j = 0; j < mat.length; j++) {

                System.out.println(mat[i][j]);
            }
        }


        return mat;

    }
}
