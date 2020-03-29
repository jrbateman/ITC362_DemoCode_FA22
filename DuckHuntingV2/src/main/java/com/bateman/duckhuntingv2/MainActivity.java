package com.bateman.duckhuntingv2;

// v2 -  we allow the user to move the cannon barrel using a single tap or swiping the screen.
// Wherever the user touches the screen, we point the cannon barrel toward that point.
// We also enable shooting by double tapping anywhere on the screen.


import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import java.util.Timer;

public class MainActivity extends Activity {

  private GameView gameView;
  private GestureDetector detector;
  private Game game;

  @Override
  protected void onCreate( Bundle savedInstanceState ) {
    super.onCreate( savedInstanceState );

    // get status bar height
    Resources res = getResources( );
    int statusBarHeight = 0;
    int statusBarId =
      res.getIdentifier( "status_bar_height", "dimen", "android" );
    if( statusBarId > 0 )
      statusBarHeight = res.getDimensionPixelSize( statusBarId );

    Point size = new Point( );
    getWindowManager( ).getDefaultDisplay( ).getSize( size );
    gameView = new GameView( this, size.x, size.y - statusBarHeight );
    setContentView( gameView );

    Timer gameTimer = new Timer( );
    gameTimer.schedule( new GameTimerTask( gameView ),
            0, GameView.DELTA_TIME );

    game = gameView.getGame( );
    TouchHandler th = new TouchHandler( );
    detector = new GestureDetector( this, th );
    detector.setOnDoubleTapListener( th );
  }

  public boolean onTouchEvent( MotionEvent event ) {
    detector.onTouchEvent( event );
    return true;
  }

  private class TouchHandler
          extends GestureDetector.SimpleOnGestureListener {
    public boolean onDoubleTapEvent( MotionEvent event ) {
      if( !game.isBulletFired( ) )
        game.fireBullet( );
      return true;
    }

    public boolean onSingleTapConfirmed( MotionEvent event ) {
      updateCannon( event );
      return true;
    }

    public boolean onScroll( MotionEvent event1, MotionEvent event2,
                             float d1, float d2 ) {
      updateCannon( event2 );
      return true;
    }

    public void updateCannon( MotionEvent event )  {
      float x = event.getX( ) - game.getCannonCenter( ).x;
      float y = game.getCannonCenter( ).y - event.getY( );
      float angle = ( float ) Math.atan2( y, x );
      game.setCannonAngle( angle );
    }
  }
}
