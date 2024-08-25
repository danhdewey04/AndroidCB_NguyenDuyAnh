package com.example.lab12;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.Random;

public class RandomFragment extends Fragment {

    private TextView randomNumberTextView;
    private Random random = new Random();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_random, container, false);

        randomNumberTextView = view.findViewById(R.id.randomNumberTextView);
        Button randomButton = view.findViewById(R.id.randomButton);

        randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateRandomNumber();
            }
        });

        return view;
    }

    private void generateRandomNumber() {
        int randomNumber = random.nextInt(100);
        randomNumberTextView.setText(String.format("%02d", randomNumber));
    }
}