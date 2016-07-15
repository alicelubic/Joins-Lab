package com.example.owlslubic.tabledrelationships;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by owlslubic on 7/15/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    //constants
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "employees.db";

    public static final String EMPLOYEE_TABLE_NAME = "employee table";
    public static final String COL_SSN = "_id";
    public static final String COL_FIRST_NAME = "First";
    public static final String COL_LAST_NAME = "Last";
    public static final String COL_YOB = "year of birth";
    public static final String COL_CITY = "city";

    public static final String JOB_TABLE_NAME = "job table";
    public static final String COL_SSN_JOB = "_id"; // do i need?
    public static final String COL_COMPANY = "Company";
    public static final String COL_SALARY = "Salary";
    public static final String COL_EXPERIENCE = "Experience";

    private static DatabaseHelper sInstance;

    //constructor
    private DatabaseHelper(Context context){super(context,DATABASE_NAME,null,DATABASE_VERSION);}


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_EMPLOYEES);
        db.execSQL(SQL_CREATE_JOBS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    private static final String SQL_CREATE_EMPLOYEES = "CREATE TABLE " +
            EMPLOYEE_TABLE_NAME + " (" +
            COL_SSN + " INTEGER PRIMARY KEY, " +
            COL_FIRST_NAME + " TEXT, " +
            COL_LAST_NAME + " TEXT, " +
            COL_YOB + " INT, " +
            COL_CITY + " TEXT )";
    private static final String SQL_CREATE_JOBS = "CREATE TABLE " +
            JOB_TABLE_NAME + " ("+
            COL_SSN_JOB + " INTEGER PRIMARY KEY, FOREIGN KEY(" + COL_SSN_JOB +
            ") REFERENCES " + EMPLOYEE_TABLE_NAME + "(" + COL_SSN + ") )" +
            COL_COMPANY + " TEXT, " +
            COL_SALARY + " INT, " +
            COL_EXPERIENCE + " INT )";
}

