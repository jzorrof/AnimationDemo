package com.example.fanzhong.animationdemo;

import android.animation.Animator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import static android.support.v4.view.ViewCompat.animate;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener{
    ArrayList<TestButton> btgroup;
    TestButton testBT;
    TestButton testBT2;
    TestButton testBT3;
    Button testBt1;
    ViewGroup mRrootLayout;
    private int _xDelta;
    private int _yDelta;
    Animation animator = null;
    Animation animator2 = null;
    Animation animator3 = null;
    Animation animator4 = null;
    Animation animator5 = null;
    int screenWidth;
    int screenHeight;
    int lastX;
    int lastY;
    ImageView test = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        btgroup = new ArrayList<>();
        super.onCreate(savedInstanceState);
        MyDatabase myDatabase = new MyDatabase(this);
        myDatabase.addPackageName(new PackageList("com.android.abcd","1234"));
        myDatabase.addPackageName(new PackageList("com.android.abce","1234"));
        myDatabase.addPackageName(new PackageList("com.android.abce","1234"));
        SimpleView sv = (SimpleView) findViewById(R.id.sv_1);

        Log.d("Reading: ", "Reading all contacts..");
        List<PackageList> contacts = myDatabase.getAllPackage();
        for(PackageList p: contacts ){
            Log.d("Reading: ", "PackageName: " + p.getPackageName() + " PackageKey: " + p.getPackageKey());
        }


        setContentView(R.layout.activity_main);
        String a = android.provider.Settings.Global.getString(this.getContentResolver(), "custom_launcher");
        animator = AnimationUtils.loadAnimation(this, R.anim.test_interpolator);
        animator2 = AnimationUtils.loadAnimation(this, R.anim.test_interpolator2);
        animator3 = AnimationUtils.loadAnimation(this, R.anim.test_interpolator3);
        animator4 = AnimationUtils.loadAnimation(this, R.anim.test_roll);
        animator5 = AnimationUtils.loadAnimation(this, R.anim.test_reroll);

        test = (ImageView) findViewById(R.id.imageView);
        if (test != null) {
            test.setImageAlpha(0);
        }
        testBT = (TestButton) findViewById(R.id.test_bt);
        testBt1 = (Button)findViewById(R.id.test_bt1);
        testBT2 = (TestButton) findViewById(R.id.test_bt2);
        testBt1.setOnTouchListener(this);
        testBT.setOnTouchListener(this);
        //testBT3 = (TestButton) findViewById(R.id.test_bt3);
        testBT.setOnClickListener(this);
        testBT2.setOnClickListener(this);
        mRrootLayout = (ViewGroup) findViewById(R.id.root);
//        testBT3.setOnClickListener(this);
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
        animator4.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                test.setImageAlpha(255);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                test.setImageAlpha(0);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

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

    String packageName;
    @Override
    public void onClick(View v) {
        if(v == testBT2) {
            test.setImageAlpha(255);
            test.startAnimation(animator4);
            Intent intent = new Intent();
            intent.setAction("");
            intent.putExtra("packageName",packageName);
            sendBroadcast(intent);
            testBT2.ani();
            Log.e("Fanzhong", "click");
        }
        final Intent intent = new Intent();

        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                intent.setAction("");
                intent.putExtra("packageName",packageName);
                sendBroadcast(intent);
            }
        };
//        } else if(v == testBT2) {
//            testBT2.setText("click");
//            testBT2.startAnimation(animator3);
//        }
//        } else if(v == testBT3){
//            testBT2.setText("click");
//            testBT3.startAnimation(animator3);
//        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        final int X = (int) event.getRawX();
        final int Y = (int) event.getRawY();
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) v.getLayoutParams();
                _xDelta = X - lParams.leftMargin;
                _yDelta = Y - lParams.topMargin;
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                break;
            case MotionEvent.ACTION_POINTER_UP:
                break;
            case MotionEvent.ACTION_MOVE:
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) v
                        .getLayoutParams();
                layoutParams.leftMargin = X - _xDelta;
                layoutParams.topMargin = Y - _yDelta;
                layoutParams.rightMargin = -250;
                layoutParams.bottomMargin = -250;
                v.setLayoutParams(layoutParams);
                break;
        }
        mRrootLayout.invalidate();
        return false;
    }
}

