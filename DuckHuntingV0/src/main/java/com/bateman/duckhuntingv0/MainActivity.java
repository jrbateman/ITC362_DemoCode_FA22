package com.bateman.duckhuntingv0;

// V0 - We display the cannon on the lower left corner of the screen and a duck at the top right corner of the screen.

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;

public class MainActivity extends Activity {

  private GameView gameView;

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
  }
}
