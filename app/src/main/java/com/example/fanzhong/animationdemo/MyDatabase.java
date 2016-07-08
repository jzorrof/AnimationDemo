package com.example.fanzhong.animationdemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fanzhong on 16-6-28.
 */
public class MyDatabase extends SQLiteOpenHelper{
    static final String DATABASE_NAME = "my.db";
    static final int DATABASE_VERSION = 1;
    static final String PACKAGE_TABLE_NAME = "packagelist";
    static final String Package_Key="packagekey";
    static final String Id = "_id";
    static final String Package_Name="packagename";

//    public static final class PackageList implements BaseColumns {
//        private PackageList(){};
//        static final String id = "_id";
//        static final String Package_ID="packageid";
//        static final String Package_Name="packagename";
//    }


        public MyDatabase(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + PACKAGE_TABLE_NAME + " ("
                    + Id + " INTEGER PRIMARY KEY,"
                    + Package_Key + " TEXT,"
                    + Package_Name + " TEXT"
                    + " );"
            );
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + PACKAGE_TABLE_NAME);
            onCreate(db);
        }

    void addPackageName(PackageList packageList) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Package_Key, packageList.getPackageKey()); // Contact Name
        values.put(Package_Name, packageList.getPackageName()); // Contact Phone

        // Inserting Row
        db.insert(PACKAGE_TABLE_NAME, null, values);
        db.close(); // Closing database connection
    }

        public List<PackageList> getAllPackage() {
            List<PackageList> packageLists = new ArrayList<PackageList>();
            // Select All Query
            String selectQuery = "SELECT  * FROM " + PACKAGE_TABLE_NAME;

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);

            // looping through all rows and adding to list
            if (cursor.moveToFirst()) {
                do {
                    PackageList packageList = new PackageList();
                    packageList.setId(Integer.parseInt(cursor.getString(0)));
                    packageList.setPackageKey(cursor.getString(1));
                    packageList.setPackageName(cursor.getString(2));
                    // Adding contact to list
                    packageLists.add(packageList);
                } while (cursor.moveToNext());
            }

            // return contact list
            return packageLists;
        }

        public void deletePackageList(PackageList packageList){
            SQLiteDatabase db = this.getWritableDatabase();
            db.delete(PACKAGE_TABLE_NAME, Id + " = ?",
                    new String[] { String.valueOf(packageList.getId()) });
            db.close();
        }

        public int updatePackageList(PackageList packageList){
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(Package_Name, packageList.getPackageName());
            values.put(Package_Key, packageList.getPackageKey());

            // updating row
            return db.update(PACKAGE_TABLE_NAME, values, Id + " = ?",
                    new String[] { String.valueOf(packageList.getId()) });
        }


        // Getting contacts Count
        public int getPackageCount() {
            String countQuery = "SELECT  * FROM " + PACKAGE_TABLE_NAME;
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery(countQuery, null);
            cursor.close();

            // return count
            return cursor.getCount();
        }
}
