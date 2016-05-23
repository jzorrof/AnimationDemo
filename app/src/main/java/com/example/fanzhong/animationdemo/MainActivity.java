package com.example.fanzhong.animationdemo;

import android.animation.Animator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;


import java.util.ArrayList;
import java.util.List;

import static android.support.v4.view.ViewCompat.animate;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ArrayList<TestButton> btgroup;
    TestButton testBT;
    TestButton testBT2;
    TestButton testBT3;
    Animation animator = null;
    Animation animator2 = null;
    Animation animator3 = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        btgroup = new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animator = AnimationUtils.loadAnimation(this, R.anim.test_interpolator);
        animator2 = AnimationUtils.loadAnimation(this, R.anim.test_interpolator2);
        animator3 = AnimationUtils.loadAnimation(this, R.anim.test_interpolator3);
        testBT = (TestButton) findViewById(R.id.test_bt);
        testBT2 = (TestButton) findViewById(R.id.test_bt2);
        testBT3 = (TestButton) findViewById(R.id.test_bt3);
        testBT.setOnClickListener(this);
        testBT2.setOnClickListener(this);
        testBT3.setOnClickListener(this);
        animator.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

        animator2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

        animator3.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
//        TestButton();

    }
//
//    public void TestButton(){
//        testBT.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                testBT.setText("CLICK");
//                testBT.startAnimation(animator);
//            }
//        });
//    }
//


    @Override
    protected void onDestroy() {
        super.onDestroy();
        testBT.setOnClickListener(null);
        testBT2.setOnClickListener(null);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View v) {
        if(v == testBT){
            testBT.setText("CLICK");
            testBT.startAnimation(animator);
            Log.e("Fanzhong","click");
        } else if(v == testBT2){
            testBT2.setText("click");
            testBT2.startAnimation(animator2);
        } else if(v == testBT3){
            testBT2.setText("click");
            testBT3.startAnimation(animator3);
        }
    }
}
