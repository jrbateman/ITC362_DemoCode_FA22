package com.bateman.autopurchase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoanSummaryActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loansummary_layout);
        TextView monthlyPayET = findViewById(R.id.textView2);
        TextView loanReportET = findViewById(R.id.textView3);

        // PASS DATA

    }

    public void goDataEntry(View view) {
        finish();
    }
}
