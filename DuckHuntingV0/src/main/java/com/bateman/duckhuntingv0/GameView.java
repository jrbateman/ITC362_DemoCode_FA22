package com.bateman.duckhuntingv0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class GameView extends View {
  public static final int TARGET = R.drawable.duck;
  private Paint paint;
  private Bitmap duck;
  private Rect duckRect;
  private int height;

  public GameView( Context context, int width, int height ) {
    super( context );
    this.height = height;
    duck = BitmapFactory.decodeResource( getResources( ), TARGET );

    float scale = ( ( float ) width / ( duck.getWidth( ) * 5 ) );
    duckRect = new Rect( width - width / 5 , 0, width,
        ( int ) ( duck.getHeight( ) * scale ) );

    paint = new Paint( );
    paint.setColor( 0xFF000000 );
    paint.setAntiAlias( true );
    paint.setStrokeWidth( 10.0f );
  }

  public void onDraw( Canvas canvas ) {
    super.onDraw( canvas );
    // draw Cannon
    canvas.drawCircle( 0, height, height / 10, paint );

    // draw cannon barrel using a 45 degrees angle
    canvas.drawLine( 0, height, height / 5, height - height / 5, paint );

    // draw duck
    canvas.drawBitmap( duck,  null, duckRect, paint );
  }
}
