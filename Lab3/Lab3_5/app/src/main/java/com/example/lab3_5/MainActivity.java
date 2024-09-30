package com.example.lab3_5;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnTinhTong = findViewById(R.id.btnTinhTong);
        Button btnDanhSachMonHoc = findViewById(R.id.btnDanhSachMonHoc);

        btnTinhTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TinhTongActivity.class);
                startActivity(intent);
            }
        });

        btnDanhSachMonHoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DanhSachMonHocActivity.class);
                startActivity(intent);
            }
        });
    }
}