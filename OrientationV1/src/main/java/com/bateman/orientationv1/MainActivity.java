package com.bateman.orientationv1;

// we demonstrate how we can retrieve device information
//we need to code our app so that it will react properly to a change in device orientation

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
  public final static String MA = "MainActivity";

  protected void onCreate( Bundle savedInstanceState ) {
    super.onCreate( savedInstanceState );
    setContentView( R.layout.activity_main );
  }

  public void onConfigurationChanged( Configuration newConfig ) {
    super.onConfigurationChanged( newConfig );
    Log.w( MA, "Height: " + newConfig.screenHeightDp );
    Log.w( MA, "Width: " + newConfig.screenWidthDp );

    Log.w( MA, "Orientation: " + newConfig.orientation );
    if( newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE )
      Log.w( MA, "Horizontal position" );
    else if( newConfig.orientation == Configuration.ORIENTATION_PORTRAIT )
      Log.w( MA, "Vertical position" );
    else
      Log.w( MA, "Undetermined position" );
  }
}