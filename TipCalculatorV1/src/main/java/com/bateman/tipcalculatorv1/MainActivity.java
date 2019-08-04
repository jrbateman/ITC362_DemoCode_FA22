package com.bateman.tipcalculatorv1;

// In Version 1, we complete the GUI, adding two labels
// and two TextViews to display the tip amount and the total amount
// as well as one Button.

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }
}
