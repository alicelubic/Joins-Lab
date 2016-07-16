package com.example.owlslubic.tabledrelationships;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView mListView;
    TextView mTextViewHighestSalary;
    Button mButtonAddData, mButtonSameCompany, mButtonBoston, mButtonHighestSalary;
    DatabaseHelper helper = DatabaseHelper.getInstance(MainActivity.this);
    private Context context = this;

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

        mButtonAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //helper.populateTable();
                Toast.makeText(MainActivity.this, "Data added!", Toast.LENGTH_SHORT).show();
            }
        });
        mButtonSameCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getFullNameOfMacysEmployees()
            }
        });
        mButtonBoston.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getBostonCompanies()
            }
        });
        mButtonHighestSalary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //textView.setText(getHighestSalary()

            }
        });


        //make a helper method that inserts alreadyknown the table data
        //populateTable()

        //this is where i will call a helper instance
        //instantiate some employees and jobs
        // then insert them into tables using my helper methods
        //and use other helper methods to set the list and textview


        //set up fab with dialog here - ref mainlistsactivity of proj1
        //input will be inserted to employee table via helper method



        FloatingActionButton fabMain = (FloatingActionButton) findViewById(R.id.fab_main);
        fabMain.setOnClickListener(new View.OnClickListener() {

//            @Override
//            public void onClick(View view) {
//                LayoutInflater inflater = LayoutInflater.from(context);
//                View dialogLayout = inflater.inflate(R.layout.dialog_alert,null);
//                AlertDialog.Builder builder = new AlertDialog.Builder(context);
//                builder.setView(dialogLayout);
//                EditText edittext1 = (EditText) findViewById(R.id.edittext1);
//                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int i) {
//                        dialog.dismiss();
//                    }
//                });
//                builder.setPositiveButton("Add data", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int i) {
//
//                    }
//                });
//
//            }
                //above shit dont work, below shit did but only one edittext...

//            @Override
//            public void onClick(View view) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                final EditText input1 = new EditText(MainActivity.this);
//                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
//                        LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
//                input1.setLayoutParams(lp);
//                builder.setView(input1);
//                builder.setPositiveButton("ok", null);
//                builder.setNegativeButton("cancel", null);
//
//                builder.setTitle("");
//                final AlertDialog dialog = builder.create();
//                dialog.show();
//
//                dialog.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        if (input1.getText().toString().length() == 0) {
//                            input1.setError("Name your list!");
//                        } else {
//
//                            //adapter.notifyDataSetChanged();
//                            dialog.dismiss();
//                        }
//                    }
//                });
//                dialog.getButton(DialogInterface.BUTTON_NEGATIVE).setOnClickListener(new View.OnClickListener() {
//                    @Override
//
//                    public void onClick(View view) {
//                        dialog.dismiss();
//                    }
//                });

//
//            }
});
}}



