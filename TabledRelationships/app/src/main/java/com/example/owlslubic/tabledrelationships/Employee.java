package com.example.owlslubic.tabledrelationships;

/**
 * Created by owlslubic on 7/15/16.
 */
public class Employee {
    private int mSsn;
    private String mFirst;
    private String mLast;
    private int mYearOfBirth;
    private String mCity;

    public Employee(){}

    public Employee(int ssn, String first, String last, int yob, String city){

        this.mSsn = ssn;
        this.mFirst = first;
        this.mLast = last;
        this.mYearOfBirth = yob;

        this.mCity = city;
    }


    public int getmSsn() {
        return mSsn;
    }

    public void setmSsn(int mSsn) {
        this.mSsn = mSsn;
    }

    public String getFullName() {
        return mFirst + " " + mLast;
    }
    public String getmFirst(){
        return mFirst;
    }

    public void setmFirst(String mFirst) {
        this.mFirst = mFirst;
    }

    public String getmLast() {
        return mLast;
    }

    public void setmLast(String mLast) {
        this.mLast = mLast;
    }

    public int getmYearOfBirth() {
        return mYearOfBirth;
    }

    public void setmYearOfBirth(int mYearOfBirth) {
        this.mYearOfBirth = mYearOfBirth;
    }

    public String getmCity() {
        return mCity;
    }

    public void setmCity(String mCity) {
        this.mCity = mCity;
    }

}
