package com.example.student.intent1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    public void showLoanPayments1(View v) {
        Uri uri = Uri.parse("loan://coreservlets.com/calc");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.putExtras(LoanBundler.makeRandomizedLoanInfoBundle());
        startActivity(intent);
    }
}
