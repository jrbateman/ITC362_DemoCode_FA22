package com.bateman.shadesii;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.TextView;

public class InformationActivity extends Activity {



    public static final String EXTRA_URL = "url";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Need to check if Activity has been switched to landscape mode
        // If yes, finished and go back to the start Activity
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }
        setContentView(R.layout.information_fragment);

        //SHOW THE UP BUTTON IN THE ACTION BAR
        getActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String informationValue = intent.getStringExtra("Information");

        TextView info = findViewById (R.id.textView1);
        info.setText(informationValue);

    }

}
