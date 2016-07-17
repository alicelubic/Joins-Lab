package com.example.owlslubic.tabledrelationships;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

/**
 * Created by owlslubic on 7/15/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    //constants
    public static final int DATABASE_VERSION = 9;
    public static final String DATABASE_NAME = "employees.db";

    public static final String EMPLOYEE_TABLE_NAME = "employee";
   // public static final String COL_PK_ID = "_id";
    public static final String COL_SSN = "_id";
    public static final String COL_FIRST_NAME = "First";
    public static final String COL_LAST_NAME = "Last";
    public static final String COL_YOB = "year";
    public static final String COL_CITY = "city";

    public static final String JOB_TABLE_NAME = "jobtable";
    public static final String COL_ID_JOB = "_id";
    public static final String COL_SSN_JOB = "jobssn"; //
    public static final String COL_COMPANY = "Company";
    public static final String COL_SALARY = "Salary";
    public static final String COL_EXPERIENCE = "Experience";
    public static final String COL_EMP_SSN = "empSSN";

    private static DatabaseHelper sInstance;

    //constructor
    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


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
      //      COL_PK_ID+" INTEGER, "+
            COL_SSN + " TEXT PRIMARY KEY, "+
            COL_FIRST_NAME + " TEXT," +
            COL_LAST_NAME + " TEXT," +
            COL_YOB + " INTEGER," +
            COL_CITY + " TEXT"+")";
    private static final String SQL_CREATE_JOBS = "CREATE TABLE " +
            JOB_TABLE_NAME + " (" +
            COL_ID_JOB + " INTEGER PRIMARY KEY, " +
            COL_COMPANY + " TEXT, " +
            COL_SALARY + " INTEGER, " +
            COL_EXPERIENCE + " INTEGER," +
            "FOREIGN KEY(" + COL_EMP_SSN +") REFERENCES " +
            EMPLOYEE_TABLE_NAME + "(" + COL_SSN + ") )";
    private static final String SQL_DELETE_EMPLOYEES = "DROP TABLE IF EXISTS " + EMPLOYEE_TABLE_NAME;
    private static final String SQL_DELETE_JOBS = "DROP TABLE IF EXISTS " + JOB_TABLE_NAME;

    public static DatabaseHelper getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new DatabaseHelper(context);
        }
        return sInstance;
    }


    public void insertRowEmployeeTable(Employee employee) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_SSN, employee.getmSsn());
        values.put(COL_FIRST_NAME, employee.getmFirst());
        values.put(COL_LAST_NAME, employee.getmLast());
        values.put(COL_YOB, employee.getmYearOfBirth());
        values.put(COL_CITY, employee.getmCity());
        db.insertOrThrow(EMPLOYEE_TABLE_NAME, null, values);
        db.close();
    }

    //insert row to job table helper method
    public void insertRowJobTable(Job job) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
      //  values.put(COL_SSN_JOB, job.getmSsn());
        values.put(COL_COMPANY, job.getmCompany());
        values.put(COL_SALARY, job.getmSalary());
        values.put(COL_EXPERIENCE, job.getmExperience());
        values.put(COL_EMP_SSN,job.getmSsn());
        db.insertOrThrow(JOB_TABLE_NAME, null, values);
        db.close();

    }

    //method that queries database and selects fullname of anyone working at macys
    public Cursor getFullNameOfMacysEmployee() {
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT " + COL_FIRST_NAME + ", " + COL_LAST_NAME + " FROM " + EMPLOYEE_TABLE_NAME + " JOIN " + JOB_TABLE_NAME +
                " ON " + JOB_TABLE_NAME + "." + COL_SSN_JOB + " = " + EMPLOYEE_TABLE_NAME + "." + COL_SSN +
                " WHERE " + COL_COMPANY + " LIKE 'Macy%'";
        Cursor cursor = db.rawQuery(query, null);
        cursor.close();
        return cursor;
    }


    //method that queries, selects companies in boston
    public Cursor getBostonCompanies() {
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT " + COL_COMPANY + " FROM " + JOB_TABLE_NAME + " JOIN " + EMPLOYEE_TABLE_NAME +
                " ON " + JOB_TABLE_NAME + "." + COL_SSN_JOB + " = " + EMPLOYEE_TABLE_NAME + "." + COL_SSN +
                " WHERE " + COL_CITY + " LIKE 'Boston'";
        Cursor cursor = db.rawQuery(query, null);
        cursor.close();
        return cursor;
    }
    //
    //method that queries, selects company with highest salary
    public String getHighestSalary(){
        SQLiteDatabase db = getReadableDatabase();
        String result = "";
        String query = "SELECT "+COL_COMPANY+" FROM "+JOB_TABLE_NAME+
                " WHERE "+COL_SALARY+" = (SELECT MAX("+COL_SALARY+") FROM "+JOB_TABLE_NAME+")";
//        String query = "SELECT "+COL_COMPANY+" FROM "+JOB_TABLE_NAME+" JOIN "+EMPLOYEE_TABLE_NAME+
//                " ON "+JOB_TABLE_NAME+"."+COL_SSN_JOB+" = "+EMPLOYEE_TABLE_NAME+"."+COL_SSN+
//                " ORDER BY "+ COL_SALARY + " DESC";
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            while(!cursor.isAfterLast()){
                result+=cursor.getString(cursor.getColumnIndex(COL_COMPANY));
                cursor.moveToNext();
            }
        }
        cursor.close();
        return result;

//        Cursor cursor = db.query(JOB_TABLE_NAME,new String[]{COL_COMPANY},null,null,null,null,COL_SALARY + " DESC");
//        cursor.close();
//        return cursor;
    }



}

