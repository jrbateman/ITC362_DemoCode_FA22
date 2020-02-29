package com.bateman.paintcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MyActivity extends AppCompatActivity {

    //OBJECT THAT REPRESENTS A ROOM TO BE PAINTED
    private InteriorRoom mRoom;

    //EDIT TEXTS FOR USER INPUT
    private EditText lengthET;
    private EditText widthET;
    private EditText heightET;
    private EditText nDoorsET;
    private EditText nWindowsET;

    // TEXT VIEW FOR DISPLAYING THE PAINT JOB CALCULATION
    private TextView nGallonsV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        //OBTAIN REFERENCES TO UI ELEMENTS IN THE MAIN LAYOUT
        referenceUIcomponents();

        //CREATE A ROOM
        mRoom = new InteriorRoom();
    }

    private void referenceUIcomponents() {
        lengthET = findViewById(R.id.editText);
        widthET = findViewById(R.id.editText);
        heightET = findViewById(R.id.editText);
        nDoorsET = findViewById(R.id.editText4);
        nWindowsET = findViewById(R.id.editText5);
        nGallonsV = findViewById(R.id.textView9);
    }

    public void computeGallons (View view) {
        //TASK 1: SET ROOM DIMENSIONS FROM  USER INPUT
        double l = Double.valueOf(lengthET.getText().toString());
        double w = Double.valueOf(widthET.getText().toString());
        double h = Double.valueOf(heightET.getText().toString());
        mRoom.setLength(l);
        mRoom.setWidth(w);
        mRoom.setHeight(h);

        //TASK 2: SET THE NUMBER OF DOORS AND WINDOWS FROM USER INPUT
        int doors = Integer.valueOf(nDoorsET.getText().toString());
        int windows = Integer.valueOf(nWindowsET.getText().toString());
        mRoom.setDoors(doors);
        mRoom.setWindows(windows);


        //TASK 3: DISPLAY THE AREA THAT WILL BE PAINTED AND THE GALLONS NEEDED

        nGallonsV.setText("Interior surface area: " + "Happy" + " feet"
                + "\nGallons needed: " );
    }

    public void gotoHelp(View view){
        startActivity(new Intent(MyActivity.this, HelpActivity.class));
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
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
