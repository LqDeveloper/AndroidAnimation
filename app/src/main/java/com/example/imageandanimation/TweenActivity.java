package com.example.imageandanimation;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


/*
* 1.补间动画功能比较单调，至于四中动画 透明度，旋转，倾斜，位移
*
* 2.补间动画针对的对象只有UI控件
*
* 3.补间动画只是改变View的显示效果，不会去改变view的属性
* */
public class TweenActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView;
    TextView textView1;
    TextView textView2;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween);
        imageView = findViewById(R.id.imageView);
        textView1 = findViewById(R.id.start);
        textView2 = findViewById(R.id.stop);

        textView1.setOnClickListener(this);
        textView2.setOnClickListener(this);


        animation = AnimationUtils.loadAnimation(this, R.anim.anim);
        animation.setFillAfter(true);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start:
                imageView.startAnimation(animation);
                break;
            case R.id.stop:
                imageView.clearAnimation();
                break;
        }
    }
}
