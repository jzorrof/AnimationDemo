package com.example.fanzhong.animationdemo;

/**
 * Created by fanzhong on 16-6-30.
 */
public class PackageList {
    int id;
    String packageName;
    String packageKey;

    public PackageList(){}

    public PackageList(int _id, String _pacakageName, String packageKey){
        id = _id;
        packageName = _pacakageName;
        packageKey = packageKey;
    }

    public PackageList(String _pacakageName, String _packageKey){
        packageName = _pacakageName;
        packageKey = _packageKey;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int _id){
        this.id = _id;
    }

    public String getPackageName(){
        return this.packageName;
    }

    public void setPackageName(String _packageName){
        this.packageName = _packageName;
    }

    public String getPackageKey(){
        return this.packageKey;
    }

    public void setPackageKey(String _packageKey){
        this.packageKey = _packageKey;
    }
}
