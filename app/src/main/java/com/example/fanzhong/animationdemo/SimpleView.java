package com.example.fanzhong.animationdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;

/**
 * Created by fanzhong on 16-7-1.
 */
public class SimpleView extends View implements View.OnClickListener {

    private Paint mPaint;

    private Rect mBounds;

    private int mCount;

    private Context mContext;
    public SimpleView(Context context, AttributeSet attrs) {
        super(context);
        mContext = context;
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBounds = new Rect();
        setOnClickListener(this);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.RED);
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
        mPaint.setColor(Color.YELLOW);
        mPaint.setTextSize(30);
        String text = String.valueOf(mCount);
        mPaint.getTextBounds(text, 0, text.length(), mBounds);
        float textWidth = mBounds.width();
        float textHeight = mBounds.height();
        canvas.drawText(text, getWidth() / 2 - textWidth / 2, getHeight() / 2
                + textHeight / 2, mPaint);
    }

    @Override
    public void onClick(View v) {
        mCount = mCount + 10000;
        this.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.test_reroll));
        invalidate();
    }
    public interface Callback {

        boolean canChildBeDismissed(View v);

        void onBeginDrag(View v);

        void onSwipeChanged(View v, float delta);

        void onChildDismissed(View v);

        void onSnapBackCompleted(View v);

        void onDragCancelled(View v);
    }
}
