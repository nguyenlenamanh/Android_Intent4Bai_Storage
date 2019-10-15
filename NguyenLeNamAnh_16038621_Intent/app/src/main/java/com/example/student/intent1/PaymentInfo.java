package com.example.student.intent1;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class PaymentInfo {
    private double mLoanAmount, mAnnualInterestRateInPercent, mMonthlyPayment, mTotalPayments;
    private long mLoanPeriodInMonths = 0;
    private final String mCurrencySymbol;

    NumberFormat formatter;

    public PaymentInfo(double loanAmount, double annualInterestRateInPercent, long loanPeriodInMonths, String currencySymbol) {
        mLoanAmount = loanAmount;
        mAnnualInterestRateInPercent = annualInterestRateInPercent;
        mMonthlyPayment = loanPeriodInMonths;
        mCurrencySymbol = currencySymbol;

        mLoanPeriodInMonths = loanPeriodInMonths;

        mMonthlyPayment = LoanUtils.monthlyPayment(loanAmount, annualInterestRateInPercent, loanPeriodInMonths);
        mTotalPayments = mMonthlyPayment * mLoanPeriodInMonths;

        formatter =  NumberFormat.getCurrencyInstance();
    }

    public String getFormattedLoanAmount() {
        return formatter.format(mLoanAmount);
    }

    public String getFormattedAnnualInterestRateInPercent() {
        return new DecimalFormat("##.##").format(mAnnualInterestRateInPercent) + "%";
    }

    public String getFormattedLoanPeriodInMonths() {
        return Long.toString(mLoanPeriodInMonths);
    }

    public String getFormattedMonthlyPayment() {
        return formatter.format(mMonthlyPayment);
    }

    public String getFormattedTotalPayments() {
        return formatter.format(mTotalPayments);
    }
}
