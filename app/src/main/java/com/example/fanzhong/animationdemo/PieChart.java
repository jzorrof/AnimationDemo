package com.example.fanzhong.animationdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by fanzhong on 16-5-24.
 */
public class PieChart extends View {
    private boolean mIsText;
    private int mLabelPosition;
    public PieChart(Context context) {
        super(context);
    }

    public PieChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.PieChart,
                0,0);
        try {


        mIsText = a.getBoolean(R.styleable.PieChart_isShowText, false);
        mLabelPosition = a.getInteger(R.styleable.PieChart_labelPosition, 0);
        } finally {
            a.recycle();
        }


    }

    public boolean isShowText(){
        return mIsText;
    }

    public void setShowText(boolean isText){
        mIsText = isText;
        invalidate();
        requestLayout();
    }

    public PieChart(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
