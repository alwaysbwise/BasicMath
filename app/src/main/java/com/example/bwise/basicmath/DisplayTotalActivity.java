package com.example.bwise.basicmath;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayTotalActivity extends Activity {

    private TextView textViewTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_total);

        //get references to widgets
       textViewTotal = (TextView) findViewById(R.id.textViewTotal);

       // Get the Intent that started this activity and extract the value
        Bundle bundle = getIntent().getExtras();

        int sum = bundle.getInt("sum");

        textViewTotal.setText(Integer.toString(sum));


    }
}
