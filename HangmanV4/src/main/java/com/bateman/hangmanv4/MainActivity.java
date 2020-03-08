package com.bateman.hangmanv4;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


// V4 - Communication between Fragments and Their Activity: Enabling Play
//  we complete the app by processing the user’s letter and enabling the user to play the game.
//  We also illustrate how fragments can communicate with their activity when processing an event.

public class MainActivity extends AppCompatActivity {

  private Hangman game;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (game == null)
      game = new Hangman(Hangman.DEFAULT_GUESSES);
    setContentView(R.layout.activity_main);
    TextView status = (TextView) findViewById(R.id.status);
    status.setText("" + game.getGuessesLeft());

    //FragmentManager fragmentManager = getFragmentManager( );
    FragmentManager fragmentManager = getSupportFragmentManager();
    if (fragmentManager.findFragmentById(R.id.game_state) == null) {
      FragmentTransaction transaction = fragmentManager.beginTransaction();
      GameStateFragment fragment = new GameStateFragment();
      transaction.add(R.id.game_state, fragment);
      transaction.commit();
    }

    if (fragmentManager.findFragmentById(R.id.game_result) == null) {
      FragmentTransaction transaction = fragmentManager.beginTransaction();
      GameResultFragment fragment = new GameResultFragment();
      transaction.add(R.id.game_result, fragment);
      transaction.commit();
    }

  }

  public Hangman getGame() {
    return game;
  }

  public void play(View view) {

    EditText input = (EditText) findViewById(R.id.letter);



    Editable userText = input.getText();
    if (userText != null && userText.length() > 0) {
      // update number of guesses left
      char letter = userText.charAt(0);
      game.guess(letter);
      TextView status = (TextView) findViewById(R.id.status);
      status.setText("" + game.getGuessesLeft());

      // update incomplete word
      //FragmentManager fragmentManager = getFragmentManager( );
      FragmentManager fragmentManager = getSupportFragmentManager();
      GameStateFragment gsFragment = (GameStateFragment)
              fragmentManager.findFragmentById(R.id.game_state);
      View gsFragmentView = gsFragment.getView();
      TextView gameStateTV = (TextView)
              gsFragmentView.findViewById(R.id.state_of_game);
      gameStateTV.setText(game.currentIncompleteWord());

      // clear EditText
      input.setText("");

      int result = game.gameOver();
      if (result != 0) /* game is over */ {
        GameResultFragment grFragment = (GameResultFragment)
                fragmentManager.findFragmentById(R.id.game_result);

        // update TextView in result fragment
        if (result == 1)
          grFragment.setResult("YOU WON");
        else if (result == -1)
          grFragment.setResult("YOU LOST");

        // delete hint in EditText
        input.setHint("");
      }
    }
  }

  public static void hideKeyboardFrom(Context context, View view) {
    InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
  }
}
