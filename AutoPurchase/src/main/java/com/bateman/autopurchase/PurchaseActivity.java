package com.bateman.autopurchase;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class PurchaseActivity extends Activity {
    // THE AUTO OBJECT CONTAINS THE INFORMATION ABOUT THE VEHICLE BEING PURCHASED
    Auto mAuto;

    // THE DATA TO BE PASSED TO THE LOAN ACTIVITY
    String loanReport;
    String monthlyPayment;

    // LAYOUT INPUT REFERENCES
    private EditText carPriceET;
    private EditText downPayET;
    private RadioGroup loanTermRG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.purchase_layout);

        //ESTABLISH REFERENCES TO EDITABLE TEXT FIELDS AND RADIO BUTTON
        carPriceET = findViewById(R.id.editText1);
        downPayET = findViewById(R.id.editText2);
        loanTermRG = findViewById(R.id.radioGroup1);

        //CREATE AN AUTOMOBILE OBJECT TO STORE AUTO DATA
        mAuto = new Auto();
    }

    private void collectAutoInputData() {
        // TASK 1: SET THE CAR PRICE
        mAuto.setPrice ((double) Integer.valueOf(carPriceET.getText()
                .toString()));

        //TASK 2: SET THE DOWN PAYMENT
        mAuto.setDownPayment((double)
                Integer.valueOf(downPayET.getText()
                        .toString()));

        //TASK 3 SET THE LOAN TERM
        Integer radioId = loanTermRG.getCheckedRadioButtonId();
        RadioButton term = findViewById(radioId);
        mAuto.setLoanTerm(term.getText().toString());
    }
    private void buildLoanReport() {
        // TASK 1: CONSTRUCT THE MONTHLY PAYMENT
        Resources res = getResources();
        monthlyPayment = res.getString(R.string.report_line1)
                + String.format("%.02f", mAuto.monthlyPayment());


        // TASK 2: CONSTRUCT THE LOAN REPORT
        loanReport = res.getString(R.string.report_line6)
                + String.format("%10.02f", mAuto.getPrice());
        loanReport += res.getString(R.string.report_line7)
                + String.format("%10.02f", mAuto.getDownPayment());

        loanReport += res.getString(R.string.report_line9)
                + String.format("%18.02f", mAuto.taxAmount());
        loanReport += res.getString(R.string.report_line10)
                + String.format("%18.02f", mAuto.totalCost());
        loanReport += res.getString(R.string.report_line11)
                + String.format("%12.02f", mAuto.borrowedAmount());
        loanReport += res.getString(R.string.report_line12)
                + String.format("%12.02f", mAuto.interestAmount());

        loanReport += "\n\n" + res.getString(R.string.report_line8) + " " + mAuto.getLoanTerm() + " years.";

        loanReport += "\n\n" + res.getString(R.string.report_line2);
        loanReport += res.getString(R.string.report_line3);
        loanReport += res.getString(R.string.report_line4);
        loanReport += res.getString(R.string.report_line5);

    }

    public void activateLoanSummary(View view) {
        //TASK 1: BUILD A LOAN REPORT FROM THE INPUT DATA
        collectAutoInputData();
        buildLoanReport();

        //TASK 2: CREATE AN INTENT TO DISPLAY THE LOAN SUMMARY ACTIVITY


        //TASK 3: PASS THE LOAN SUMMARY ACTIVITY TWO PIECES OF DATA:
        //     THE LOAN REPORT CONTAINING LOAN DETAILS
        //     THE MONTHLY PAYMENT

        //TASK 4: START THE LOAN ACTIVITY

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu;
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
