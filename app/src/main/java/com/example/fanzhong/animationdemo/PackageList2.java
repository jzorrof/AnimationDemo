package com.example.fanzhong.animationdemo;

/**
 * Created by fanzhong on 16-7-7.
 */
public class PackageList2 {
    private int id;
    private String title;

    public PackageList2(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }
}
