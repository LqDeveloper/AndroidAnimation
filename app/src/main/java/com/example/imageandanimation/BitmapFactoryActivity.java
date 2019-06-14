package com.example.imageandanimation;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class BitmapFactoryActivity extends AppCompatActivity implements View.OnClickListener {
    private List<String> imageList;
    private ImageView imageView;
    private TextView textView;
    private  int currentImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap_factory);
        setTitle("BitmapFactoryActivity");
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.changeImage);
        textView.setOnClickListener(this);
        imageList = new ArrayList<>();
        try {
           String[] images = getAssets().list("");
           for (int i=0;i <images.length;i++){
               String image = images[i];
               if (image.endsWith("jpg")){
                   imageList.add(image);
               }
           }

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (imageList.size() <= 0) { return; }
        showImage(imageList.get(0));
    }

    @Override
    public void onClick(View v) {
        if (imageList.size() <= 0) { return; }
        currentImage ++;
        int index = currentImage%imageList.size();
        showImage(imageList.get(index));
    }


    void showImage(String imagePath) {
        InputStream inputStream = null;
        try {
            inputStream = getAssets().open(imagePath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        BitmapDrawable bitmapDrawable = (BitmapDrawable) imageView.getDrawable();
        if (bitmapDrawable != null && !bitmapDrawable.getBitmap().isRecycled()) {
            bitmapDrawable.getBitmap().recycle();
        }
        imageView.setImageBitmap(BitmapFactory.decodeStream(inputStream));

    }
}
