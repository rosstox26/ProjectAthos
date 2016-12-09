package com.rosstox26.athos.projectathos;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class WelcomeActivity extends Activity implements View.OnClickListener{

//
    private RadioButton radioButtonCustomer;
    private RadioButton radioButtonProvider;
    private Button buttonEnter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome3);

        radioButtonCustomer = (RadioButton) findViewById(R.id. radioButtonCustomer);
        radioButtonProvider = (RadioButton) findViewById(R.id.radioButtonCustomer);
        buttonEnter = (Button) findViewById(R.id. buttonEnter);

        buttonEnter.setOnClickListener(this);
        radioButtonCustomer.setOnClickListener(this);
        radioButtonProvider.setOnClickListener (this);



    }

    @Override
    public void onClick(View v) {

    }
}
