package com.example.fanzhong.animationdemo;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;

import java.util.LinkedList;

/**
 * Created by fanzhong on 16-7-7.
 */
public class PackageListAdapter {
    private static final String LOG_TAG = "shy.luo.article.ArticlesAdapter";

    private ContentResolver resolver = null;

    public PackageListAdapter(Context context) {
        resolver = context.getContentResolver();
    }

    public long insertArticle(PackageList2 packageList) {
        ContentValues values = new ContentValues();
        values.put(PackageL.PACKAGE_NAME, packageList.getTitle());

        Uri uri = resolver.insert(PackageL.CONTENT_URI, values);
        String itemId = uri.getPathSegments().get(1);

        return Integer.valueOf(itemId).longValue();
    }

    public boolean updateArticle(PackageList2 packageList) {
        Uri uri = ContentUris.withAppendedId(PackageL.CONTENT_URI, packageList.getId());

        ContentValues values = new ContentValues();
        values.put(PackageL.PACKAGE_NAME, packageList.getTitle());

        int count = resolver.update(uri, values, null, null);

        return count > 0;
    }

    public boolean removeArticle(int id) {
        Uri uri = ContentUris.withAppendedId(PackageL.CONTENT_URI, id);

        int count = resolver.delete(uri, null, null);

        return count > 0;
    }

    public boolean removeArticle(int id, String packageName){
        Uri uri = ContentUris.withAppendedId(PackageL.CONTENT_URI, id);

        int count = resolver.delete(uri, null, null);

        return count > 0;
    }

    public LinkedList<PackageList2> getAllArticles() {
        LinkedList<PackageList2> articles = new LinkedList<PackageList2>();

        String[] projection = new String[] {
                PackageL.ID,
                PackageL.PACKAGE_NAME,
        };

        Cursor cursor = resolver.query(PackageL.CONTENT_URI, projection, null, null, PackageL.DEFAULT_SORT_ORDER);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String title = cursor.getString(1);

                PackageList2 article = new PackageList2(id, title);
                articles.add(article);
            } while(cursor.moveToNext());
        }

        return articles;
    }

//    public int getArticleCount() {
//        int count = 0;
//
//        try {
//            IContentProvider provider = resolver.acquireProvider(Articles.CONTENT_URI);
//            Bundle bundle = provider.call(Articles.METHOD_GET_ITEM_COUNT, null, null);
//            count = bundle.getInt(Articles.KEY_ITEM_COUNT, 0);
//        } catch(RemoteException e) {
//            e.printStackTrace();
//        }
//
//        return count;
//    }

    public PackageList2 getArticleById(int id) {
        Uri uri = ContentUris.withAppendedId(PackageL.CONTENT_URI, id);

        String[] projection = new String[] {
                PackageL.ID,
                PackageL.PACKAGE_NAME,
        };

        Cursor cursor = resolver.query(uri, projection, null, null, PackageL.DEFAULT_SORT_ORDER);

        Log.i(LOG_TAG, "cursor.moveToFirst");

        if (!cursor.moveToFirst()) {
            return null;
        }

        String title = cursor.getString(1);

        return new PackageList2(id, title);
    }

    public PackageList2 getArticleByPos(int pos) {
        Uri uri = ContentUris.withAppendedId(PackageL.CONTENT_POS_URI, pos);

        String[] projection = new String[] {
                PackageL.ID,
                PackageL.PACKAGE_NAME,
        };

        Cursor cursor = resolver.query(uri, projection, null, null, PackageL.DEFAULT_SORT_ORDER);
        if (!cursor.moveToFirst()) {
            return null;
        }

        int id = cursor.getInt(0);
        String title = cursor.getString(1);

        return new PackageList2(id, title);
    }
}
