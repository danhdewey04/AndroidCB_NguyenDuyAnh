package com.example.apptruynci;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ViecHocActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viec_hoc);

        getSupportActionBar().setTitle("Việc học");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView contentTextView = findViewById(R.id.contentTextView);
        contentTextView.setText(
                "Lúc bé: nghỉ học là chuyện lạ. Lớn lên mới biết, chuyện lạ là đi học.\n" +
                        "Lúc bé: tưởng trường là chỗi học. Lớn lên mới biết, đến trường còn được ngủ.\n" +
                        "Lúc bé: tưởng thì xong là hết. Lớn lên mới biết, sau thi còn có thi lại.\n" +
                        "Lúc bé: tưởng điểm 10 mới là giỏi. Lớn lên mới biết, chỉ 5 thôi đã quý lắm rồi.\n" +
                        "Lúc bé: tưởng càng học càng giỏi.\n" +
                        "Lớn lên mới biết, càng học càng ngu."
        );
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}