package com.example.fanzhong.animationdemo.misc;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by fanzhong on 16-7-15.
 */
public class Tools {

    public final static String TAG = "Fanzhong";
    private final static boolean DEBUG = true;

    public static Bitmap getThumbnail(ActivityManager activityManager, int taskId, Context context) throws NoSuchFieldException, ClassNotFoundException, NoSuchMethodException {

        Log.e(TAG, "test" + ActivityManager.class.getName());
        ActivityManager am = (ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);

//        Field temp = Class.forName(ActivityManager.class.getName()).getDeclaredField("getFrontActivityScreenCompatMode");
        Class<?> cls = Class.forName("android.app.ActivityManager$TaskThumbnail");
        Method method = Class.forName("android.app.ActivityManager").getMethod("getTaskThumbnail", ActivityManager.class);

        return null;

//        ActivityManager.TaskThumbnail taskThumbnail = activityManager.getTaskThumbnail(taskId);
//        if (taskThumbnail == null) {
//            if (DEBUG) {
//                Log.d(TAG, "getThumbnail: getTaskThumbnail is null: " + taskId);
//            }
//            return null;
//        }
//
//        Bitmap thumbnail = taskThumbnail.mainThumbnail;
//        ParcelFileDescriptor descriptor = taskThumbnail.thumbnailFileDescriptor;
//        if (thumbnail == null && descriptor != null) {
//            thumbnail = BitmapFactory.decodeFileDescriptor(descriptor.getFileDescriptor(),
//                    null, sBitmapOptions);
//        }
//        if (descriptor != null) {
//            try {
//                descriptor.close();
//            } catch (IOException e) {
//            }
//        }
//        if (DEBUG && thumbnail == null) {
//            Log.d(TAG, "getThumbnail: thumbnail is null");
//        }
//        return thumbnail;
    }
}
