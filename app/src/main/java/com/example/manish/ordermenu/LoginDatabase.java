package com.example.manish.ordermenu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LoginDatabase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "LOGIN DATABASE.db";
    public static final String TABLE_NAME = "LoginIds";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "USERNAME";
    public static final String COL_3 = "PASSWORD";
    public static final String COL_4 = "NAME";

    public LoginDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (INTEGER ID PRIMARY KEY AUTOINCREMENT , USERNAME TEXT , PASSWORD TEXT , NAME TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean createID (String username, String password, String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contents = new ContentValues();
        contents.put(COL_1,username);
        contents.put(COL_2,password);
        contents.put(COL_3,name);
        long res = db.insert(TABLE_NAME,null,contents);
        if(res == -1)
            return false;
        else
            return true;
    }

    public Cursor getData () {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME,null);
        return res;
    }

}
