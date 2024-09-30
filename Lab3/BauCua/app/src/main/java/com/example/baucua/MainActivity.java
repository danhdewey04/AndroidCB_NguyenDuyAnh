package com.example.baucua;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView[] imageViews;
    private int[] imageResources = {
            R.drawable.ga, R.drawable.cua, R.drawable.tom,
            R.drawable.ca, R.drawable.huou, R.drawable.holo
    };
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViews = new ImageView[3];
        imageViews[0] = findViewById(R.id.imageView1);
        imageViews[1] = findViewById(R.id.imageView2);
        imageViews[2] = findViewById(R.id.imageView3);

        random = new Random();

        Button playButton = findViewById(R.id.button);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playGame();
            }
        });
    }

    private void playGame() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int randomIndex = random.nextInt(imageResources.length);
            imageViews[i].setImageResource(imageResources[randomIndex]);
            result.append(getImageName(randomIndex));
            if (i < 2) result.append(", ");
        }

        Toast toast = Toast.makeText(this, result.toString(), Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }

    private String getImageName(int index) {
        switch (index) {
            case 0: return "Gà";
            case 1: return "Cua";
            case 2: return "Tôm";
            case 3: return "Cá";
            case 4: return "Nai";
            case 5: return "Bầu";
            default: return "";
        }
    }
}