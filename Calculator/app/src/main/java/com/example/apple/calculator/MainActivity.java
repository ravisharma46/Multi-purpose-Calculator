package com.example.apple.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button sqrt_root,arth_operation,button3,button4,quad_equation,loan_payment,button7,button8;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sqrt_root= (Button) findViewById(R.id.button1);
        arth_operation= (Button) findViewById(R.id.button2);
        button3= (Button) findViewById(R.id.button3);
        button4= (Button) findViewById(R.id.button4);
        quad_equation= (Button) findViewById(R.id.button5);
        loan_payment= (Button) findViewById(R.id.button6);
        button7= (Button) findViewById(R.id.button7);
        button8= (Button) findViewById(R.id.button8);

        quad_equation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,QuadraticEquationsSolver.class);
                startActivity(intent);
            }
        });

        sqrt_root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,squareRoot.class);
                startActivity(intent);
            }
        });

        loan_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,loan_payment_calculate.class);
                startActivity(intent);
            }
        });


        arth_operation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,arithmeticOperations.class);
                startActivity(intent);
            }
        });
    }
}
