package com.example.myfirstappsp22v2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView tv = findViewById(R.id.tv_1);
                String stringValue = tv.getText().toString();
                Integer originalValue = Integer.parseInt(stringValue);
                Integer newValue = MyHelper.doubleMyValue(originalValue);
                tv.setText(newValue.toString());

                Snackbar.make(view, "The number  " + originalValue + " has been doubled to: " + newValue, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}