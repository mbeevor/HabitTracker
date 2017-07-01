package com.example.android.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.android.habittracker.data.HabitContract.HabitEntry;
import com.example.android.habittracker.data.HabitDatabaseHelper;


public class MainActivity extends AppCompatActivity {

    // create database helper
    private HabitDatabaseHelper habitHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        habitHelper = new HabitDatabaseHelper(this);
        insertHabit();
        readAllHabits();
    }

    // method for displaying list of habits and number of times completed (frequency)
    private Cursor readAllHabits() {

        //create or open database to read from
        SQLiteDatabase sqLiteDatabase = habitHelper.getReadableDatabase();

        // create string of habits to display
        String[] projection = {
                HabitEntry._ID,
                HabitEntry.COLUMN_HABIT_NAME,
                HabitEntry.COLUMN_HABIT_FREQUENCY
        };

        // Complete SQL request "SELECT * FROM habits"
        Cursor cursor = sqLiteDatabase.query(HabitEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);

        TextView displayView = (TextView) findViewById(R.id.text_view_habit);

        try {

            // create header for table displayed
            // iterate through each row in table and show results
            displayView.setText(HabitEntry._ID + " -- " +
                    HabitEntry.COLUMN_HABIT_NAME + " -- " +
                    HabitEntry.COLUMN_HABIT_FREQUENCY + "\n");

            int idColumnIndex = cursor.getColumnIndex(HabitEntry._ID);
            int habitNameColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_NAME);
            int habitFrequencyIndex = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_FREQUENCY);

            while (cursor.moveToNext()) {
                // extract values from current entry and display as new row
                int currentID = cursor.getInt(idColumnIndex);
                String currentHabitName = cursor.getString(habitNameColumnIndex);
                int currentFrequency = cursor.getInt(habitFrequencyIndex);

                displayView.append(("\n" + currentID + " -- " +
                        currentHabitName + " -- " +
                        currentFrequency));
            }
        } finally {
            // close the cursor to save resources
            cursor.close();
        }
        return cursor;
    }
    // method for creating and editing a habit
    private void insertHabit() {

        // set database to write mode
        SQLiteDatabase sqLiteDatabase = habitHelper.getWritableDatabase();

        // Create a ContentValues object to match keys to values
        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_HABIT_NAME, "habit name");
        values.put(HabitEntry.COLUMN_HABIT_FREQUENCY, 1);

    }

}
