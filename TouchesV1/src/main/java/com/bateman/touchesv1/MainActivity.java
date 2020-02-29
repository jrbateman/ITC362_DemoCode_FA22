package com.bateman.touchesv1;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
  implements View.OnTouchListener {
  private TextView tv;
  private RelativeLayout.LayoutParams params;
  private int startX;
  private int startY;
  private int startTouchX;
  private int startTouchY;

  protected void onCreate( Bundle savedInstanceState ) {
    super.onCreate( savedInstanceState );
    buildGuiByCode( );
  }

  public void buildGuiByCode( ) {
    tv = new TextView( this );
    tv.setBackgroundColor( 0xFFFF0000 );

    RelativeLayout rl = new RelativeLayout( this );
    params = new RelativeLayout.LayoutParams( 300, 200 );
    params.leftMargin = 50;
    params.topMargin = 150;

    rl.addView( tv, params );
    setContentView( rl );

    tv.setOnTouchListener( this );
  }

  public boolean onTouch( View v, MotionEvent event ) {
    int action = event.getAction( );
    switch( action ) {
      case MotionEvent.ACTION_DOWN:
        startX = params.leftMargin;
        startY = params.topMargin;
        startTouchX = ( int ) event.getX( );
        startTouchY = ( int ) event.getY( );
        break;
      case MotionEvent.ACTION_MOVE:
        params.leftMargin = startX + ( int ) event.getX( ) - startTouchX;
        params.topMargin = startY + ( int ) event.getY( ) - startTouchY;
        tv.setLayoutParams( params );
        break;
    }
    return true;
  }
}
