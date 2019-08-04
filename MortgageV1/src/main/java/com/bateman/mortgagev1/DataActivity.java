package com.bateman.mortgagev1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class DataActivity extends AppCompatActivity {

  public void onCreate( Bundle savedInstanceState ) {
    super.onCreate( savedInstanceState );
    setContentView( R.layout.activity_data );
  }

  public void goBack( View v ) {
    this.finish( );
  }
}
