package com.example.imageandanimation;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class CanvasView extends View {
    private int bgColor;

    private Path path1 = new Path();

    private RectF rectF = new RectF();

    private Paint paint = new Paint();

    public CanvasView(Context context) {
        this(context, null);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context,attrs);
    }

    private void initView(Context context, @Nullable AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CanvasView);
        if (typedArray == null) return;
        bgColor = typedArray.getColor(R.styleable.CanvasView_bgColor, 0);
        this.setBackgroundColor(bgColor);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.RED);
        /*去锯齿*/
        paint.setAntiAlias(true);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4f);
        int  viewWidth = this.getWidth();

        canvas.drawCircle(viewWidth/10+10,viewWidth/10+10,viewWidth/10,paint);

        canvas.drawRect(10f,viewWidth/5+20,viewWidth/5+20,viewWidth*2/5+20,paint);

        rectF.set(10f,viewWidth/2+40,viewWidth/5+10,viewWidth*3/5+40);
        canvas.drawRoundRect(rectF,15f,15f,paint);


        paint.setStyle(Paint.Style.STROKE);
        rectF.set(10f,viewWidth*3/5+50,viewWidth/5,viewWidth*7/10+50);
        canvas.drawOval(rectF,paint);



        path1.moveTo(10f,viewWidth *9/10 +60);
        path1.lineTo(viewWidth/5+10,viewWidth*9/10+60);
        path1.lineTo(viewWidth/10+10,viewWidth*7/10+60);
        path1.close();
//        int[] colos = new int[]{Color.RED,Color.GREEN,Color.BLUE};
//        Shader shader = new LinearGradient(0f,0f,100f,100f,colos,null,Shader.TileMode.REPEAT);
//        paint.setShader(shader);
        canvas.drawPath(path1,paint);
        paint.setColor(Color.BLUE);
        paint.setTextSize(40f);
        canvas.drawTextOnPath("这是文字",path1,0f,0f,paint);
    }
}
