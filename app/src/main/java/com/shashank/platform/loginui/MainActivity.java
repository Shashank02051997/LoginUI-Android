package com.shashank.platform.loginui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;
    private boolean morning = true;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);

        // you should avoid using the following behavior (it is only for demo purposes)
        imageView.setOnTouchListener(new OnSwipeTouchListener(getApplicationContext()) {
            public void onSwipeRight() {
                changeBackground();
            }

            public void onSwipeLeft() {
                changeBackground();
            }
        });
    }

    private void changeBackground() {
        if (morning) {
            imageView.setImageResource(R.drawable.good_night_img);
            textView.setText("Night");
            morning = false;
        } else {
            imageView.setImageResource(R.drawable.good_morning_img);
            textView.setText("Morning");
            morning = true;
        }
    }
}
