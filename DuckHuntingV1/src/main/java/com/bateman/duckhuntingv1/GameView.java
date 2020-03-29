package com.bateman.duckhuntingv1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;

public class GameView extends View {
  public static int DELTA_TIME = 100;
  private int [ ] TARGETS = { R.drawable.anim_duck0, R.drawable.anim_duck1,
                            R.drawable.anim_duck2, R.drawable.anim_duck1 };
  private Paint paint;
  private Bitmap [ ] ducks;
  private int duckFrame;

  private Game game;

  public GameView( Context context, int width, int height ) {
    super( context );
    ducks = new Bitmap[TARGETS.length];
    for( int i = 0; i < ducks.length; i++ )
      ducks[i] =
          BitmapFactory.decodeResource( getResources( ), TARGETS[i] );
    float scale = ( ( float ) width / ( ducks[0].getWidth( ) * 5 ) );
    Rect duckRect = new Rect( 0, 0, width / 5,
        ( int ) ( ducks[0].getHeight( ) * scale ) );
    game = new Game( duckRect, 5, .03f, .2f );
    game.setDuckSpeed( width * .00003f );
    game.setBulletSpeed( width * .0003f );
    game.setDeltaTime( DELTA_TIME );

    game.setHuntingRect( new Rect( 0, 0, width, height ) );
    game.setCannon( new Point( 0, height ), width / 30,
       width / 15, width / 50);

    paint = new Paint( );
    paint.setColor( 0xFF000000 );
    paint.setAntiAlias( true );
    paint.setStrokeWidth( game.getBarrelRadius( ) );
  }

  public void onDraw( Canvas canvas ) {
    super.onDraw( canvas );
    // draw cannon
    canvas.drawCircle( game.getCannonCenter( ).x, game.getCannonCenter( ).y,
         game.getCannonRadius( ), paint );

    // draw cannon barrel
    canvas.drawLine(
        game.getCannonCenter( ).x, game.getCannonCenter( ).y,
        game.getCannonCenter( ).x + game.getBarrelLength( )
            * ( float ) Math.cos( game.getCannonAngle( ) ),
        game.getCannonCenter( ).y - game.getBarrelLength( )
            * ( float ) Math.sin( game.getCannonAngle( ) ),
        paint );

    // draw animated duck
    duckFrame = ( duckFrame + 1 ) % ducks.length;
    canvas.drawBitmap( ducks[duckFrame], null, game.getDuckRect( ), paint );
  }

  public Game getGame( ) {
    return game;
  }
}
