package com.bateman.touchesv2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.GestureDetector;

public class MainActivity extends AppCompatActivity
  implements GestureDetector.OnGestureListener,
  GestureDetector.OnDoubleTapListener {
  public static final String MA = "MainActivity";
  private GestureDetector detector;

  protected void onCreate( Bundle savedInstanceState ) {
    super.onCreate( savedInstanceState );
    detector = new GestureDetector( this, this );
    detector.setOnDoubleTapListener( this );
  }

  public boolean onTouchEvent( MotionEvent event ) {
    Log.w( MA, "Inside onTouchEvent" );
    detector.onTouchEvent( event );
    return true;
  }

  public boolean onFling( MotionEvent e1, MotionEvent e2,
                          final float velocityX, final float velocityY )  {
    Log.w( MA, "Inside onFling" );
    return true;
  }

  public boolean onDown( MotionEvent e ) {
    Log.w( MA, "Inside onDown" );
    return true;
  }

  public void onLongPress( MotionEvent e ) {
    Log.w( MA, "Inside onLongPress" );
  }

  public boolean onScroll( MotionEvent e1, MotionEvent e2,
                           float distanceX, float distanceY ) {
    Log.w( MA, "Inside onScroll" );
    return true;
  }

  public void onShowPress( MotionEvent e ) {
    Log.w( MA, "Inside onShowPress" );
  }

  public boolean onSingleTapUp( MotionEvent e ) {
    Log.w( MA, "Inside onSingleTapUp" );
    return true;
  }

  public boolean onDoubleTap( MotionEvent e ) {
    Log.w( MA, "Inside onDoubleTap" );
    return true;
  }

  public boolean onDoubleTapEvent( MotionEvent e ) {
    Log.w( MA, "Inside onDoubleTapEvent" );
    return true;
  }

  public boolean onSingleTapConfirmed( MotionEvent e ) {
    Log.w( MA, "Inside onSingleTapConfirmed" );
    return true;
  }
}