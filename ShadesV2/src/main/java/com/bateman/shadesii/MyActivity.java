package com.bateman.shadesii;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class MyActivity extends Activity implements
        MyListFragment.OnItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }

    @Override
    public void onColorItemSelected(String link) {

        //CHECK IF FRAGMENT2 EXISTS IN THIS LAYOUT
        InformationFragment fragment2 = (InformationFragment) getFragmentManager()
                .findFragmentById(R.id.fragment2);

        //A TWO PANE CONFIGURATION
        if (fragment2 != null && fragment2.isInLayout()) {
            fragment2.setText(link);
        }
        //A SINGLE-PANE CONFIGURATION -
        //  IF FRAGMENT 2 DOES NOT EXIST IN THIS LAYOUT, THEN ACTIVATE THE NEXT ACTIVITY
        else {
            Intent intent = new Intent (this, InformationActivity.class);
            intent.putExtra("Information", link);
            startActivity (intent);
        }
    }

}
