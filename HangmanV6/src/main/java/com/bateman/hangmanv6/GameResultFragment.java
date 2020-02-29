package com.bateman.hangmanv6;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class GameResultFragment extends Fragment {
  private TextView gameResultTV;

  @Override
  public View onCreateView( LayoutInflater inflater,
                            ViewGroup container, Bundle savedInstanceState ) {
    setUpFragmentGui( container );
    return super.onCreateView( inflater, container,
      savedInstanceState ) ;
  }

  public void setUpFragmentGui( ViewGroup container ) {
    if( gameResultTV == null ) {
      gameResultTV = new TextView( getActivity( ) );
      gameResultTV.setGravity( Gravity.CENTER );
      container.addView( gameResultTV );
    }
  }

  public void onStart( ) {
    super.onStart( );
    gameResultTV.setText( "GOOD LUCK" );
  }

  public void setResult( String result ) {
    gameResultTV.setText( result );
  }
}
