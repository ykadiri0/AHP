package com.pfa2023.AHP.Controller;

import com.pfa2023.AHP.Fuzzy.FuzzyNumber;
import com.pfa2023.AHP.Fuzzy.MatrixConstructor;
import com.pfa2023.AHP.Models.*;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static com.pfa2023.AHP.Fuzzy.MatrixAggregation.weightedAggregation;

@RestController
public class AHPController {
    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("AHPmatrix/{id}")
    public FAHP getAHP(@PathVariable("id") String id) throws InterruptedException {
       // HttpHeaders headers = new HttpHeaders();
       // headers.setContentType(MediaType.APPLICATION_JSON)
        //;
        System.out.println("beginnnnnnnnnnnnnnn");
        String a="";
        FuzzyNumber r=new FuzzyNumber();
        HttpEntity<String> entity1 = new HttpEntity<>(a);
        ResponseEntity<List<Affectation>> list1=  restTemplate.exchange(
                "http://SERVICE-DONNEES/getaffectationbyProject?id="+id,
                HttpMethod.GET,
                entity1,
                new ParameterizedTypeReference<List<Affectation>>(){});
        System.out.println(list1.toString());
        double[][][][] cube = new double[list1.getBody().size()][Integer.parseInt(list1.getBody().get(0).getProjet().getNumCritere())][Integer.parseInt(list1.getBody().get(0).getProjet().getNumCritere())][3];
        System.out.println("size ooooooof             "+list1.getBody().size());
        for(int i=0;i<list1.getBody().size();i++){
            HttpEntity<String> entity = new HttpEntity<>(a);
            ResponseEntity<List<RelationCriters>> list=  restTemplate.exchange(
                    "http://SERVICE-DONNEES/getRelationCbyuser?id="+list1.getBody().get(i).getUsers().getId(),
                    HttpMethod.GET,
                    entity,
                    new ParameterizedTypeReference<List<RelationCriters>>(){});
            System.out.println("listt sizeeee    " +list.getBody().size());
            cube[i]=r.FtoD(MatrixConstructor.matrix(list.getBody()));


        }
        double[] weights = {0.2, 1, 0.5};
        // Create the aggregated matrix using the weighted aggregation function
        double[][][] aggregatedMatrix = weightedAggregation(cube, weights);
        // FuzzyNumber[][] F=MatrixConstructor.matrix(list.getBody());
        double [][] m1={ { 1, 3, 5 ,1}, {3, 1.5, 2,1}, { 0.2, 0.5, 1,1}, { 0.2, 0.5, 1,1}};

        FAHP fahp=new FAHP(aggregatedMatrix,m1);
           // System.out.println("/::::::::::::::::::");}
        double[] AHPwt= fahp.step1();
        HttpEntity<String> entity3 = new HttpEntity<>(a);
        ResponseEntity<List<Critere>> list3=  restTemplate.exchange(
                "http://SERVICE-DONNEES/getbyproject?id="+id,
                HttpMethod.GET,
                entity3,
                new ParameterizedTypeReference<List<Critere>>(){});
        for(int i=0;i<AHPwt.length;i++) {
            for(int j=0;j<AHPwt.length;j++){
                System.out.println("saving");
                if(i==list3.getBody().get(j).getIndex()){
                    System.out.println(i+"     body  "+list3.getBody().get(j).getIndex()+"   poids"+AHPwt[i]);
                    list3.getBody().get(j).setPoids(AHPwt[i]);
                    System.out.println(list3.getBody().get(j).getPoids());
                    System.out.println(list3.getBody().get(j).getIndex());
                    System.out.println(list3.getBody().get(j).getId());
                    HttpEntity<Critere> entity = new HttpEntity<>(list3.getBody().get(j));
                    ResponseEntity<Critere> list=  restTemplate.exchange(
                            "http://SERVICE-DONNEES/savecritere",
                            HttpMethod.POST,
                            entity,
                            new ParameterizedTypeReference<Critere>(){});
                }

            }

        }


///////////////////////////////////////////////////////////////
        System.out.println("begin sub ccccccccccccccccccccccrit");
        System.out.println(list3.getBody().size());
        List<Thread> threads = new ArrayList<>();
        for (Critere c:list3.getBody()){
            Thread t=new Thread(() -> {
            double[][][][] cubesc = new double[list1.getBody().size()][c.getNumSoucritere()][c.getNumSoucritere()][3];
            for(int i=0;i<list1.getBody().size();i++) {
                ResponseEntity<List<RelationSousCriteres>> list4 = restTemplate.exchange(
                        "http://SERVICE-DONNEES/getSousCritereRelationbyUandC?id=" + list1.getBody().get(i).getUsers().getId() + "&idc=" + c.getId(),
                        HttpMethod.GET,
                        entity3,
                        new ParameterizedTypeReference<List<RelationSousCriteres>>() {
                        });
                System.out.println("the sizzzzzzzzzzzzzeee   "+list4.getBody().size());
                cubesc[i]=r.FtoD(MatrixConstructor.matrixSC(list4.getBody()));

            }
            double[][][] aggregatedMatrixsc = weightedAggregation(cubesc, weights);
            FuzzyNumber[][] df=r.DtoF(aggregatedMatrixsc);
            FuzzyNumber[] fna=r.flatten(df);
            Projet p1= new Projet(id);
            CalculeAHP ca=new CalculeAHP(fna,p1,aggregatedMatrixsc.length);
                HttpEntity<CalculeAHP> entity11 = new HttpEntity<>(ca);
                ResponseEntity<CalculeAHP> list2=  restTemplate.exchange(
                        "http://SERVICE-DONNEES/saveCalcule",
                        HttpMethod.POST,
                        entity11,
                        new ParameterizedTypeReference<CalculeAHP>(){});






            // FuzzyNumber[][] F=MatrixConstructor.matrix(list.getBody());

            double [][] m1sc={ { 1, 3, 5 ,1}, {3, 1.5, 2,1}, { 0.2, 0.5, 1,1}, { 0.2, 0.5, 1,1}};

            FAHP fahpsc=new FAHP(aggregatedMatrixsc,m1sc);
            // System.out.println("/::::::::::::::::::");}
            double[] AHPwtsc= fahpsc.step1();




            ResponseEntity<List<SousCritere>> list33=  restTemplate.exchange(
                    "http://SERVICE-DONNEES/getSousCritereb?id="+c.getId(),
                    HttpMethod.GET,
                    entity3,
                    new ParameterizedTypeReference<List<SousCritere>>(){});
            for(int i=0;i<AHPwtsc.length;i++) {
                for(int j=0;j<AHPwtsc.length;j++){
                    System.out.println("saving");
                    if(i==list33.getBody().get(j).getIndex()){
                        list33.getBody().get(j).setPoids(AHPwtsc[i]*c.getPoids());
                        HttpEntity<SousCritere> entity = new HttpEntity<>(list33.getBody().get(j));
                        ResponseEntity<SousCritere> list=  restTemplate.exchange(
                                "http://SERVICE-DONNEES/saveSousCritere",
                                HttpMethod.POST,
                                entity,
                                new ParameterizedTypeReference<SousCritere>(){});
                    }

                }

            }
        });
            t.start();
            threads.add(t);
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");

        ResponseEntity<List<SousCritere>> list322=  restTemplate.exchange(
                "http://SERVICE-TOPSIS/Topsiscalcule/"+id,
                HttpMethod.GET,
                entity3,
                new ParameterizedTypeReference<List<SousCritere>>(){});
        return  fahp;
    }

}
