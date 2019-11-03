package com.bateman.touchgesturesexperiment1;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;


public class MyActivity extends Activity implements
        GestureDetector.OnDoubleTapListener,
        GestureDetector.OnGestureListener {

    private GestureDetector aGesture;
    private TextView mTouchLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        mTouchLog = findViewById(R.id.textView2);

        aGesture = new GestureDetector(this, this);
        aGesture.setOnDoubleTapListener(this);
    }

    public void clearLog(View view) {
        mTouchLog.setText(R.string.empty);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mTouchLog.append("\n\n------- touch event ------");
        return aGesture.onTouchEvent(event);
    }

    @Override
    public void onLongPress(MotionEvent event) {
        mTouchLog.append("\nonLongPress touch event");
    }

    @Override
    public void onShowPress(MotionEvent event) {
        mTouchLog.append("\nonShowPress touch event");
    }

    @Override
    public boolean onDown(MotionEvent event) {
        mTouchLog.append("\nOnDown Touch event");
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2,
                            float distanceX, float distanceY) {
        mTouchLog.append("\nonScroll: distanceX is " +
                distanceX + ", distanceY is " + distanceY);
        return true;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY) {
        mTouchLog.append("\nonFling: velocityX is " + velocityX + ", " +
                "velocityY is " + velocityY);
        return true;
    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        mTouchLog.append("\nonSingleTapUp touch event");
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent event) {
        mTouchLog.append("\nonDoubleTapUp touch event");
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent event) {
        mTouchLog.append("\nonDoubleTapUp touch event");
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent event) {
        mTouchLog.append("\nonSingleTapConfirmed");
        //Toast.makeText(this, "onSingleTapConfirmed: ", Toast.LENGTH_LONG).show();
        return true;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu;
        // this adds items to the action bar if it is present.
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
