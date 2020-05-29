package com.ai.logika_fuzzy_tingkat_kesehatan;

import java.util.Scanner;

public class LogikaFuzzy {

    private float t;
    private float b;

    Fuzzification f;
    RulesEvaluation rE;
    Defuzzification d;

    public void init(){
        f = new Fuzzification();
        rE = new RulesEvaluation(f.getListTinggi(t), f.getListBerat(b), t, b);
        d = new Defuzzification(f.getListTinggi(t), f.getListBerat(b), rE.getTabelKaidah(), rE.getNamaTabelKadiah());
    }

    public void setNilaiTinggi(float tinggi){
        t = tinggi;
    }

    public void setNilaiBerat(float berat){
        b = berat;
    }

    public String getNamaFuzzyDecisionIndexAtas(){
        return d.getNamaFuzzyDecisionIndexAtas();
    }

    public Double getNilaiFuzzyDecisonIndexAtas(){
        return d.getNilaiFuzzyDecisionIndexAtas();
    }

    public String getNamaFuzzyDecisionIndexBawah(){
        return d.getNamaFuzzyDecisionIndexBawah();
    }

    public Double getNilaiFuzzyDecisonIndexBawah(){
        return d.getNilaiFuzzyDecisionIndexBawah();
    }

    public String getNamaMaxMethod(){
        return d.getNamaMaxMethod();
    }

    public double getNilaiMaxMethod(){
        return d.getNilaiMaxMethod()*100;
    }
}
