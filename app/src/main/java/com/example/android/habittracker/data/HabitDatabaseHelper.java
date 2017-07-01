package com.example.android.habittracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.habittracker.data.HabitContract.HabitEntry;

/**
 * Created by Matthew on 01/07/2017.
 */

public class HabitDatabaseHelper extends SQLiteOpenHelper {

    // Name of the database
    private static final String DATABASE_NAME = "habits.db";

    // Database version
    private static final int DATABASE_VERSION = 1;

    // Constructor for creating a new instance of HabitDataBaseAdapter
    public HabitDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // method to implement when database is first created
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_HABIT_TABLE = "CREATE TABLE" + HabitEntry.TABLE_NAME + " ("
                + HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitEntry.COLUMN_HABIT_NAME + " TEXT NOT NULL, "
                + HabitEntry.COLUMN_HABIT_FREQUENCY + " INTEGER NOT NULL DEFAULT 1);";

        // Execute String statement
        sqLiteDatabase.execSQL(SQL_CREATE_HABIT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        // not required at this stage

    }
}
