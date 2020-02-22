package com.bateman.hangmanv2;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

// V0 - Defining and Adding a Fragment to an Activity Using a Layout XML File
// V1 - Adding GUI Components, Styles, Strings, and Colors
// V2 - Defining a Fragment Using a Layout XML File and Adding the Fragment to an Activity by Code
//  we display the fragment on the top right pane (with the blue background) of the screen showing
//  the state of completion of the word, and an EditText for the user to enter a letter.
//  We code the fragment in an XML file, fragment_game_state.xml, and create the fragment by code.

public class MainActivity extends AppCompatActivity {

  private Hangman game;

  @Override
  protected void onCreate( Bundle savedInstanceState ) {
    super.onCreate( savedInstanceState );
    if ( game == null )
      game = new Hangman( Hangman.DEFAULT_GUESSES );
    setContentView( R.layout.activity_main );
    TextView status = ( TextView ) findViewById( R.id.status );
    status.setText( "" + game.getGuessesLeft( ) );

    FragmentManager fragmentManager = getFragmentManager( );
    if( fragmentManager.findFragmentById( R.id.game_state ) == null ) {
      FragmentTransaction transaction = fragmentManager.beginTransaction( );
      GameStateFragment fragment = new GameStateFragment( );
      transaction.add( R.id.game_state, fragment );
      transaction.commit( );
    }
  }

  public Hangman getGame( ) {
    return game;
  }

  public void play( View view ) {
  }
}
