package com.bateman.hangmanv6;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class GameStateFragment extends Fragment {

  private Callbacks mCallbacks = sDummyCallbacks;

  public interface Callbacks {
    public WordGame getGame( );
  }

  private static Callbacks sDummyCallbacks = new Callbacks( ) {
    public WordGame getGame( ) {
      return null;
    }
  };

  public GameStateFragment( ) {
  }

  @Override
  public View onCreateView( LayoutInflater inflater,
                            ViewGroup container, Bundle savedInstanceState ) {
    return inflater.inflate( R.layout.fragment_game_state,
      container, false );
  }

  public void onStart( ) {
    super.onStart( );
    View fragmentView = getView( );
    TextView gameStateTV
      = ( TextView ) fragmentView.findViewById( R.id.state_of_game );
    gameStateTV.setText( getGameFromActivity( )
        .currentIncompleteWord( ) );
  }

  public void onAttach( Context context ) {
    super.onAttach( context );
    if ( !( context instanceof Callbacks ) ) {
      throw new IllegalStateException(
          "Context must implement fragment's callbacks." );
    }
    mCallbacks = ( Callbacks ) context;
  }

  public void onDetach( ) {
    super.onDetach( );
    mCallbacks = sDummyCallbacks;
  }

  public WordGame getGameFromActivity( ) {
    return mCallbacks.getGame( );
  }
}
