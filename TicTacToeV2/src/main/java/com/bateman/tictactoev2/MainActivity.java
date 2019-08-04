package com.bateman.tictactoev2;

//We are assuming that two users will be playing on the same device against each other.
// Enabling game play does not just mean placing an X or an O on the grid of buttons at each turn.
// It also means enforcing the rules, such as not allowing someone to play twice at the same position on the grid,
// checking if one player won, indicating if the game is over.
// Our Model, the TicTacToe class, provides that functionality.
// In order to enable play, we add a TicTacToe object as an instance variable of our Activity class,
// and we call the methods of the TicTacToe class as and when needed.
// Play is happening inside the update method so we have to modify it.
// We also need to check if the game is over and, in that case, disable all the buttons.


import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity {
    private TicTacToe tttGame;
    private Button [][] buttons;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        tttGame = new TicTacToe( );
        buildGuiByCode( );
    }

    public void buildGuiByCode( ) {
        // Get width of the screen
        Point size = new Point( );
        getWindowManager( ).getDefaultDisplay( ).getSize( size );
        int w = size.x / TicTacToe.SIDE;

        // Create the layout manager as a GridLayout
        GridLayout gridLayout = new GridLayout( this );
        gridLayout.setColumnCount( TicTacToe.SIDE );
        gridLayout.setRowCount( TicTacToe.SIDE );

        // Create the buttons and add them to gridLayout
        buttons = new Button[TicTacToe.SIDE][TicTacToe.SIDE];
        ButtonHandler bh = new ButtonHandler( );
        for( int row = 0; row < TicTacToe.SIDE; row++ ) {
            for( int col = 0; col < TicTacToe.SIDE; col++ ) {
                buttons[row][col] = new Button( this );
                buttons[row][col].setTextSize( ( int ) ( w * .2 ) );
                buttons[row][col].setOnClickListener( bh );
                gridLayout.addView( buttons[row][col], w, w );
            }
        }

        // Set gridLayout as the View of this Activity
        setContentView( gridLayout );
    }

    public void update( int row, int col ) {
        int play = tttGame.play( row, col );
        if( play == 1 )
            buttons[row][col].setText( "X" );
        else if( play == 2 )
            buttons[row][col].setText( "O" );
        if( tttGame.isGameOver( ) ) // game over, disable buttons
            enableButtons( false );
    }

    public void enableButtons( boolean enabled ) {
        for( int row = 0; row < TicTacToe.SIDE; row++ )
            for( int col = 0; col < TicTacToe.SIDE; col++ )
                buttons[row][col].setEnabled( enabled );
    }

    private class ButtonHandler implements View.OnClickListener {
        public void onClick( View v ) {
            for( int row = 0; row < TicTacToe.SIDE; row ++ )
                for( int column = 0; column < TicTacToe.SIDE; column++ )
                    if( v == buttons[row][column] )
                        update( row, column );
        }
    }
}
