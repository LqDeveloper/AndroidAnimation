package com.example.imageandanimation;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AnimationActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView;
    TextView textView1;
    TextView textView2;
    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        imageView = findViewById(R.id.imageView);
        animationDrawable = (AnimationDrawable) imageView.getBackground();
        textView1 = findViewById(R.id.start);
        textView2 = findViewById(R.id.stop);

        textView1.setOnClickListener(this);
        textView2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start:
                animationDrawable.start();
                break;
            case R.id.stop:
                animationDrawable.stop();
                break;
        }
    }
}
