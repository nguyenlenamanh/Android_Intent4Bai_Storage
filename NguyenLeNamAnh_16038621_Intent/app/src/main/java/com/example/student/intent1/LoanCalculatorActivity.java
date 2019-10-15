package com.example.student.intent1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LoanCalculatorActivity extends AppCompatActivity {

    private double mLoanAmount=100000, mAnnualInterestRateInPercent=5.0;
    private long mLoanPeriodInMonths=360;
    private String mCurrencySymbol = "$";

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loan_payment);
        setInputsFromExtras();
        setInputsFromUri();
        calculateAndSetOutputValues();
    }

    private void setInputsFromUri() {
        Uri uri = getIntent().getData();
        if (uri != null) {
            double loanAmount = getDoubleParam(uri, "loanAmount");
            double annualInterestRateInPercent =
                    getDoubleParam(uri, "annualInterestRateInPercent");
            long loanPeriodInMonths =
                    getLongParam(uri, "loanPeriodInMonths");
            String currencySymbol =
                    uri.getQueryParameter("currencySymbol");
            setInputs(loanAmount, annualInterestRateInPercent,
                    loanPeriodInMonths, currencySymbol);
        }
    }

    private double getDoubleParam(Uri uri, String queryParamName) {
        String rawValue = uri.getQueryParameter(queryParamName);
        double value = 0.0;
        try {
            value = Double.parseDouble(rawValue);
        } catch(Exception e) { } // NumberFormatEx or NullPointerEx
        return(value);
    }

    private long getLongParam(Uri uri, String queryParamName) {
        String rawValue = uri.getQueryParameter(queryParamName);
        long value = 0;
        try {
            value = Long.parseLong(rawValue);
        } catch(Exception e) { } // NFE or NPE
        return(value);
    }

    private void setInputsFromExtras() {
        Intent intent = getIntent();
        Bundle loanInfo = intent.getExtras();

        if (loanInfo != null) {
            double loanAmount = loanInfo.getDouble("loanAmount");
            double annualInterestRateInPercent = loanInfo.getDouble("annualInterestRateInPercent");
            long loanPeriodInMonths = loanInfo.getLong("loanPeriodInMonths");
            String currencySymbol = loanInfo.getString("currencySymbol");
            setInputs(loanAmount, annualInterestRateInPercent, loanPeriodInMonths,  currencySymbol);
        }
    }

    private void setInputs(double loanAmount, double annualInterestRateInPercent, long loanPeriodInMonths, String currencySymbol) {
        if (loanAmount > 0) {
            mLoanAmount = loanAmount;
        }
        if (annualInterestRateInPercent > 0) {
            mAnnualInterestRateInPercent = annualInterestRateInPercent;
        }
        if (loanPeriodInMonths > 0) {
            mLoanPeriodInMonths = loanPeriodInMonths;
        }
        if (currencySymbol != null) {
            mCurrencySymbol = currencySymbol;
        }
    }

    private void calculateAndSetOutputValues() {
        PaymentInfo paymentInfo = new PaymentInfo(mLoanAmount, mAnnualInterestRateInPercent, mLoanPeriodInMonths, mCurrencySymbol);

        TextView loanAmountDisplay = findViewById(R.id.loan_amount);
        loanAmountDisplay.setText(paymentInfo.getFormattedLoanAmount());

        TextView interestRateDisplay = findViewById(R.id.interest_rate);
        interestRateDisplay.setText (paymentInfo.getFormattedAnnualInterestRateInPercent());

        TextView loanPeriodDisplay = findViewById(R.id.loan_period);
        loanPeriodDisplay.setText(paymentInfo.getFormattedLoanPeriodInMonths());

        TextView monthlyPaymentDisplay = findViewById(R.id.monthly_payment);
        monthlyPaymentDisplay.setText(paymentInfo.getFormattedMonthlyPayment());

        TextView totalPaymentsDisplay = findViewById(R.id.total_payments);
        totalPaymentsDisplay.setText(paymentInfo.getFormattedTotalPayments());
    }
}
