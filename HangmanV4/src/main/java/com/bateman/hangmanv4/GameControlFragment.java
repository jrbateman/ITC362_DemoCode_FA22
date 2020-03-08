package com.bateman.hangmanv4;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class GameControlFragment extends Fragment {
  public GameControlFragment( ) {
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    return super.onCreateView(inflater, container, savedInstanceState);
  }

  /*  @Override
  public View onCreateView( LayoutInflater inflater,
                            ViewGroup container, Bundle savedInstanceState ) {

   *//* hideKeyboardFrom(this,container);
    return inflater.inflate( R.layout.fragment_game_control,
      container, false )*//*;
  }*/

/*public static void hideKeyboardFrom(Context context, View view) {
    InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
  }*/
}