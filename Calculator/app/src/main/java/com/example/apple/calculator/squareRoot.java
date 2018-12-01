package com.example.apple.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class squareRoot extends AppCompatActivity {

    EditText n1,ans;
    Button result1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square_root);

        n1= (EditText) findViewById(R.id.number);
        ans= (EditText) findViewById(R.id.answer);
        result1=(Button) findViewById(R.id.inputText);

        result1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getResult(view);
            }
        });
    }

    public void getResult(View view){


        String str= n1.getText().toString().trim();

        if(str.isEmpty()){
            Toast.makeText(squareRoot.this,"Enter number",Toast.LENGTH_SHORT).show();
            //noinspection UnnecessaryReturnStatement
            return;
        }

        else if(str.equals(".")){
            Toast.makeText(squareRoot.this,"Enter number",Toast.LENGTH_SHORT).show();
            //noinspection UnnecessaryReturnStatement
            return;
        }
        else{
            double a= Math.sqrt(Double.parseDouble(str));
            ans.setText(Double.toString(a));
        }





    }


}
