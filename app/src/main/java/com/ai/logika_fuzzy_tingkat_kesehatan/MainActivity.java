package com.ai.logika_fuzzy_tingkat_kesehatan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText tinggi, berat;
    TextView maxMethod, centroidMethod;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tinggi = findViewById(R.id.tinggi);
        berat = findViewById(R.id.berat);
        maxMethod = findViewById(R.id.maxMethod);
        centroidMethod = findViewById(R.id.centroidMethod);
        btn = findViewById(R.id.btnProcess);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t = tinggi.getText().toString().trim();
                String b = berat.getText().toString().trim();
                if(TextUtils.isEmpty(t)){
                    tinggi.requestFocus();
                    tinggi.setError("Masukkan tinggi badan");
                } else if(TextUtils.isEmpty(b)){
                    berat.requestFocus();
                    berat.setError("Masukkan berat badan");
                }else{
                    if(!btn.getText().equals("RESET")){
                        Main.init();
                        Main.setNilai(Float.parseFloat(t), Float.parseFloat(b));
                        maxMethod.setText(Main.getHasilMaxMethod());
                        centroidMethod.setText(Main.getHasilCentroidMethod());
                        btn.setText("RESET");
                    }else{
                        tinggi.setText("");
                        berat.setText("");
                        maxMethod.setText("--- Belum ada hasil ---");
                        centroidMethod.setText("--- Belum ada hasil ---");
                        btn.setText("PROSES");
                    }
                }
            }
        });
    }
}
