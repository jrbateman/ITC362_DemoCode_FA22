package com.bateman.orientationv0;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    public final static String MA = "MainActivity";

    protected void onCreate( Bundle savedInstanceState ) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      Configuration config = getResources( ).getConfiguration( );
      Log.w( MA, "screen dp height: " + config.screenHeightDp );
      Log.w( MA, "screen dp width: " + config.screenWidthDp );

      Point size = new Point( );
      getWindowManager( ).getDefaultDisplay( ).getSize( size );
      int screenWidth = size.x;
      int screenHeight = size.y;
      Log.w( MA, "screen height in pixels = " + screenHeight );
      Log.w( MA, "screen width in pixels = " + screenWidth );

      Resources res = getResources( );
      DisplayMetrics metrics = res.getDisplayMetrics( );
      float pixelDensity = metrics.density;
      Log.w( MA, "logical pixel density = " + pixelDensity );

      if( config.isLayoutSizeAtLeast(
          Configuration.SCREENLAYOUT_SIZE_XLARGE ) )
        Log.w( MA, "Extra large size screen" );
      else if( config.isLayoutSizeAtLeast(
          Configuration.SCREENLAYOUT_SIZE_LARGE ) )
        Log.w( MA, "Large size screen" );
      else if( config.isLayoutSizeAtLeast(
          Configuration.SCREENLAYOUT_SIZE_NORMAL ) )
        Log.w( MA, "Normal size screen" );
      else if( config.isLayoutSizeAtLeast(
          Configuration.SCREENLAYOUT_SIZE_SMALL ) )
        Log.w( MA, "Small size screen" );
      else
        Log.w( MA, "Unknown size screen" );

      Log.w( MA, "Landscape constant: "
          + Configuration.ORIENTATION_LANDSCAPE );
      Log.w( MA, "Portrait constant: "
          + Configuration.ORIENTATION_PORTRAIT );
      Log.w( MA, "Orientation: " + config.orientation );
      if( config.orientation == Configuration.ORIENTATION_LANDSCAPE )
        Log.w( MA, "Horizontal position" );
      else if( config.orientation == Configuration.ORIENTATION_PORTRAIT )
        Log.w( MA, "Vertical position" );
      else
        Log.w( MA, "Undetermined position" );
    }
  }
