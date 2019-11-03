package com.bateman.puzzlev0;

import java.util.Random;
import android.app.Activity;
import android.view.Gravity;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.graphics.Color;

public class PuzzleView extends RelativeLayout {
  private TextView [] tvs;
  private LayoutParams [] params;
  private int [] colors;

  private int labelHeight;

  public PuzzleView( Activity activity, int width, int height,
                     int numberOfPieces ) {
    super( activity );
    buildGuiByCode( activity, width, height, numberOfPieces );
  }

  public void buildGuiByCode( Activity activity, int width, int height,
                              int numberOfPieces ) {
    tvs = new TextView[numberOfPieces];
    colors = new int[tvs.length];
    params = new LayoutParams[tvs.length];
    Random random = new Random( );
    labelHeight = height / numberOfPieces;
    for( int i = 0; i < tvs.length; i++ ) {
      tvs[i] = new TextView( activity );
      tvs[i].setGravity( Gravity.CENTER );
      colors[i] = Color.rgb( random.nextInt( 255 ),
        random.nextInt( 255 ),	random.nextInt( 255 ) );
      tvs[i].setBackgroundColor( colors[i] );
      params[i] = new LayoutParams( width, labelHeight );
      params[i].leftMargin = 0;
      params[i].topMargin = labelHeight * i;
      addView( tvs[i], params[i] );
    }
  }

  public void fillGui( String [] scrambledText ) {
    for( int i = 0; i < tvs.length; i++ )
      tvs[i].setText( scrambledText[i] );
  }
}