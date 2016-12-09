package com.rosstox26.athos.projectathos;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;

public class CenterActivity extends Activity implements View.OnClickListener {
//
    private Button buttonWriteReview;
    private Button buttonMore1;
    private Button buttonMore2;
    private EditText editTextInfo;
    private EditText editTextInfo2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center2);

        buttonWriteReview = (Button) findViewById(R.id.buttonWriteReview);
        buttonMore1 = (Button) findViewById(R.id.buttonMore1);
        buttonMore2 = (Button) findViewById(R.id.buttonMore2);

        buttonWriteReview.setOnClickListener(this);
        buttonMore1.setOnClickListener(this);
        buttonMore2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
