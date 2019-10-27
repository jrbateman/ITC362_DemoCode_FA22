package com.bateman.unitconversioncalculator;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.TextView;


public class MyActivity extends Activity {

    private TextView inputLabel;
    private TextView outputLabel;
    private TextView outputMeasurement;
    private EditText inputMeasurement;

    Conversion conversion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        setUpImageDisplay();

    }

    private void setUpImageDisplay() {
        inputLabel = findViewById(R.id.textView1);
        inputLabel.setText(conversion.intputLabel);

        outputLabel = findViewById(R.id.textView2);
        outputLabel.setText(conversion.outputLabel);

        outputMeasurement = findViewById(R.id.textView3);
        outputMeasurement.setText(conversion.outputValue.toString());

        inputMeasurement = findViewById(R.id.editText1);
        inputMeasurement.setText(conversion.inputValue.toString());
        inputMeasurement.addTextChangedListener(inputTextWatcher);
    }

    private TextWatcher inputTextWatcher = new TextWatcher() {
        //THE INPUT ELEMENT IS ATTACHED TO AN EDITABLE,
        //THEREFORE THESE METHODS ARE CALLED WHEN THE TEXT IS CHANGED

        public void onTextChanged(CharSequence s, int start, int before, int count){
            //CATCH AN EXCEPTION WHEN THE INPUT IS NOT A NUMBER
            try {
                conversion.inputValue =  Double.parseDouble(s.toString());
            }catch (NumberFormatException e){
                conversion.inputValue = 0.0;
            }
            conversion.compute();
            outputMeasurement.setText(conversion.outputValue.toString());

        }
        public void afterTextChanged(Editable s) {}
        public void beforeTextChanged(CharSequence s, int start, int count, int after){}
    };


    private void resetDisplay() {
        inputLabel.setText(conversion.intputLabel);
        outputLabel.setText(conversion.outputLabel);
        outputMeasurement.setText(conversion.outputValue.toString());
        inputMeasurement.setText(conversion.inputValue.toString());
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            toggleActionBar();
        }
        return true;
    }

    private void toggleActionBar() {
        ActionBar actionBar = getActionBar();

        if(actionBar != null) {
            if(actionBar.isShowing()) {
                actionBar.hide();
            }
            else {
                actionBar.show();
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.menuitem_feet_meters){
            conversion.switch_toFeetMeters();
            resetDisplay();
            return true;
        }
        else if (id == R.id.menuitem_inches_cent){
            conversion.switch_toInchesCentimeters();
            resetDisplay();
            return true;
        }
        else if (id == R.id.menuitem_pounds_grams){
            conversion.switch_toPoundsGrams();
            resetDisplay();
            return true;
        }
        else if (id == R.id.menuitem_quit){
            //CLOSE ACTIVITY
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
