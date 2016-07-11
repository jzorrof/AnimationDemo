package com.example.fanzhong.animationdemo;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.util.Log;

import java.util.LinkedList;


/**
 * Created by fanzhong on 16-7-11.
 */
public class TestObserver extends ContentObserver {

    private PackageListAdapter aa;
    private Handler mHandler;
    private static int MSG_SEND_PACKAGE = 1;

    /**
     * Creates a content observer.
     *
     * @param handler The handler to run {@link #onChange} on, or null if none.
     */
    public TestObserver(Context context, Handler handler) {
        super(handler);
        mHandler = handler;
        aa = new PackageListAdapter(context);
    }

    @Override
    public void onChange(boolean selfChange) {
        super.onChange(selfChange);
        PackageList2 pls2 = null;
        LinkedList<PackageList2> list = aa.getAllArticles();
        for(PackageList2 mpls2 : list){
            pls2 = mpls2;
            Log.e("Fanzhong", "pls2: " + pls2.getTitle());
        }
        mHandler.obtainMessage(MSG_SEND_PACKAGE, pls2.getTitle()).sendToTarget();

    }
}
