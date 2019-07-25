package com.example.appteste002.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "hora_remedios";
    private static final String TABLE_NAME = "hora_remedios";
    private static final String COL_1 = "_id";
    private static final String COL_2 = "remedio";
    private static final String COL_3 = "hora";
    private static int VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE hora_remedios (_id INTEGER PRIMARY KEY AUTOINCREMENT, remedio TEXT, hora TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean inserirData(String remedio, String hora){
        SQLiteDatabase mSQLiteDatabase = this.getWritableDatabase();
        ContentValues mContentValues = new ContentValues();
        mContentValues.put(COL_2, remedio);
        mContentValues.put(COL_3, hora);
        long resultado = mSQLiteDatabase.insert(TABLE_NAME, null, mContentValues);
        if (resultado == -1){
            return false;
        } else {
            return true;
        }
    }

    public Cursor pegarDados(){
        SQLiteDatabase mSQLiteDatabase = this.getWritableDatabase();
        Cursor res = mSQLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME, null);
        return res;
    }


}
