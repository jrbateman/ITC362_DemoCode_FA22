package com.bateman.shades;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.TextView;

public class InformationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //TASK 1:  VERIFY THE ORIENTATION HAS BEEN SWITCHED
        //         TO LANDSCAPE MODE.
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();  //FINISH AND GO BACK TO THE START ACTIVITY
            return;
        }

        //TASK 2: SET THE LAYOUT FOR THIS ACTIVITY
        setContentView(R.layout.information_fragment);

        //TASK 3: DISPLAY THE UP ICON IN THE ACTION BAR
        getActionBar().setDisplayHomeAsUpEnabled(true);

        //TASK 4: RETURN THE INTENT THAT STARTED THIS ACTIVITY
        Intent intent = getIntent();
        String shadeInformation = intent.getStringExtra("Information");

        //TASK 5:
        TextView information = findViewById (R.id.textView1);
        information.setText(shadeInformation);
    }

}
