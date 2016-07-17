package com.example.owlslubic.tabledrelationships;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        final DatabaseHelper helper = DatabaseHelper.getInstance(this);


        mButtonAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addData();
                Toast.makeText(MainActivity.this, "Data added!", Toast.LENGTH_SHORT).show();
            }
        });
        mButtonSameCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DatabaseHelper helper = DatabaseHelper.getInstance(MainActivity.this);
                Cursor cursor = helper.getFullNameOfMacysEmployee();
                CursorAdapter adapter = new CursorAdapter(MainActivity.this,cursor,CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER){

                    @Override
                    public View newView(Context context, Cursor cursor, ViewGroup parent) {
                        return LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1,parent,false);
                    }

                    @Override
                    public void bindView(View view, Context context, Cursor cursor) {
                        TextView textView = (TextView) view.findViewById(android.R.id.text1);
                        String firstName = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_FIRST_NAME));
                        String lastName = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_LAST_NAME));
                        String fullName = firstName + " "+lastName + " ";
                        textView.setText(fullName);
                    }
                };

                mListView.setAdapter(adapter);

            }
        });
        mButtonBoston.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DatabaseHelper helper = DatabaseHelper.getInstance(MainActivity.this);
                Cursor cursor = helper.getBostonCompanies();
                CursorAdapter adapter = new CursorAdapter(MainActivity.this,cursor,CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER){

                    @Override
                    public View newView(Context context, Cursor cursor, ViewGroup parent) {
                        return LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1,parent,false);
                    }

                    @Override
                    public void bindView(View view, Context context, Cursor cursor) {
                        TextView textView = (TextView) view.findViewById(android.R.id.text1);
                        textView.setText(cursor.getString(cursor.getColumnIndex(helper.COL_COMPANY)));
                    }
                };

                mListView.setAdapter(adapter);
            }
        });
        mButtonHighestSalary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper helper = DatabaseHelper.getInstance(MainActivity.this);
                TextView textView = (TextView) findViewById(R.id.textview);
                String result = helper.getHighestSalary();
                textView.setText(result);

            }
        });


        FloatingActionButton fabMain = (FloatingActionButton) findViewById(R.id.fab_main);
        fabMain.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                LayoutInflater inflater = LayoutInflater.from(context);
                View dialogLayout = inflater.inflate(R.layout.dialog_alert, null);
                builder.setView(dialogLayout);

                final EditText edittext1 = (EditText) findViewById(R.id.edittext1);
                final EditText edittext2 = (EditText) findViewById(R.id.edittext2);
                final EditText edittext3 = (EditText) findViewById(R.id.edittext3);
                final EditText edittext4 = (EditText) findViewById(R.id.edittext4);
                final EditText edittext5 = (EditText) findViewById(R.id.edittext5);


                builder.setTitle("Add New Employee");

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });
                builder.setPositiveButton("Add data", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                    }
                });
                final AlertDialog dialog = builder.create();
                dialog.show();

                //problem here with the "employee" part
//                final Employee employee = new Employee();
//                dialog.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Toast.makeText(MainActivity.this, "Somethin' happened!", Toast.LENGTH_SHORT).show();
//                        if (edittext1.getText().toString().length() == 0) { //Attempt to invoke virtual method 'android.text.Editable android.widget.EditText.getText()' on a null object reference
//                            edittext1.setError("Please type in your SSN");
//                        } else if (edittext2.getText().toString().length() == 0) {
//                            edittext2.setError("Please type in your first name");
//                        } else if (edittext3.getText().toString().length() == 0) {
//                            edittext3.setError("Please type in your last name");
//                        } else if (edittext4.getText().toString().length() == 0) {
//                            edittext4.setError("Please type in your year of birth");
//                        } else if (edittext5.getText().toString().length() == 0) {
//                            edittext5.setError("Please type in your city");
//                        } else {
//                          //  employee.setmSsn(Integer.parseInt(edittext1.getText().toString()));
//                            employee.setmFirst(edittext2.getText().toString());
//                            employee.setmLast(edittext3.getText().toString());
//                            employee.setmYearOfBirth(Integer.parseInt(edittext4.getText().toString()));
//                            employee.setmCity(edittext5.getText().toString());
//
//                            dialog.dismiss();
//                        }
//                    }
//                });

                dialog.getButton(DialogInterface.BUTTON_NEGATIVE).setOnClickListener(new View.OnClickListener() {
                    @Override

                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "works!", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });


            }
        });}

    public void addData() {

        DatabaseHelper helper = DatabaseHelper.getInstance(MainActivity.this);

        Employee employee1 = new Employee("123045678", "John", "Smith", 1973, "NY");
        Employee employee2 = new Employee("123045679", "David", "McWill", 1982, "Seattle");
        Employee employee3 = new Employee("123045680", "Katerina", "Wise", 1973, "Boston");
        Employee employee4 = new Employee("123045681", "Donald", "Lee", 1992, "London");
        Employee employee5 = new Employee("123045682", "Gary", "Henwood", 1987, "Las Vegas");
        Employee employee6 = new Employee("123045683", "Anthony", "Bright", 1963, "Seattle");
        Employee employee7 = new Employee("123045684", "William", "Newey", 1995, "Boston");
        Employee employee8 = new Employee("123045685", "Melony", "Smith", 1970, "Chicago");

        Job job1 = new Job("123045678", "Fuzz", 60, 1);
        Job job2 = new Job("123045679", "GA", 70, 2);
        Job job3 = new Job("123045680", "Little Place", 120, 5);
        Job job4 = new Job("123045681", "Macy's", 78, 3);
        Job job5 = new Job("123045682", "New Life", 65, 1);
        Job job6 = new Job("123045683", "Believe", 158, 6);
        Job job7 = new Job("123045684", "Macy's", 200, 8);
        Job job8 = new Job("123045685", "Stop", 299, 12);

        helper.insertRowEmployeeTable(employee1);
        helper.insertRowEmployeeTable(employee2);
        helper.insertRowEmployeeTable(employee3);
        helper.insertRowEmployeeTable(employee4);
        helper.insertRowEmployeeTable(employee5);
        helper.insertRowEmployeeTable(employee6);
        helper.insertRowEmployeeTable(employee7);
        helper.insertRowEmployeeTable(employee8);

        helper.insertRowJobTable(job1);
        helper.insertRowJobTable(job2);
        helper.insertRowJobTable(job3);
        helper.insertRowJobTable(job4);
        helper.insertRowJobTable(job5);
        helper.insertRowJobTable(job6);
        helper.insertRowJobTable(job7);
        helper.insertRowJobTable(job8);

        helper.close();
    }

}



