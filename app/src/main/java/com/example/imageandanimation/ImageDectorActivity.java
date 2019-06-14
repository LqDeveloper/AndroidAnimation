package com.example.imageandanimation;

import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageDectorActivity extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_dector);
        setTitle("ImageDectorActivity");

        imageView = findViewById(R.id.imageDectorImageView);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P){
//            ImageDecoder.Source source = ImageDecoder.createSource(getResources(),R.drawable.image1);
//            try {
//                  Drawable drawable = ImageDecoder.decodeDrawable(source, (decoder,info,s)->{
//
//                });
//            }catch (Exception e){
//                e.printStackTrace();
//            }
        }


    }
}
