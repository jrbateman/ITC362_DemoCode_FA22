package com.bateman.duckhuntingv3;

// V3, when the duck is hit, we play a small sound and we let the duck fall down to the ground
// (in fact, we let the duck go through the ground).
// We also make a sound when we fire a bullet.

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Point;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

import java.util.Timer;

public class MainActivity extends Activity {

  private GameView gameView;
  private GestureDetector detector;
  private Game game;

  private SoundPool pool;
  private int fireSoundId;
  private int hitSoundId;

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

    SoundPool.Builder poolBuilder = new SoundPool.Builder( );
    poolBuilder.setMaxStreams( 2 );
    pool = poolBuilder.build( );
    fireSoundId = pool.load( this, R.raw.cannon_fire, 1 );
    hitSoundId = pool.load( this, R.raw.duck_hit, 1 );
  }

  public boolean onTouchEvent( MotionEvent event ) {
    detector.onTouchEvent( event );
    return true;
  }

  public void playHitSound( ) {
    pool.play( hitSoundId, 1.0f, 1.0f, 1, 0, 1.0f );
  }

  private class TouchHandler
          extends GestureDetector.SimpleOnGestureListener {
    public boolean onDoubleTapEvent( MotionEvent event ) {
      if ( !game.isBulletFired( ) ) {
        game.fireBullet( );
        pool.play( fireSoundId, 1.0f, 1.0f, 1, 0, 1.0f );
      }
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
