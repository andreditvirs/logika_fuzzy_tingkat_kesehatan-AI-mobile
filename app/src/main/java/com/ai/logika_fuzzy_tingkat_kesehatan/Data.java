package com.ai.logika_fuzzy_tingkat_kesehatan;

import java.util.ArrayList;

public class Data {

    private String[] jenisTinggi= {
            "Sangat pendek"
            , "Pendek"
            , "Sedang"
            , "Tinggi"
            , "Sangat tinggi"
    };

    private int[][] batasTinggi = {
            {0, 120} // format a, d
            , {115, 145}
            , {140, 165}
            , {160, 185}
            , {180, -1}
            , {-1, -1} // -1 menandakan jika niali > 180 bukan nilai -1 asli (infinity)
    };

    private String[] jenisBerat = {
            "Sangat kurus"
            , "Kurus"
            , "Biasa"
            , "Berat"
            , "Sangat berat"
    };

    private int[][] batasBerat = {
            {0, 45}
            , {40, 55}
            , {50, 65}
            , {60, 85}
            , {80, -1}
            , {-1, -1}
    };

    private String[] jenisSehat = {
            "SS"
            , "S"
            , "AS"
            , "TS"
    };

    private double[] indexSehat = {0.8, 0.6, 0.4, 0.2};

    public String[] getJenisSehat() {
        return jenisSehat;
    }

    public double[] getIndexSehat() {
        return indexSehat;
    }

    public String[] getJenisTinggi() {
        return jenisTinggi;
    }

    public int[][] getBatasTinggi() {
        return batasTinggi;
    }

    public String[] getJenisBerat() {
        return jenisBerat;
    }

    public int[][] getBatasBerat() {
        return batasBerat;
    }
}
