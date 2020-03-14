package edu.cvtc.solson163.pokemonquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Database extends SQLiteOpenHelper {

    // create database name, table, and columns
    public static final String DATABASE_NAME = "trainer.db";
    public static final String TABLE_NAME = "trainer_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "TRAINER";

    // constructor
    public Database(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    // create database
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, TRAINER TEXT)");
    }

    // so it doesn't create a new table if it already exists
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    // method called in the submit button click event. takes in the player name and trainer type,
    // then adds them to the database table
    public boolean insertData(String name, String trainer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, trainer);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    // method called in the view all button click event. A cursor goes through the database to
    // find the data from the rawQuery, and then can be used in the click event to navigate through
    // the data that is returned.
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }
}
