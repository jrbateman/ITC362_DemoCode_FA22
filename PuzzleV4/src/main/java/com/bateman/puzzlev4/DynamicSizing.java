package com.bateman.puzzlev4;

import android.util.TypedValue;
import android.view.View.MeasureSpec;
import android.widget.TextView;

public class DynamicSizing {
  public static final int MAX_FONT_SIZE = 200;
  public static final int MIN_FONT_SIZE = 1;

  /*
   * Sets the maximum font size of tv so that the text inside tv
   *      fits on one line
   * @param  tv    the TextView whose font size is to be changed
   * @return the resulting font size
   */
  public static int setFontSizeToFitInView( TextView tv ) {
    int fontSize = MAX_FONT_SIZE;
    tv.setTextSize( TypedValue.COMPLEX_UNIT_SP, fontSize );
    tv.measure( MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED );
    int lines = tv.getLineCount( );
    if( lines > 0 ) {
      while( lines != 1 && fontSize >= MIN_FONT_SIZE + 2 ) {
        fontSize--;
        tv.setTextSize( TypedValue.COMPLEX_UNIT_SP, fontSize );
        tv.measure( MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED );
        lines = tv.getLineCount( );
      }
      tv.setTextSize( TypedValue.COMPLEX_UNIT_SP, --fontSize );
    }
    return fontSize;
  }
}
