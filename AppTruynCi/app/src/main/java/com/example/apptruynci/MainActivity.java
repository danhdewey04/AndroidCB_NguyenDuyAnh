package com.example.apptruynci;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private String[] categories = {"Con gái", "Sưu tầm", "Công sở", "Cười 18", "Cực hài", "Dân gian", "Gia đình", "Giao thông", "Học sinh"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, categories);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (categories[position].equals("Con gái")) {
                    Intent intent = new Intent(MainActivity.this, ConGaiActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}