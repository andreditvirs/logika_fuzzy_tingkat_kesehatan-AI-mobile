package com.ai.logika_fuzzy_tingkat_kesehatan;

import java.text.DecimalFormat;

public class Main {
    private static LogikaFuzzy logikaFuzzy;

    public static void setNilai(float tinggi, float berat){
        logikaFuzzy.setNilaiTinggi(tinggi);
        logikaFuzzy.setNilaiBerat(berat);
        logikaFuzzy.init();
    }

    public static void init(){
        logikaFuzzy =  new LogikaFuzzy();
    }

    public static String getHasilMaxMethod(){
        DecimalFormat df = new DecimalFormat("###.##");
        return (df.format(logikaFuzzy.getNilaiMaxMethod())+"%\n"+logikaFuzzy.getNamaMaxMethod());
    }

    public static String getHasilCentroidMethod(){
        DecimalFormat df = new DecimalFormat("###.##");
        return (df.format(logikaFuzzy.getNilaiFuzzyDecisonIndexAtas())
                +"% \n"+logikaFuzzy.getNamaFuzzyDecisionIndexAtas()
                +"\n\n"+ df.format(logikaFuzzy.getNilaiFuzzyDecisonIndexBawah())
                +"%\n"+logikaFuzzy.getNamaFuzzyDecisionIndexBawah());
    }
}
