package com.bateman.hangmanv7;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class GameControlFragment extends Fragment {
  public GameControlFragment( ) {
  }

  @Override
  public View onCreateView( LayoutInflater inflater,
                            ViewGroup container, Bundle savedInstanceState ) {
    return inflater.inflate( R.layout.fragment_game_control,
      container, false );
  }
}