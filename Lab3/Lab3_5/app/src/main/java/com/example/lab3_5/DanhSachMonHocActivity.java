package com.example.lab3_5;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class DanhSachMonHocActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_mon_hoc);

        ListView lvMonHoc = (ListView)findViewById(R.id.listViewMonHoc);
        final String[] dsmon = new String[]{"Công nghệ Phần mềm", "Web", "Di động", "Giao diện", "Mạng máy tính", "Hệ điều hành"};

        ArrayAdapter<String> adap = new ArrayAdapter<>(
                DanhSachMonHocActivity.this,
                android.R.layout.simple_list_item_1,
                dsmon
        );

        lvMonHoc.setAdapter(adap);

        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String kq = "Position : " + position + " , value = " + dsmon[position];
                Toast.makeText(DanhSachMonHocActivity.this, kq, Toast.LENGTH_LONG).show();
            }
        });
    }
}
