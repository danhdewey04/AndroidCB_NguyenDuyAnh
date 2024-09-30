package com.example.lab3_5;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TinhTongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinh_tong);

        EditText etSoA = findViewById(R.id.etSoA);
        EditText etSoB = findViewById(R.id.etSoB);
        Button btnTinhTong = findViewById(R.id.btnTinhTong);
        Button btnTruVe = findViewById(R.id.btnTruVe);
        Button btnThoat = findViewById(R.id.btnThoat);
        TextView tvKetQua = findViewById(R.id.tvKetQua);

        btnTinhTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soA = Integer.parseInt(etSoA.getText().toString());
                int soB = Integer.parseInt(etSoB.getText().toString());
                int tong = soA + soB;
                tvKetQua.setText("Tổng: " + tong);
            }
        });

        btnTruVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });
    }
}
