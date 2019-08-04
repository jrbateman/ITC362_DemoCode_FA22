package com.bateman.candystorev1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class InsertActivity extends AppCompatActivity  {
  public void onCreate( Bundle savedInstanceState ) {
    super.onCreate( savedInstanceState );
    setContentView( R.layout.activity_insert );
  }

  public void insert( View v ) {
    // Retrieve name and price
    EditText nameEditText = findViewById( R.id.input_name );
    EditText priceEditText = findViewById( R.id.input_price );
    String name = nameEditText.getText( ).toString( );
    String priceString = priceEditText.getText( ).toString( );

    // insert new candy in database

    // clear data
    nameEditText.setText( "" );
    priceEditText.setText( "" );
  }

  public void goBack( View v ) {
    this.finish( );
  }
}
