package com.example.android.habittracker.data;

import android.provider.BaseColumns;

/**
 * Created by Matthew on 01/07/2017.
 */

public class HabitContract {

    // Empty constructor to prevent accidental initiation
    private HabitContract() {

    }

    /**
     * Inner Class for the constant values for the habits database
     * Each item represents a habit
     */
    public static final class HabitEntry implements BaseColumns {

        // database name
        public final static String TABLE_NAME = "Habits";

        // ID number for each habit
        public static final String _ID = BaseColumns._ID;

        // Name of the babit
        public static final String COLUMN_HABIT_NAME = "habit_name";

        // Frequency of completing the habit
        public static final String COLUMN_HABIT_FREQUENCY = "frequency";

    }

}
