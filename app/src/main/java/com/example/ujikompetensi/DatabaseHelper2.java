package com.example.ujikompetensi;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

 class DatabaseHelper2 extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "User.db";
    public static final String TABLE_NAME = "user_table";
    public static final String COL_1 = "NOMOR";
    public static final String COL_2 = "NAMA";
    public static final String COL_3 = "TANGGAL_LAHIR";
    public static final String COL_4 = "JENIS_KELAMIN";
    public static final String COL_5 = "ALAMAT";

    public DatabaseHelper2(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, EMAIL TEXT, PASSWORD TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insert(String nomor, String nama, String tanggallahir, String jeniskelamin, String alamat ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, nomor);
        contentValues.put(COL_2, nama);
        contentValues.put(COL_3, tanggallahir);
        contentValues.put(COL_4, jeniskelamin);
        contentValues.put(COL_5, alamat);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }
}

