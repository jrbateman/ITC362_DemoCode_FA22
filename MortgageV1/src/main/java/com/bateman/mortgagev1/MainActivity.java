package com.bateman.mortgagev1;

import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void modifyData( View v ) {
        Intent myIntent = new Intent( this, DataActivity.class );
        this.startActivity(myIntent);
    }
}
