package com.example.student.intent1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class IntentFilter1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void showLoanPayments1(View v) {
        Intent activityIntent = new Intent(this, LoanCalculatorActivity.class);
        startActivity(activityIntent);
    }

    public void showLoanPayments2(View clickedButton) {
        Intent activityIntent = new Intent(this, LoanCalculatorActivity.class);
        activityIntent.putExtras (LoanBundler.makeRandomizedLoanInfoBundle());
        startActivity(activityIntent);
    }

    public void showLoanPayments3(View clickedButton) {
        Intent activityIntent = new Intent(this, TabActivity.class);
       // activityIntent.putExtras (LoanBundler.makeRandomizedLoanInfoBundle());
        startActivity(activityIntent);
    }

}
