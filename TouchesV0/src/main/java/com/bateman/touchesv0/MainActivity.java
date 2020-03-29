package com.bateman.touchesv0;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class  MainActivity extends AppCompatActivity
  implements View.OnTouchListener {
  public static final String MA = "MainActivity";

  protected void onCreate( Bundle savedInstanceState ) {
    super.onCreate( savedInstanceState );
    setContentView( R.layout.activity_main );
    // set up touch event handling
    View view = findViewById( android.R.id.content );
    Log.w( MA, "view = " + view );
    view.setOnTouchListener( this );
  }

  public boolean onTouch( View v, MotionEvent event ) {
    int action = event.getAction( );
    switch( action ) {
      case MotionEvent.ACTION_DOWN:
        Log.w( MA, "DOWN: v = " + v + "; event = " + event );
        break;
      case MotionEvent.ACTION_MOVE:
        Log.w( MA, "MOVE: v = " + v + "; event = " + event );
        break;
      case MotionEvent.ACTION_UP:
        Log.w( MA, "UP: v = " + v + "; event = " + event );
        break;
    }
    return true;
  }
}