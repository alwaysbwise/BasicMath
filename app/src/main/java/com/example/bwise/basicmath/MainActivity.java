package com.example.bwise.basicmath;

import android.app.Activity;
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
    private TextView textViewSum;
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
        textViewSum = (TextView) findViewById(R.id.textViewSum);

        //set the listener
        buttonSum.setOnClickListener((View.OnClickListener) this);
        //add other button listeners here

        //get SharedPreferences object
        savedValues = getSharedPreferences("SavedValues", MODE_PRIVATE);

    }//end onCreate

    public void calculateAndDisplay(){

        //get user numbers and cast to floats
        num1 = Integer.parseInt(editTextNum1.getText().toString());
        num2 = Integer.parseInt(editTextNum2.getText().toString());

        


        float sum = num1 + num2;

        /*add logic
        * float diff = num1 - num2;
        * float prod = num1 * num2;
        *
        * */

        textViewSum.setText(String.valueOf(sum));
    }//end calculateAndDisplay()


    @Override
    public void onClick(View view) {
        calculateAndDisplay();
    }
}//end MainActivity
