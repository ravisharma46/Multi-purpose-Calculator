package com.example.apple.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loan_payment_calculate extends AppCompatActivity {

    EditText amount,rate_interest,year;
    TextView  answer,paymentText;
    Button result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_payment_calculate);

        amount= (EditText) findViewById(R.id.amount);
        rate_interest= (EditText) findViewById(R.id.rate);
        year= (EditText) findViewById(R.id.year);
        answer=(TextView) findViewById(R.id.resultView);
        paymentText=(TextView) findViewById(R.id.paymentText);
        result=(Button) findViewById(R.id.calculate);

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getResult(view);
            }
        });

    }

    public void getResult(View view){

        String a= amount.getText().toString().trim();
        String r= rate_interest.getText().toString().trim();
        String y= year.getText().toString().trim();

        if((a.isEmpty() || a.equals("."))||( r.isEmpty() || r.equals("."))|| (y.isEmpty() || y.equals("."))){
            Toast.makeText(loan_payment_calculate.this," Please enter number",Toast.LENGTH_SHORT).show();
            return;
        }



        double am_unt= Double.parseDouble(a);
        double r_te= Double.parseDouble(r);
        double ye_r= Double.parseDouble(y);
        int x=1;

        if(ye_r>50 || ye_r<0){
            Toast.makeText(loan_payment_calculate.this,"year's can't be more than 50",Toast.LENGTH_SHORT).show();
            return;
        }

        if( r_te>100 || r_te<0){
            Toast.makeText(loan_payment_calculate.this,"Interest rate can't be more than 100",Toast.LENGTH_SHORT).show();
            return;
        }


        r_te = r_te / (12 * 100); // one month interest
        ye_r = ye_r * 12; // one month period
       double emi;
        emi = (am_unt * r_te * (float)Math.pow(1 + r_te, ye_r))
                 / (float) (Math.pow(1 + r_te, ye_r) - 1);

        answer.setText("Rs."+Double.toString(emi));



    }

}
