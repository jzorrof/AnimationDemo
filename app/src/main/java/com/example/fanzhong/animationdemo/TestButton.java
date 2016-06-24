package com.example.fanzhong.animationdemo;

import android.content.Context;
import android.content.Intent;
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

    private void init(){
    }

    public void ani(){
        Intent intent = new Intent("TESTTEST");
        getContext().sendBroadcast(intent);
    }
}
