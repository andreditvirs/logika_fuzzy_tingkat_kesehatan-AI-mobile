package com.ai.logika_fuzzy_tingkat_kesehatan;

import java.util.ArrayList;

public class Fuzzification {
    /*
        INGAT! Hanya untuk data yang grafiknya berbentuk tarpesium
     */

    Data fD = new Data();
    int banyakDataTinggi = fD.getJenisTinggi().length;
    int banyakDataBerat = fD.getJenisBerat().length;
    private ArrayList<Tinggi> listTinggi = new ArrayList<>();
    private ArrayList<Berat> listBerat = new ArrayList<>();

    public Fuzzification(){
        init();
    }

    public void init(){
        buatDatabaseTinggi();
        buatDatabaseBerat();
    }

    public void buatDatabaseTinggi(){
        for(int i = 0; i< banyakDataTinggi; i++){
            if(i==0){
                listTinggi.add(
                        new Tinggi(i
                                , fD.getJenisTinggi()[i]
                                , fD.getBatasTinggi()[i][0]
                                , fD.getBatasTinggi()[i][0]
                                , fD.getBatasTinggi()[i+1][0]
                                , fD.getBatasTinggi()[i][1]
                        ));
            }else{ // BUG : jika grafik tidak sesuai ppt
                listTinggi.add(
                        new Tinggi(i
                                , fD.getJenisTinggi()[i]
                                , fD.getBatasTinggi()[i][0]
                                , fD.getBatasTinggi()[i-1][1]
                                , fD.getBatasTinggi()[i+1][0]
                                , fD.getBatasTinggi()[i][1]
                        ));
            }
        }
    }

    public void buatDatabaseBerat(){
        for(int i = 0; i< banyakDataBerat; i++){
            if(i==0){
                listBerat.add(
                        new Berat(i
                                , fD.getJenisBerat()[i]
                                , fD.getBatasBerat()[i][0]
                                , fD.getBatasBerat()[i][0]
                                , fD.getBatasBerat()[i+1][0]
                                , fD.getBatasBerat()[i][1]
                        ));
            }else{ // BUG : jika grafik tidak sesuai ppt
                listBerat.add(
                        new Berat(i
                                , fD.getJenisBerat()[i]
                                , fD.getBatasBerat()[i][0]
                                , fD.getBatasBerat()[i-1][1]
                                , fD.getBatasBerat()[i+1][0]
                                , fD.getBatasBerat()[i][1]
                        ));
            }
        }
    }

    public ArrayList<Tinggi> getListTinggi(float tinggi){
        ArrayList<Tinggi> tinggiTemp = new ArrayList<>();
        if(tinggi > listTinggi.get(banyakDataTinggi-1).getB()){ // Jika melebihi nilai berat d yang terakhir langsung return
            tinggiTemp.add(listTinggi.get(banyakDataTinggi-1));
            listTinggi.get(banyakDataTinggi-1).setStatus('f');
            return tinggiTemp;
        }
        /* Status keberadaan
            Jika z, maka ada di x<=a atau x>=d (zero area)
            Jika i, maka ada di a<x<=b (in)
            Jika f, maka ada di b<x<=c (flat)
            Jika o, maka ada di c<x<d (out)
         */
        int a,b,c,d;
        for(int i = 0; i < banyakDataTinggi; i++){
            a = listTinggi.get(i).getA();
            b = listTinggi.get(i).getB();
            c = listTinggi.get(i).getC();
            d = listTinggi.get(i).getD();

            if(tinggi > a && tinggi <= b){
                tinggiTemp.add(listTinggi.get(i));
                listTinggi.get(i).setStatus('i');
            }else if(tinggi > b && tinggi <= c){
                tinggiTemp.add(listTinggi.get(i));
                listTinggi.get(i).setStatus('f');
            }else if(tinggi > c && tinggi <=d){
                tinggiTemp.add(listTinggi.get(i));
                listTinggi.get(i).setStatus('o');
            }
        }
        return tinggiTemp;
    }

    public ArrayList<Berat> getListBerat(float berat){
        ArrayList<Berat> beratTemp = new ArrayList<>();

        if(berat > listBerat.get(banyakDataBerat-1).getB()){ // Jika melebihi nilai berat d yang terakhir langsung return
            beratTemp.add(listBerat.get(banyakDataBerat-1));
            listBerat.get(banyakDataBerat-1).setStatus('f');
            return beratTemp;
        }

        /* Status keberadaan
            Jika z, maka ada di x<=a atau x>=d (zero area)
            Jika i, maka ada di a<x<=b (in)
            Jika f, maka ada di b<x<=c (flat)
            Jika o, maka ada di c<x<d (out)
         */
        int a,b,c,d;
        for(int i = 0; i < banyakDataBerat; i++){
            a = listBerat.get(i).getA();
            b = listBerat.get(i).getB();
            c = listBerat.get(i).getC();
            d = listBerat.get(i).getD();

            if(berat > a && berat <= b){
                beratTemp.add(listBerat.get(i));
                listBerat.get(i).setStatus('i');
            }else if(berat > b && berat <= c){
                beratTemp.add(listBerat.get(i));
                listBerat.get(i).setStatus('f');
            }else if(berat > c && berat <=d){
                beratTemp.add(listBerat.get(i));
                listBerat.get(i).setStatus('o');
            }
        }
        return beratTemp;
    }
}
