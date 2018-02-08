package com.example.bwise.basicmath;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{



    //define instance variables for widgets
    private EditText editTextNum1;
    private EditText editTextNum2;
    //private TextView textViewSum;
    private Button buttonSum;

    /*
    * private Button buttonDiff;
    * private Button buttonProduct;
    * private Button buttonDiv;
    * */

    //define shared preferences object
    private SharedPreferences savedValues;

    //define variables to be saved
    private int num1 = 0;
    private int num2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get references to widgets
        editTextNum1 = (EditText) findViewById(R.id.editTextNum1);
        editTextNum2 = (EditText) findViewById(R.id.editTextNum2);
        buttonSum = (Button) findViewById(R.id.buttonSum);
        //textViewSum = (TextView) findViewById(R.id.textViewSum);


        //set the listener
        buttonSum.setOnClickListener((View.OnClickListener) this);

        //add other button listeners here

        //get SharedPreferences object
        savedValues = getSharedPreferences("SavedValues", MODE_PRIVATE);


    }//end onCreate



    @Override
    public void onPause(){
        // save instance variables
        SharedPreferences.Editor editor = savedValues.edit();
        editor.putInt("num1", num1);
        editor.putInt("num2", num2);
        editor.commit();

        super.onPause();
    }

    @Override
    public void onResume(){
        //get variables
        num1 = savedValues.getInt("num1", 0);
        num2 = savedValues.getInt("num2", 0);
        //editTextNum1.setText(num1);
        //editTextNum2.setText(num2);

        super.onResume();

    }


    public int calculateAndDisplay(){

        //get user numbers and cast to floats
        num1 = Integer.parseInt(editTextNum1.getText().toString());
        num2 = Integer.parseInt(editTextNum2.getText().toString());

        int sum = num1 + num2;

        /*add logic
        * float diff = num1 - num2;
        * float prod = num1 * num2;
        *
        * */

        //textViewSum.setText(String.valueOf(sum));

        return sum;

    }//end calculateAndDisplay()

    @Override
    public void onClick(View view) {

        int sum = calculateAndDisplay();

        Intent intent = new Intent(MainActivity.this, DisplayTotalActivity.class);
        intent.putExtra("sum", sum);
        startActivity(intent);

    }







}//end MainActivity