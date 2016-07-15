package com.example.owlslubic.tabledrelationships;

/**
 * Created by owlslubic on 7/15/16.
 */
public class Job {
    private int mSsn;
    private String mCompany;
    private int mSalary;
    private int mExperience;

    public Job(int ssn, String company, int salary, int experience){
        mSsn = ssn;
        mCompany = company;
        mSalary = salary;
        mExperience = experience;
    }

    public int getmSsn() {
        return mSsn;
    }

    public void setmSsn(int mSsn) {
        this.mSsn = mSsn;
    }

    public String getmCompany() {
        return mCompany;
    }

    public void setmCompany(String mCompany) {
        this.mCompany = mCompany;
    }

    public int getmSalary() {
        return mSalary;
    }

    public void setmSalary(int mSalary) {
        this.mSalary = mSalary;
    }

    public int getmExperience() {
        return mExperience;
    }

    public void setmExperience(int mExperience) {
        this.mExperience = mExperience;
    }
}
