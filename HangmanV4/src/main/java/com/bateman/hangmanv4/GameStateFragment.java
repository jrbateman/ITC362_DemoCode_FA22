package com.bateman.hangmanv4;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class GameStateFragment extends Fragment {

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
    MainActivity fragmentActivity = ( MainActivity ) getActivity( );
    gameStateTV.setText( fragmentActivity.getGame( )
      .currentIncompleteWord( ) );
  }
}
