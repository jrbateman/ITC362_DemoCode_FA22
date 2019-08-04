package com.bateman.mortgagev0;

import java.text.DecimalFormat;

public class Mortgage {
  public final DecimalFormat MONEY
               = new DecimalFormat( "$#,##0.00" );

  private float amount;
  private int years;
  private float rate;

  public Mortgage( ) {
    setAmount( 100000.0f );
    setYears( 30 );
    setRate( 0.035f );
  }

  public void setAmount( float newAmount ) {
    if( newAmount >= 0 )
      amount = newAmount;
  }

  public void setYears( int newYears ) {
    if( newYears >= 0 )
      years = newYears;
  }

  public void setRate( float newRate ) {
    if( newRate >= 0 )
      rate = newRate;
  }

  public float getAmount( ) {
    return amount;
  }

  public String getFormattedAmount( ) {
    return MONEY.format( amount );
  }

  public int getYears( ) {
    return years;
  }

  public float getRate( ) {
    return rate;
  }

  public float monthlyPayment( ) {
    float mRate = rate / 12;  // monthly interest rate
    double temp = Math.pow( 1/( 1 + mRate ), years * 12 );
    return amount * mRate / ( float ) ( 1 - temp );
  }

  public String formattedMonthlyPayment( ) {
    return MONEY.format( monthlyPayment( ) );
  }

  public float totalPayment( ) {
    return monthlyPayment( ) * years * 12;
  }

  public String formattedTotalPayment( ) {
    return MONEY.format( totalPayment( ) );
  }
}