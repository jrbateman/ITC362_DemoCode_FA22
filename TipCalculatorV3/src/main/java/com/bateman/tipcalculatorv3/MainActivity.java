package com.bateman.tipcalculatorv3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
  private TipCalculator tipCalc;
  public NumberFormat money = NumberFormat.getCurrencyInstance( );

  protected void onCreate( Bundle savedInstanceState ) {
    super.onCreate( savedInstanceState );
    tipCalc = new TipCalculator( 0.17f, 100.0f );
    setContentView( R.layout.activity_main );
  }

  /** Called when the user clicks on the Calculate button */
  public void calculate( View v ) {
    Log.w( "MainActivity", "v = " + v );
    EditText billEditText =
        ( EditText ) findViewById( R.id.amount_bill );
    EditText tipEditText =
        ( EditText ) findViewById( R.id.amount_tip_percent );
    String billString = billEditText.getText( ).toString( );
    String tipString = tipEditText.getText( ).toString( );

    TextView tipTextView =
        ( TextView ) findViewById( R.id.amount_tip );
    TextView totalTextView =
        ( TextView ) findViewById( R.id.amount_total );
    try {
      // convert billString and tipString to floats
      float billAmount = Float.parseFloat( billString );
      int tipPercent = Integer.parseInt( tipString );
      // update the Model
      tipCalc.setBill( billAmount );
      tipCalc.setTip( .01f * tipPercent );
      // ask Model to calculate tip and total amounts
      float tip = tipCalc.tipAmount( );
      float total = tipCalc.totalAmount( );
      // update the View with formatted tip and total amounts
      tipTextView.setText( money.format( tip ) );
      totalTextView.setText( money.format( total ) );
    } catch( NumberFormatException nfe ) {
      // pop up an alert view here
    }
  }
}