package com.bateman.stopwatch;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MyActivity extends AppCompatActivity {

    // UI ELEMENTS: BUTTONS WILL TOGGLE IN VISIBILITY
    private TextView timeDisplay;
    private Button startBtn;
    private Button stopBtn;
    private Button resetBtn;

    // TIME ELEMENTS
    private WatchTime watchTime;
    private long timeInMilliseconds = 0L;
    private Handler mHandler;

    // THE HANDLER FOR THE THREAD ELEMENT


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TASK 1: ACTIVATE THE ACTIVITY AND THE LAYOUT
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        // TASK 2: CREATE REFERENCES TO UI COMPONENTS
        timeDisplay = findViewById(R.id.textView1);
        startBtn = findViewById(R.id.button1);
        stopBtn =  findViewById(R.id.button2);
        resetBtn = findViewById(R.id.button3);

        // TASK 3: HIDE THE STOP BUTTON
        stopBtn.setEnabled(false);

        // TASK 4: INSTANTIATE THE OBJECT THAT MODELS THE STOPWATCH TIME
        watchTime = new WatchTime();

        //TASK 5: INSTANTIATE A HANDLER TO RUN ON THE UI THREAD

    }

    public void startTimer(View view) {
        // TASK 1: SET THE START BUTTON TO INVISIBLE
        //         AND THE STOP BUTTON TO VISIBLE
        stopBtn.setEnabled(true);
        startBtn.setEnabled(false);
        resetBtn.setEnabled(false);

        // TASK 2: SET THE START TIME AND CALL THE CUSTOM HANDLER
        watchTime.setStartTime(SystemClock.uptimeMillis());
        mHandler.postDelayed(updateTimerRunnable, 20);
    }

    private Runnable updateTimerRunnable = new Runnable() {
        public void run() {

            // TASK 1: COMPUTE THE TIME DIFFERENCE
            timeInMilliseconds = SystemClock.uptimeMillis() - watchTime.getStartTime();
            watchTime.setTimeUpdate(watchTime.getStoredTime() + timeInMilliseconds);
            int time = (int) (watchTime.getTimeUpdate() / 1000);

            // TASK 2: COMPUTE MINUTES, SECONDS, AND MILLISECONDS
            int minutes = time / 60;
            int seconds = time % 60;
            int milliseconds = (int) (watchTime.getTimeUpdate() % 100);

            // TASK 3: DISPLAY THE TIME IN THE TEXTVIEW
            timeDisplay.setText(String.format("%02d", minutes) + ":"
                    + String.format("%02d", seconds) + ":"
                    + String.format("%02d", milliseconds));

            // TASK 4: SPECIFY NO TIME LAPSE BETWEEN POSTING
            mHandler.postDelayed(this, 0);
        }
    };

    public void stopTimer(View view) {
        // TASK 1: DISABLE THE START BUTTON
        //         AND ENABLE THE STOP BUTTON
        stopBtn.setEnabled(false);
        startBtn.setEnabled(true);
        resetBtn.setEnabled(true);

        // TASK 2: UPDATE THE TIME SWAP VALUE AND CALL THE HANDLER
        watchTime.addStoredTime(timeInMilliseconds);
        mHandler.removeCallbacks(updateTimerRunnable);
    }

    public void resetTimer(View view) {
        watchTime.resetWatchTime();
        timeInMilliseconds = 0L;

        int minutes = 0;
        int seconds = 0;
        int milliseconds = 0;

        // TASK 3: DISPLAY THE TIME IN THE TEXTVIEW
        timeDisplay.setText(String.format("%02d", minutes) + ":"
                + String.format("%02d", seconds) + ":"
                + String.format("%02d", milliseconds));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
