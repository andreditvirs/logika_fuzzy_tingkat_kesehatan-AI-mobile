package com.ai.logika_fuzzy_tingkat_kesehatan;

import java.util.ArrayList;

public class Berat {
    private int id;
    private String jenisBerat;
    private int a;
    private int b;
    private int c;
    private int d;
    private char status;

    public Berat(int id, String jenisBerat, int a, int b, int c,int d) {
        this.id = id;
        this.jenisBerat = jenisBerat;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public int getId() {
        return id;
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

    public void setStatus(char status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Berat{" +
                "id=" + id +
                ", jenisBerat='" + jenisBerat + '\'' +
                ", a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                "\n";
    }
}
