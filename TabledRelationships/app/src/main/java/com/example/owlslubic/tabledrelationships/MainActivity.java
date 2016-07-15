package com.example.owlslubic.tabledrelationships;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ListView mListView;
    TextView mTextViewHighestSalary;
    Button mButtonAddData, mButtonSameCompany, mButtonBoston, mButtonHighestSalary;
    DatabaseHelper mInstance = DatabaseHelper.getInstance(MainActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.listview);
        mTextViewHighestSalary = (TextView) findViewById(R.id.textview);
        mButtonAddData = (Button) findViewById(R.id.button_add_data);
        mButtonSameCompany = (Button) findViewById(R.id.button_same_company);
        mButtonBoston = (Button) findViewById(R.id.button_boston);
        mButtonHighestSalary = (Button) findViewById(R.id.button_salary);
        //set onclicklisteners for buttons, add toasts
        //add button will use the helper method below to add data to empty database
        //other buttons set listview/textview to whatever the query turns up






        //make a helper method that inserts alreadyknown the table data
        //this is where i will call a helper instance
        //instantiate some employees and jobs
        // then insert them into tables using my helper methods
        //and use other helper methods to set the list and textview


        //set up fab with dialog here - ref mainlistsactivity of proj1
        //input will be inserted to employee table via helper method







    }
}
