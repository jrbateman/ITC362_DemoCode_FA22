package com.bateman.tipcalculatorv1;

// In Version 1, we complete the GUI, adding two labels
// and two TextViews to display the tip amount and the total amount
// add a Red Line using XML vs Design
// as well as one Button.

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }
}
