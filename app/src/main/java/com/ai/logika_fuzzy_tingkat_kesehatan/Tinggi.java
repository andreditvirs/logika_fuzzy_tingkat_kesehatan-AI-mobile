package com.ai.logika_fuzzy_tingkat_kesehatan;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Tinggi {
    private int id;
    private String jenisTinggi;
    private int a;
    private int b;
    private int c;
    private int d;
    private char status;

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Tinggi(int id, String jenisTinggi, int a, int b, int c, int d) {
        this.id = id;
        this.jenisTinggi = jenisTinggi;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public int getId() {
        return id;
    }

    public String getJenisTinggi() {
        return jenisTinggi;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public int getD() {
        return d;
    }

    @Override
    public String toString() {
        return "Tinggi{" +
                "id=" + id +
                ", jenisTinggi='" + jenisTinggi + '\'' +
                ", a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                ", \n";
    }
}
