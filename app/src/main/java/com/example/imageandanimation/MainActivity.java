package com.example.imageandanimation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView mBitmapFactory;
    TextView mImageDector;
    TextView mCancasTextView;
    TextView mAnimation;
    TextView mTween;
    TextView mProperty;
    TextView mSurface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBitmapFactory = findViewById(R.id.bitmapFactory);
        mBitmapFactory.setOnClickListener(this);

        mImageDector = findViewById(R.id.imageDector);
        mImageDector.setOnClickListener(this);

        mCancasTextView = findViewById(R.id.imageCanvas);
        mCancasTextView.setOnClickListener(this);

        mAnimation = findViewById(R.id.animation);
        mAnimation.setOnClickListener(this);

        mTween = findViewById(R.id.bujian);
        mTween.setOnClickListener(this);

        mProperty = findViewById(R.id.shuxing);
        mProperty.setOnClickListener(this);

        mSurface= findViewById(R.id.surfaceView);
        mSurface.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.bitmapFactory:
                intent = new Intent(MainActivity.this, BitmapFactoryActivity.class);
                startActivity(intent);
                break;
            case R.id.imageDector:
                intent = new Intent(MainActivity.this, ImageDectorActivity.class);
                startActivity(intent);
                break;
            case R.id.imageCanvas:
                intent = new Intent(MainActivity.this, CancasActivity.class);
                startActivity(intent);
                break;
            case R.id.animation:
                intent = new Intent(MainActivity.this, AnimationActivity.class);
                startActivity(intent);
                break;
            case R.id.bujian:
                intent = new Intent(MainActivity.this, TweenActivity.class);
                startActivity(intent);
                break;
            case R.id.shuxing:
                intent = new Intent(MainActivity.this, PropertyActivity.class);
                startActivity(intent);
                break;
            case R.id.surfaceView:
                intent = new Intent(MainActivity.this, SurfaceActivity.class);
                startActivity(intent);
                break;
        }
    }
}
