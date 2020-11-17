package com.example.grouppurchaseapp.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import com.example.grouppurchaseapp.R;
public class Indicator extends View {

    //前景色画笔
    private Paint mForePaint;
    //背景颜色的画笔
    private Paint mBgPaint;
    //移动的偏移量
    private float mOffset;
    //Indicator 数量
    private int mNumber = 4;
    //半径
    private int mRadius = 20;
    //Indicator 的背景画笔颜色
    private int mBgColor = Color.RED;
    //Indicator 的前景色画笔颜色
    private int mForeColor = Color.BLUE;



    /**
     * 设置偏移量的方法
     *
     * @param position
     * @param qffset
     */
    public void setQffset(int position, float qffset) {

        mOffset = position * 3 * mRadius + qffset * 3 * mRadius;
        //重新绘制
        invalidate();
    }

    public Indicator(Context context) {
        super(context);
    }


    public Indicator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Indicator);
        mNumber = typedArray.getInteger(R.styleable.Indicator_Indicator_number, mNumber);
        mRadius = typedArray.getInteger(R.styleable.Indicator_Indicator_radius, mRadius);
        mBgColor = typedArray.getColor(R.styleable.Indicator_Indicator_bgColor, mBgColor);
        mForeColor = typedArray.getColor(R.styleable.Indicator_Indicator_foreColor, mForeColor);
        initPaint();
    }

    private void initPaint() {
        mForePaint = new Paint();
        mForePaint.setAntiAlias(true);
        mForePaint.setStyle(Paint.Style.FILL);
        mForePaint.setColor(mForeColor);
        mForePaint.setStrokeWidth(2);

        mBgPaint = new Paint();
        mBgPaint.setAntiAlias(true);
        mBgPaint.setStyle(Paint.Style.STROKE);
        mBgPaint.setColor(mBgColor);
        mBgPaint.setStrokeWidth(2);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < mNumber; i++) {
            canvas.drawCircle(60 + i * mRadius * 3, 60, mRadius, mBgPaint);
        }
        canvas.drawCircle(60 + mOffset, 60, mRadius, mForePaint);

    }


}
