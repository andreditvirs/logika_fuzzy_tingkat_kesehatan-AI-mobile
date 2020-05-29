package com.ai.logika_fuzzy_tingkat_kesehatan;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class RulesEvaluation {

    private String[][] namaTabelKadiah = {
            {"Kosong", "Kosong", "Kosong", "Kosong", "Kosong", "Kosong"}
            , {"Kosong", "SS", "S", "AS", "TS", "TS"}
            , {"Kosong", "S", "SS", "S", "AS", "TS"}
            , {"Kosong", "AS", "SS", "SS", "AS", "TS"}
            , {"Kosong", "TS", "S", "SS", "S", "TS"}
            , {"Kosong", "TS", "AS", "SS", "S", "AS"}
    };

    private float[][] tabelKaidah = new float[6][6];

    public RulesEvaluation(ArrayList<Tinggi> listTinggi, ArrayList<Berat> listBerat, float t, float b){
        setMeuOfTinggi(listTinggi, t);
        setMeuOfBerat(listBerat, b);
        buatTabelAND(listTinggi, listBerat);
    }

    public void setMeuOfTinggi(ArrayList<Tinggi> listTinggi, float x){
        if(listTinggi.size()==2){ // Jika berada di area perpotongan
            int c1 = listTinggi.get(0).getC(); // Mengambil c dari data pertama
            int d1 = listTinggi.get(0).getD(); // Mengambil d dari data pertama
            tabelKaidah[listTinggi.get(0).getId()+1][0] = (d1-x)/(d1-c1);
            int a2 = listTinggi.get(1).getA(); // Mengambil a dari data kedua
            int b2 = listTinggi.get(1).getB(); // Mengambil b dari data kedua
            tabelKaidah[listTinggi.get(1).getId()+1][0] = (x-a2)/(b2-a2);
        }else if(listTinggi.size() == 1){ // Jika berada di area flat
            tabelKaidah[listTinggi.get(0).getId()+1][0] = 1; // Pasti jika di flat nilainya satu
        }
    }


    public void setMeuOfBerat(ArrayList<Berat> listBerat, float x){
        if(listBerat.size()==2){ // Jika berada di area perpotongan
            int c1 = listBerat.get(0).getC(); // Mengambil c dari data pertama
            int d1 = listBerat.get(0).getD(); // Mengambil d dari data pertama
            tabelKaidah[0][listBerat.get(0).getId()+1] = (d1-x)/(d1-c1);
            int a2 = listBerat.get(1).getA(); // Mengambil a dari data kedua
            int b2 = listBerat.get(1).getB(); // Mengambil b dari data kedua
            tabelKaidah[0][listBerat.get(1).getId()+1] = (x-a2)/(b2-a2);
        }else if(listBerat.size() == 1){ // Jika berada di area flat
            tabelKaidah[0][listBerat.get(0).getId()+1] = 1; // Pasti jika di flat nilainya satu
        }
    }

    private void buatTabelAND(ArrayList<Tinggi> listTinggi, ArrayList<Berat> listBerat){
        // INGAT! Hanya untuk matriks 4 x 4, Kalau matriks 1x1 khusus yang diflat maka memakai indeksPertama dan indeksKetiga
        int indeksPertama = listBerat.get(0).getId()+1;
        int indeksKetiga = listTinggi.get(0).getId()+1;

        if(listBerat.size() == 2 && listTinggi.size() == 2){ // Jika 4x4
            int indeksKedua = listBerat.get(1).getId()+1; // indeks kedua dan keempat hanya dimiliki oleh matriks 4x4
            int indeksKeempat = listTinggi.get(1).getId()+1;
        /*
           Gambaran matriks (Inilah kenapa harus ditamah 1)
                                                            BERAT
                                    {0,0}             {0, id+1}               {0, id+1}
                                     ---             indeksPertama           indeksKedua
           TINGGI   {id+1, 0}        indeksKetiga     [hasilIndeksPertama]    [hasilIndeksKedua]
                    {id+1, 0}        indeksKeempat    [hasilIndeksKetiga]     [hasilIndeksKeempat]
         */

            // Matriks ordo hasil indeks pertama     = min(tinggi, berat)
            tabelKaidah[indeksKetiga][indeksPertama] = min(tabelKaidah[indeksKetiga][0], tabelKaidah[0][indeksPertama]);
            // Matriks ordo hasil indeks kedua
            tabelKaidah[indeksKetiga][indeksKedua] = min(tabelKaidah[indeksKetiga][0], tabelKaidah[0][indeksKedua]);
            // Matriks ordo hasil indeks ketiga
            tabelKaidah[indeksKeempat][indeksPertama] = min(tabelKaidah[indeksKeempat][0], tabelKaidah[0][indeksPertama]);
            // Matriks ordo hasil indeks keempat
            tabelKaidah[indeksKeempat][indeksKedua] = min(tabelKaidah[indeksKeempat][0], tabelKaidah[0][indeksKedua]);
        }else if(listTinggi.size() == 1 && listBerat.size() ==2){ // Jika tinggi di flat, tapi berat di i/o
            int indeksKedua = listBerat.get(1).getId()+1;
            tabelKaidah[indeksKetiga][indeksPertama] = min(tabelKaidah[indeksKetiga][0], tabelKaidah[0][indeksPertama]);
            tabelKaidah[indeksKetiga][indeksKedua] = min(tabelKaidah[indeksKetiga][0], tabelKaidah[0][indeksKedua]);
        }else if (listTinggi.size() == 2 && listBerat.size() == 1){
            int indeksKeempat = listTinggi.get(1).getId()+1;
            tabelKaidah[indeksKetiga][indeksPertama] = min(tabelKaidah[indeksKetiga][0], tabelKaidah[0][indeksPertama]);
            tabelKaidah[indeksKeempat][indeksPertama] = min(tabelKaidah[indeksKeempat][0], tabelKaidah[0][indeksPertama]);
        } else{ // Jika hanya 1x1 semua di flat
            tabelKaidah[indeksKetiga][indeksPertama] = min(tabelKaidah[indeksKetiga][0], tabelKaidah[0][indeksPertama]);
        }

    }

    private float min(float baris, float kolom){
        if(baris<kolom){
            return baris;
        }else if(baris>kolom){
            return kolom;
        }else{ // Jika sama dengan
            return baris;
        }
    }

    public float[][] getTabelKaidah(){
        return this.tabelKaidah;
    }

    public String[][] getNamaTabelKadiah(){
        return this.namaTabelKadiah;
    }
}
