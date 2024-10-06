package com.example.apptruynci;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class ConGaiActivity extends AppCompatActivity {

    private ListView listView;
    private String[] conGaiItems = {
            "Việc học", "Đã hai lần rồi", "Cũng như nhau", "Rất lạnh",
            "Im lặng là vàng", "Bài học về tôi đổi", "Chưa chỉ đã đau",
            "1 xu và 1 phút", "Sao còn chưa thả?", "Đi tích hóa thạch",
            "Nhầm lẫn tai hại", "Cánh giấc"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_con_gai);

        getSupportActionBar().setTitle("Con gái");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.listViewConGai);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, conGaiItems);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (conGaiItems[position].equals("Việc học")) {
                    Intent intent = new Intent(ConGaiActivity.this, ViecHocActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}