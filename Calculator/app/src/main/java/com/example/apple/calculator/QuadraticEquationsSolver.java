package com.example.apple.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class QuadraticEquationsSolver extends AppCompatActivity {

    TextView textView1,textView8,textView9;

    EditText x1,x2,x3,root1,root2;
    Button result;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadratic_equations_solver);

        textView1= (TextView) findViewById(R.id.textView1);
        textView8= (TextView) findViewById(R.id.textView8);
        textView9=(TextView)  findViewById(R.id.textView9);

        x1=(EditText) findViewById(R.id.x1);
        x2=(EditText) findViewById(R.id.x2);
        x3=(EditText) findViewById(R.id.x3);
        root1=(EditText) findViewById(R.id.root1);
        root2=(EditText) findViewById(R.id.root2);
        result=(Button) findViewById(R.id.resultButton);


        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                getRoots(view);
            }
        });

    }

    public void getRoots(View view){
        String c1=x1.getText().toString();
        String c2=x2.getText().toString();
        String c3=x3.getText().toString();

        if(c1.isEmpty() || c2.isEmpty() || c3.isEmpty()){
            Toast.makeText(QuadraticEquationsSolver.this,"Enter number",Toast.LENGTH_SHORT).show();

            //noinspection UnnecessaryReturnStatement
            return;
        }
       else if((c1.equals(".") || c1.equals("-")) || ( c2.equals(".") || c2.equals("-"))  || (c3.equals(".") || c3.equals("-"))){
            Toast.makeText(QuadraticEquationsSolver.this,"Enter number",Toast.LENGTH_SHORT).show();

            //noinspection UnnecessaryReturnStatement
            return;
        }


else{
            double a= Double.parseDouble(x1.getText().toString());
            double b= Double.parseDouble(x2.getText().toString());
            double c= Double.parseDouble(x3.getText().toString());
            double r1, r2;
            double determinant = b * b - 4 * a * c;





            if(a==0 ){
                Toast.makeText(this,"Invalid",Toast.LENGTH_SHORT).show();
                return;
            }

            // condition for real and different roots
            if(determinant > 0) {
                r1 = (-b + Math.sqrt(determinant)) / (2 * a);
                r2 = (-b - Math.sqrt(determinant)) / (2 * a);

                //  String str1=Double.toString(r1);
                //  String str2=Double.toString(r2);

                root1.setText(Double.toString(r1));
                root2.setText(Double.toString(r2));




            }
            // Condition for real and equal roots
            else if(determinant == 0) {
                r1 = r2 = -b / (2 * a);
                // String str1=Double.toString(r1);
                //String str2=Double.toString(r2);
                root1.setText(Double.toString(r1));
                root2.setText(Double.toString(r1));


            }
            // If roots are not real
            else {
                double realPart = -b / (2 *a);
                double imaginaryPart = Math.sqrt(-determinant) / (2 * a);
                String str1=Double.toString(realPart);
                String str2=Double.toString(imaginaryPart);
                root1.setText(str1+"+i"+str2);
                root2.setText(str1+"-i"+str2);


            }




        }


    }




}
