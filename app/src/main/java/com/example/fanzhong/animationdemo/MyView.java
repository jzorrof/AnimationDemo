package com.example.fanzhong.animationdemo;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by fanzhong on 16-7-13.
 */
public class MyView extends View {

    Rect rect = new Rect();
    Paint mPaint = new Paint();
    RectF mLayout = new RectF();
    RectF mBitmapRectF = new RectF();
    Bitmap bm;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint.setColor(Color.RED);
        mPaint.setFilterBitmap(true);
        mPaint.setAntiAlias(true);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MyView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
//        mPaint.setColorFilter(mLightingColorFilter);
        mPaint.setColor(Color.RED);
        mPaint.setFilterBitmap(true);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int minw = getPaddingLeft() + getPaddingRight();
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int minh = getPaddingBottom() + getPaddingTop();

        int w = Math.max(minw, width);
        int h = Math.max(minh, height);
        setMeasuredDimension(w, h);

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRoundRect(10, 10, getWidth(), getHeight(),
                10,
                10, mPaint);
    }
}
