package com.example.lab3_4;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnGgSearch, btnCall, btnDial, btnView, btnSendto, btnImage, btnMusic, btnScore;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnGgSearch = findViewById(R.id.btnGgSearch);
        btnCall = findViewById(R.id.btnCall);
        btnDial = findViewById(R.id.btnDial);
        btnView = findViewById(R.id.btnView);
        btnSendto = findViewById(R.id.btnSendto);
        btnImage = findViewById(R.id.btnImage);
        btnMusic = findViewById(R.id.btnMusic);
        btnScore = findViewById(R.id.btnScore);

        btnGgSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent google = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com.vn/?hl=vi"));
                startActivity(google);
            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call = new Intent(Intent.ACTION_CALL, Uri.parse("tel: (+84)888888888"));
                startActivity(call);
            }
        });

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Dial = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:(+84)888888888"));
                startActivity(Dial);
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent View = new Intent(Intent.ACTION_VIEW,Uri.parse("content://contacts/people/"));
                startActivity(View);
            }
        });

        btnSendto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Sendto = new Intent(Intent.ACTION_SENDTO);
                Sendto.setData(Uri.parse("smsto:+8488888888")); // Định dạng URI cho SMS
                Sendto.putExtra("sms_body", "Em ăn cơm chưa?"); // Đặt nội dung tin nhắn
                startActivity(Sendto);

            }
        });

        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Image = new Intent();
                Image.setType("image/pictures/*");
                Image.setAction(Intent.ACTION_GET_CONTENT);
                startActivity(Image);
            }
        });

        btnMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Music = new Intent("android.intent.action.MUSIC_PLAYER");
                startActivity(Music);
            }
        });

        btnScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://goo.gl/maps/uFyzc2qigiM2";
                Intent Score = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(Score);
            }
        });
    }
}