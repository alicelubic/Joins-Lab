package com.example.owlslubic.tabledrelationships;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
        db.execSQL(SQL_DELETE_EMPLOYEES);
        db.execSQL(SQL_DELETE_JOBS);
        onCreate(db);
    }
    //create tables
    private static final String SQL_CREATE_EMPLOYEES = "CREATE TABLE " +
            EMPLOYEE_TABLE_NAME + " (" +
            COL_SSN + " INTEGER PRIMARY KEY, " + //setting the datatype as integer here,
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
    private static final String SQL_DELETE_EMPLOYEES = "DROP TABLE IF EXISTS " + EMPLOYEE_TABLE_NAME;
    private static final String SQL_DELETE_JOBS = "DROP TABLE IF EXISTS " + JOB_TABLE_NAME;

    public static DatabaseHelper getInstance(Context context){
        if (sInstance == null) {
            sInstance = new DatabaseHelper(context);
        }
            return sInstance;
    }

    //insert row to employee table helper method
    public void insertRowEmployeeTable(Employee employee){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_SSN,employee.getmSsn());
        values.put(COL_FIRST_NAME,employee.getmFirst());
        values.put(COL_LAST_NAME,employee.getmLast());
        values.put(COL_YOB,employee.getmYearOfBirth());
        values.put(COL_CITY,employee.getmCity());
        db.insertOrThrow(EMPLOYEE_TABLE_NAME,null,values);
    }
    //insert row to job table helper method
    public void insertRowJobTable(Job job){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_SSN_JOB,job.getmSsn());
        values.put(COL_COMPANY,job.getmCompany());
        values.put(COL_SALARY,job.getmSalary());
        values.put(COL_EXPERIENCE,job.getmExperience());
        db.insertOrThrow(JOB_TABLE_NAME,null,values);

        //do i need to close the db when i do getwritable??
    }


    //create a helper method that makes a cursor to QUERY and retrieve the info
    //dont forget to close the cursor

    //method that queries database and selects fullname of anyone working at macys
    public String getFullNameOfMacysEmployee(){
        SQLiteDatabase db = getReadableDatabase();
        String result = "";
        String query ="SELECT "+COL_FIRST_NAME+", "+COL_LAST_NAME+" FROM "+EMPLOYEE_TABLE_NAME+" JOIN "+JOB_TABLE_NAME+
                " ON "+JOB_TABLE_NAME+"."+COL_SSN_JOB+" = "+EMPLOYEE_TABLE_NAME+"."+COL_SSN+
                " WHERE "+COL_COMPANY+ " LIKE "+"'Macy%'";
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            while(!cursor.isAfterLast()){
                result+=cursor.getString(cursor.getColumnIndex(COL_FIRST_NAME)) + " "+cursor.getString(cursor.getColumnIndex(COL_LAST_NAME));
                cursor.moveToNext();
                //this will return two names in one string, so i need to parse it into an array and use arrayadapter or return a cursor and use cursor adapter
            }
        }
        cursor.close();
        return result;

    }


    //method that queries, selects companies in boston
    public String getBostonCompanies(){
        SQLiteDatabase db = getReadableDatabase();
        String result = "";
        String query = "SELECT "+COL_COMPANY+" FROM "+JOB_TABLE_NAME+" JOIN "+EMPLOYEE_TABLE_NAME+
                " ON "+JOB_TABLE_NAME+"."+COL_SSN_JOB+" = "+EMPLOYEE_TABLE_NAME+"."+COL_SSN+
                " WHERE "+COL_CITY+ " = "+"'Boston'";
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            while(!cursor.isAfterLast()){
                result+=cursor.getString(cursor.getColumnIndex(COL_COMPANY));
                cursor.moveToNext();
            }
        }
        cursor.close();
        return result;
    }
    //
    //method that queries, selects company with highest salary
        //select col_company from jobtable order by salary
        //only take the one at index 0?


    //method that takes dialog input, converts it to a single string string (aka one row), and inserts it into database //might have to break it up into 2 methods?

    //make some unit tests for these methods if you wanna
}

