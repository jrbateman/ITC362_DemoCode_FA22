package com.bateman.candystorev5;

import android.content.Context;

import androidx.appcompat.widget.AppCompatButton;


public class CandyButton extends AppCompatButton {
  private Candy candy;

  public CandyButton( Context context, Candy newCandy ) {
    super( context );
    candy = newCandy;
  }

  public double getPrice( ) {
    return candy.getPrice( );
  }
}
