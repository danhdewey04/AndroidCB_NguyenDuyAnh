package com.example.lab2_2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private ValueAnimator progressAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m001_act_profile);

        progressBar = findViewById(R.id.progressBar);

        // Tạo ValueAnimator
        progressAnimator = ValueAnimator.ofInt(0, 100);
        progressAnimator.setDuration(5000); // 5 seconds
        progressAnimator.setInterpolator(new LinearInterpolator());

        progressAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int animatedValue = (int) animation.getAnimatedValue();
                progressBar.setProgress(animatedValue);
            }
        });

        progressAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                fadeOutProgressBar();
            }
        });

        // Bắt đầu animation
        startProgressAnimation();
    }

    private void startProgressAnimation() {
        // Đặt lại giá trị ProgressBar về 0 và đảm bảo nó hiển thị
        progressBar.setProgress(0);
        progressBar.setVisibility(View.VISIBLE);
        progressBar.setAlpha(1.0f);

        // Bắt đầu animation
        progressAnimator.start();
    }

    private void fadeOutProgressBar() {
        progressBar.animate()
                .alpha(0f)
                .setDuration(500) // Thời gian fade out: 0.5 giây
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        progressBar.setVisibility(View.GONE);
                    }
                })
                .start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (progressAnimator != null) {
            progressAnimator.cancel();
        }
    }
}