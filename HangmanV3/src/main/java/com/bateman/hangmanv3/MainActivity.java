package com.bateman.hangmanv3;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

//import android.support.v7.app.AppCompatActivity;

// V0 - Defining and Adding a Fragment to an Activity Using a Layout XML File
// V1 - Adding GUI Components, Styles, Strings, and Colors
// V2 - Defining a Fragment Using a Layout XML File and Adding the Fragment to an Activity by Code
//  we display the fragment on the top right pane (with the blue background) of the screen showing
//  the state of completion of the word, and an EditText for the user to enter a letter.
//  We code the fragment in an XML file, fragment_game_state.xml, and create the fragment by code.
// V3 -  Defining and Adding a Fragment to an Activity by Code
//  we display the fragment on the bottom right pane (with the green background) of the screen
//  showing a message about the result of the game in a TextView.
//  This time, we do not use an XML file to define the fragment, we define and create it entirely by code.

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

    FragmentManager fragmentManager = getSupportFragmentManager( );
    if( fragmentManager.findFragmentById( R.id.game_state ) == null ) {
      FragmentTransaction transaction = fragmentManager.beginTransaction( );
      GameStateFragment fragment = new GameStateFragment( );
      transaction.add( R.id.game_state, fragment );
      transaction.commit( );
    }

    if( fragmentManager.findFragmentById( R.id.game_result ) == null ) {
      FragmentTransaction transaction = fragmentManager.beginTransaction( );
      GameResultFragment fragment = new GameResultFragment( );
      transaction.add( R.id.game_result, fragment );
      transaction.commit( );
    }

  }

  public Hangman getGame( ) {
    return game;
  }

  public void play( View view ) {
  }
}
