package com.example.owlslubic.tabledrelationships;

/**
 * Created by owlslubic on 7/15/16.
 */
public class Job {
    private String emp_ssn;
    private String mCompany;
    private int mSalary;
    private int mExperience;

    public Job(String empSSN, String company, int salary, int experience){
        emp_ssn = empSSN;
        mCompany = company;
        mSalary = salary;
        mExperience = experience;
    }

    public String getmSsn() {
        return emp_ssn;
    }

    public void setmSsn(String mSsn) {
        this.emp_ssn = mSsn;
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
