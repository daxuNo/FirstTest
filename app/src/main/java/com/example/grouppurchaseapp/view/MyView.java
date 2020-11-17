package com.example.grouppurchaseapp.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView extends View {

    private Paint mPaint;

    //在代码中使用所调用的方法
    public MyView(Context context) {
        super(context);
        initPaint();
    }
    //在布局xml中使用所调用的方法
    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    //测量View控件
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
    }

    //绘制控件
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //画布
        //绘制一个圆
        canvas.drawCircle(60, 60,60 ,mPaint);
        //绘制文本
        canvas.drawText("这是一个文本",100,100,mPaint);
        //绘制直线
        canvas.drawLine(120,60,120,150,mPaint);
        //绘制路径
        Path path=new Path();
        path.moveTo(60,60);
        //绘制直线
        path.lineTo(60,60);
        path.lineTo(120,0);
        path.lineTo(180,60);
//        path.moveTo(120,0);
//        path.moveTo(180,120);
        //图形闭合
        path.close();
        canvas.drawPath(path,mPaint);



//        Resources r = this.getContext().getResources();
//        @SuppressLint("ResourceType")
//        InputStream is = r.openRawResource(R.drawable.index);
//        BitmapDrawable  bmpDraw = new BitmapDrawable(is);
//        Bitmap bmp = bmpDraw.getBitmap();
//
//        canvas.drawBitmap(bmp,100,100,mPaint);

    }

    private Paint initPaint() {
        //画笔
        mPaint = new Paint();
        //设置抗锯齿
        mPaint.setAntiAlias(true);
        //设置画笔的宽度
        mPaint.setStrokeWidth(5);
        //设置画笔的颜色
        mPaint.setColor(Color.BLUE);
        //设置画笔的样式
        mPaint.setStyle(Paint.Style.STROKE);
        //设置文本字体大小
        mPaint.setTextSize(20);
        return mPaint;
    }

}
