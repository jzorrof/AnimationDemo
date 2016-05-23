package com.example.fanzhong.animationdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;

import static android.support.v4.view.ViewCompat.animate;

/**
 * Created by fanzhong on 16-5-19.
 */
public class TestButton extends Button {
    public TestButton(Context context) {
        super(context);
        this.setAlpha(1f);
    }

    public TestButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TestButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void ani(){
        int i = -1;
        while (i != -1){

        }

        do {
            
        }while (i == -1);
        animate().translationX(100)
                .alpha(0f)
                .setStartDelay(1000)
                .start();
        invalidate();
    }
}
