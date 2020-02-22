package com.bateman.hangmanv7;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class GameStateFragment extends Fragment {

  private Callbacks mCallbacks = sDummyCallbacks;

  public interface Callbacks {
    public WordGame getGame( );
    public void play( );
  }

  private static Callbacks sDummyCallbacks = new Callbacks( ) {
    public WordGame getGame( ) {
      return null;
    }
    public void play( ) {
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

    // set up event handling for the keyboard
    EditText answerET
        = (EditText) fragmentView.findViewById( R.id.letter );
    OnEditorHandler editorHandler = new OnEditorHandler( );
    answerET.setOnEditorActionListener( editorHandler );
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

  public void play( ) {
    mCallbacks.play( );
  }

  public WordGame getGameFromActivity( ) {
    return mCallbacks.getGame( );
  }

  private class OnEditorHandler implements TextView.OnEditorActionListener {
    public boolean onEditorAction( TextView v,
                                   int keyCode, KeyEvent event ) {
      // hide the keyboard
      InputMethodManager inputManager = ( InputMethodManager )
          getActivity( ).getSystemService( Context.INPUT_METHOD_SERVICE );
      inputManager.hideSoftInputFromWindow(
          getActivity( ).getCurrentFocus( ).getWindowToken( ),
          InputMethodManager.HIDE_NOT_ALWAYS );

      // play
      play( );

      return true;
    }
  }
}
