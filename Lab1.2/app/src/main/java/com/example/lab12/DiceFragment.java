package com.example.lab12;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.Random;

public class DiceFragment extends Fragment {

    private ImageView diceImageView;
    private Random random = new Random();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dice, container, false);

        diceImageView = view.findViewById(R.id.diceImageView);
        View diceLayout = view.findViewById(R.id.constraintLayout);

        diceLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();
            }
        });

        return view;
    }

    private void rollDice() {
        int randomNumber = random.nextInt(6) + 1;
        int drawableResource = 0;

        switch (randomNumber) {
            case 1:
                drawableResource = R.drawable.dice1;
                break;
            case 2:
                drawableResource = R.drawable.dice2;
                break;
            case 3:
                drawableResource = R.drawable.dice3;
                break;
            case 4:
                drawableResource = R.drawable.dice4;
                break;
            case 5:
                drawableResource = R.drawable.dice5;
                break;
            case 6:
                drawableResource = R.drawable.dice6;
                break;
        }

        diceImageView.setImageResource(drawableResource);
    }
}