package com.example.codingtest;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "sabakDairy";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "stuDairy";
    private static final String ID_COL = "id";
    private static final String SABAKCOUNT = "astagfarcount";
    private static final String SABAKICOUNT = "daroodcount";
    private static final String MANZILCOUNT = "kalmacount";
    private static final String INCORRECT = "count";

    public DbHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + SABAKCOUNT + " INTEGER, "
                + SABAKICOUNT + " INTEGER, "
                + MANZILCOUNT + " INTEGER, "
                + INCORRECT + " INTEGER)";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // this method is use to add new count to our sqlite database.
    public void addCount(Integer SabakCount, Integer SabakiCount, Integer ManzilCount, Integer Incorrect) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(String.valueOf(SABAKCOUNT), SabakCount);
        values.put(String.valueOf(SABAKICOUNT), SabakiCount);
        values.put(String.valueOf(MANZILCOUNT), ManzilCount);
        values.put(String.valueOf(INCORRECT),Incorrect );
        db.insert(TABLE_NAME, null, values);

       db.close();
    }

    public Boolean upgrade (String ID_COL,String SabakCount, String SabakiCount, String ManzilCount, String Incorrect) {




        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(String.valueOf(SABAKCOUNT), SabakCount);
        values.put(String.valueOf(SABAKICOUNT), SabakiCount);
        values.put(String.valueOf(MANZILCOUNT), ManzilCount);
        values.put(String.valueOf(INCORRECT),Incorrect );
        db.insert(TABLE_NAME, null, values);
        //db.update(TABLE_NAME,values,"ID_COL=?",new String[]{String.valueOf(ID_COL)});
        db.close();
        return Boolean.TRUE;
    }
}