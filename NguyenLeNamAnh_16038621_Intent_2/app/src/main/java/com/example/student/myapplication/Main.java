package com.example.student.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showLoanPayments1(View v) {
        Uri uri = Uri.parse("loan://coreservlets.com/calc");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.putExtras(LoanBundler.makeRandomizedLoanInfoBundle());
        startActivity(intent);
    }

    public void showLoanPayments2(View v) {
        String address = makeLoanAddressFromEditTextInputs();
        Uri uri = Uri.parse(address);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private String makeLoanAddressFromEditTextInputs() {
        EditText loanAmountInput = findViewById(R.id.loan_amount);
        Editable loanAmount = loanAmountInput.getText();
        String loanAmountParam =
                String.format("loanAmount=%s", loanAmount);
        EditText interestRateInput = findViewById(R.id.interest_rate);
        Editable interestRate = interestRateInput.getText();
        String interestRateParam =
                String.format("annualInterestRateInPercent=%s", interestRate);
        EditText loanPeriodInput = findViewById(R.id.loan_period);
        Editable loanPeriod = loanPeriodInput.getText();
        String loanPeriodParam =
                String.format("loanPeriodInMonths=%s", loanPeriod);
        String baseAddress = "loan://coreservlets.com/calc";
        String address = String.format("%s?%s&%s&%s", baseAddress, loanAmountParam, interestRateParam, loanPeriodParam);
        return(address);
    }
}
