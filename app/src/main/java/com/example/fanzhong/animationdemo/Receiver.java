package com.example.fanzhong.animationdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        CharSequence string="收到信息";
        Toast.makeText(context, string, Toast.LENGTH_LONG).show();
    }
}
