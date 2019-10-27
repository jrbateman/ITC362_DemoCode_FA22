package com.bateman.paintcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class HelpActivity extends Activity {
    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_layout);
    }

    public void gotoInput(View view){
        finish();
    }
}
