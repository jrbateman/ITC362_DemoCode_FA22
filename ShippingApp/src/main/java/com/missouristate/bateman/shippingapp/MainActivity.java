package com.missouristate.bateman.shippingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //DATA MODEL FOR SHIP ITEM

    private ShipItem shipItem;

    //VIEW OBJECTS FOR LAYOUT UI REFERENCE

    private EditText weightET;
    private TextView baseCostTV;
    private TextView addedCostTV;
    private TextView totalCostTV;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TASK 1 CREATE THE DATA MODEL FOR STORING THE ITEM TO BE SHIPPED

        shipItem = new ShipItem();

        //TASK 2: ESTABLISH THE REFERENCES TO INPUT WEIGHT ELEMENT

        weightET = findViewById(R.id.editText1);


        //TASK 3: ESTABLISH THE REFERENCES TO OUTPUT ELEMENTS
        baseCostTV = findViewById(R.id.textView4);
        addedCostTV = findViewById(R.id.textView6);
        totalCostTV = findViewById(R.id.textView8);


        //TASK 4: REGISTER THE LISTENER EVENT FOR WEIGHT INPUT

        weightET.addTextChangedListener(weightTextWatcher);
    }

    private TextWatcher weightTextWatcher = new TextWatcher() {

        //THE INPUT ELEMENT IS ATTACHED TO AN EDITABLE,
        //THEREFORE THESE METHODS ARE CALLED WHEN THE TEXT IS CHANGED

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            //CATCH AN EXCEPTION WHEN THE INPUT IS NOT A NUMBER
            try {
                shipItem.setWeight((int)Double.parseDouble(s.toString()));
            }
            catch (NumberFormatException e) {
               shipItem.setWeight(0);
            }

            displayShipping();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private void displayShipping() {

        //DISPLAY THE BASE COST, ADDED COST, AND TOTAL COST
        baseCostTV.setText("$" + String.format("%.02f",
                shipItem.getBaseCost()));
        addedCostTV.setText("$" + String.format("%.02f",
                shipItem.getAddedCost()));
        totalCostTV.setText("$" + String.format("%.02f",
                shipItem.getTotalCost()));


    }


    //THE INPUT ELEMENT IS ATTACHED TO AN EDITABLE,
    //THEREFORE THESE METHODS ARE CALLED WHEN THE TEXT IS CHANGED



    // Show how TextWatcher creates required override methods


    //DISPLAY THE BASE COST, ADDED COST, AND TOTAL COST

}
