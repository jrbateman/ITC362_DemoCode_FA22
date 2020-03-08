package com.bateman.hangmanv6;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

// V6 - Making a Fragment Reusable

public class MainActivity extends AppCompatActivity implements GameStateFragment.Callbacks {

  private Hangman game;

  @Override
  protected void onCreate( Bundle savedInstanceState ) {
    super.onCreate( savedInstanceState );
    if ( game == null )
      game = new Hangman( Hangman.DEFAULT_GUESSES );
    setContentView( R.layout.activity_main );
    TextView status = ( TextView ) findViewById( R.id.status );
    status.setText( "" + game.getGuessesLeft( ) );

    FragmentManager fm = getSupportFragmentManager();

    if (fm.findFragmentById(R.id.game_state)== null){
      FragmentTransaction ft = fm.beginTransaction();
      GameStateFragment fragment = new GameStateFragment();
      ft.add(R.id.game_state, fragment);
      ft.commit();

    }

    if (fm.findFragmentById(R.id.game_result)== null){
      FragmentTransaction ft = fm.beginTransaction();
      GameResultFragment fragment = new GameResultFragment();
      ft.add(R.id.game_result, fragment);
      ft.commit();

    }

    if (fm.findFragmentByTag("background") == null){
      FragmentTransaction ft = fm.beginTransaction();
      BackgroundFragment fragment = new BackgroundFragment();
      ft.add(fragment, "background");
      ft.commit();
    }

  }

  public Hangman getGame( ) {
    return game;
  }

  public void play( View view ) {
    EditText input = (EditText) findViewById( R.id.letter );
    Editable userText = input.getText( );
    if( userText != null && userText.length( ) > 0 ) {
      // update number of guesses left
      char letter = userText.charAt( 0 );
      game.guess( letter );
      TextView status = ( TextView ) findViewById( R.id.status );
      status.setText( "" + game.getGuessesLeft() );

      // update incomplete word
     // FragmentManager fragmentManager = getFragmentManager( );
      FragmentManager fragmentManager = getSupportFragmentManager( );
      GameStateFragment gsFragment = ( GameStateFragment )
          fragmentManager.findFragmentById( R.id.game_state );
      View gsFragmentView = gsFragment.getView( );
      TextView gameStateTV = ( TextView )
          gsFragmentView.findViewById( R.id.state_of_game );
      gameStateTV.setText( game.currentIncompleteWord( ) );

      // clear EditText
      input.setText( "" );

      // check if there is only one guess left
      if( game.getGuessesLeft( ) == 1 ) {
        BackgroundFragment background = ( BackgroundFragment )
            fragmentManager.findFragmentByTag( "background" );
        GameResultFragment grFragment = ( GameResultFragment )
            fragmentManager.findFragmentById( R.id.game_result );
        // retrieve warning and display it
        grFragment.setResult( background.warning( ) );
      }

      int result = game.gameOver( );
      if( result != 0 ) /* game is over */ {
        GameResultFragment grFragment = ( GameResultFragment )
            fragmentManager.findFragmentById( R.id.game_result );

        // update TextView in result fragment
        if( result == 1 )
          grFragment.setResult( "YOU WON" );
        else if( result == -1 )
          grFragment.setResult( "YOU LOST" );

        // delete hint in EditText
        input.setHint( "" );
      }
    }
  }
}
