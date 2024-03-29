package com.example.imageandanimation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class PropertyActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_one;
    private Button btn_two;
    private Button btn_three;
    private Button btn_four;
    private LinearLayout ly_root;
    private ImageView img_babi;
    private int width;
    private int height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);
        bindViews();
    }

    private void bindViews() {
        ly_root = (LinearLayout) findViewById(R.id.ly_root);
        btn_one = (Button) findViewById(R.id.btn_one);
        btn_two = (Button) findViewById(R.id.btn_two);
        btn_three = (Button) findViewById(R.id.btn_three);
        btn_four = (Button) findViewById(R.id.btn_four);
        img_babi = (ImageView) findViewById(R.id.img_babi);

        btn_one.setOnClickListener(this);
        btn_two.setOnClickListener(this);
        btn_three.setOnClickListener(this);
        btn_four.setOnClickListener(this);
        img_babi.setOnClickListener(this);

        moveView(img_babi,20,30);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_one:
                lineAnimator();
                break;
            case R.id.btn_two:
                scaleAnimator();
                break;
            case R.id.btn_three:
                raAnimator();
                break;
            case R.id.btn_four:
                circleAnimator();
                break;
            case R.id.img_babi:
                Toast.makeText(PropertyActivity.this, "不愧是coder-pig~", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    //定义一个修改ImageView位置的方法
    private void moveView(View view, int rawX, int rawY) {
        int left = rawX - img_babi.getWidth() / 2;
        int top = rawY - img_babi.getHeight();
        int width = left + view.getWidth();
        int height = top + view.getHeight();
        view.layout(left, top, width, height);
    }
    //按轨迹方程来运动
    private void lineAnimator() {
        width = ly_root.getWidth();
        height = ly_root.getHeight();
//        ValueAnimator xValue = ValueAnimator.ofInt(height,0,height / 4,height / 2,height / 4 * 3 ,height);
//        xValue.setDuration(3000L);
//        xValue.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                // 轨迹方程 x = width / 2
//                int y = (Integer) animation.getAnimatedValue();
//                int x = width / 2;
//                moveView(img_babi, x, y);
//            }
//        });
//        xValue.setInterpolator(new LinearInterpolator());
//        xValue.start();
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(img_babi,"y",0,height);
        objectAnimator.setDuration(3000);
        objectAnimator.setInterpolator(new LinearInterpolator());
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
//                Log.d("PropertyActivity",animation.getAnimatedValue().toString());
            }
        });
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                  Log.d("PropertyActivity","动画开始");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d("PropertyActivity","动画结束");
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Log.d("PropertyActivity","动画取消");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.d("PropertyActivity","动画重复");
            }
        });
        objectAnimator.setRepeatCount(10);
        objectAnimator.start();



    }

    //缩放效果
    private void scaleAnimator(){

        //这里故意用两个是想让大家体会下组合动画怎么用而已~
//        final float scale = 0.5f;
//        AnimatorSet scaleSet = new AnimatorSet();
//        ValueAnimator valueAnimatorSmall = ValueAnimator.ofFloat(1.0f, scale);
//        valueAnimatorSmall.setDuration(500);
//
//        ValueAnimator valueAnimatorLarge = ValueAnimator.ofFloat(scale, 1.0f);
//        valueAnimatorLarge.setDuration(500);
//
//        valueAnimatorSmall.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                float scale = (Float) animation.getAnimatedValue();
//                img_babi.setScaleX(scale);
//                img_babi.setScaleY(scale);
//            }
//        });
//        valueAnimatorLarge.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                float scale = (Float) animation.getAnimatedValue();
//                img_babi.setScaleX(scale);
//                img_babi.setScaleY(scale);
//            }
//        });
//
//        scaleSet.play(valueAnimatorLarge).after(valueAnimatorSmall);
//        scaleSet.start();

        //其实可以一个就搞定的
//        ValueAnimator vValue = ValueAnimator.ofFloat(1.0f, 0.6f, 1.2f, 1.0f, 0.6f, 1.2f, 1.0f);
////        vValue.setDuration(1000L);
////        vValue.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
////            @Override
////            public void onAnimationUpdate(ValueAnimator animation) {
////                float scale = (Float) animation.getAnimatedValue();
////                img_babi.setScaleX(scale);
////                img_babi.setScaleY(scale);
////            }
////        });
////        vValue.setInterpolator(new LinearInterpolator());
////        vValue.start();

        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(img_babi,"scaleX",1.0f,0.1f);
        objectAnimator1.setRepeatCount(10);
        objectAnimator1.setDuration(1000);
        objectAnimator1.setInterpolator(new AccelerateInterpolator());
        objectAnimator1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Log.d("PropertyActivity","动画开始");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d("PropertyActivity","动画结束");
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Log.d("PropertyActivity","动画取消");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.d("PropertyActivity","动画重复");
            }
        });
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(img_babi,"scaleY",1.0f,0.1f);
        objectAnimator2.setRepeatCount(10);
        objectAnimator2.setDuration(1000);
        objectAnimator2.setInterpolator(new AccelerateInterpolator());
        objectAnimator2.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Log.d("PropertyActivity","动画开始");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d("PropertyActivity","动画结束");
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Log.d("PropertyActivity","动画取消");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.d("PropertyActivity","动画重复");
            }
        });

        AnimatorSet set = new AnimatorSet();
        set.play(objectAnimator1).with(objectAnimator2);
        set.start();
    }


    //旋转的同时透明度变化
    private void raAnimator(){
//        ValueAnimator rValue = ValueAnimator.ofInt(0, 360);
//        rValue.setDuration(1000L);
//        rValue.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                int rotateValue = (Integer) animation.getAnimatedValue();
//                img_babi.setRotation(rotateValue);
//                float fractionValue = animation.getAnimatedFraction();
//                img_babi.setAlpha(fractionValue);
//            }
//        });
//        rValue.setInterpolator(new DecelerateInterpolator());
//        rValue.start();

        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(img_babi,"alpha",0,360);
        objectAnimator.setInterpolator(new DecelerateInterpolator());
        objectAnimator.setRepeatCount(5);
        objectAnimator.setDuration(3000);
        objectAnimator.start();
    }

    //圆形旋转
    protected void circleAnimator() {
        width = ly_root.getWidth();
        height = ly_root.getHeight();
//        final int R = width / 4;
//        ValueAnimator tValue = ValueAnimator.ofFloat(0,
//                (float) (2.0f * Math.PI));
//        tValue.setDuration(1000);
//        tValue.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                // 圆的参数方程 x = R * sin(t) y = R * cos(t)
//                float t = (Float) animation.getAnimatedValue();
//                int x = (int) (R * Math.sin(t) + width / 2);
//                int y = (int) (R * Math.cos(t) + height / 2);
//                moveView(img_babi, x, y);
//            }
//        });
//        tValue.setInterpolator(new DecelerateInterpolator());
//        tValue.start();

        ValueAnimator valueAnimator = ValueAnimator.ofObject(new MyTypeEvaluator(width,height),new MyTypeEvaluator.Point(0,(float) (2.0f * Math.PI)),new MyTypeEvaluator.Point(0,(float) (2.0f * Math.PI)));
        valueAnimator.setDuration(3000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                MyTypeEvaluator.Point point =(MyTypeEvaluator.Point) animation.getAnimatedValue();
                moveView(img_babi,(int)point.getX(),(int) point.getY());
            }
        });
    }
}
