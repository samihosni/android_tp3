package com.example.tp3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
        EditText mark1;
        EditText mark2;
        EditText mark3;
        Button calculate;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mark1=findViewById(R.id.editTextText);
        mark2=findViewById(R.id.editTextText2);
        mark3=findViewById(R.id.editTextText3);
        calculate=findViewById(R.id.button);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAverage();
            }
        });

    }

    public void calculateAverage(){
        String value1= mark1.getText().toString();
        String value2= mark2.getText().toString();
        String value3= mark3.getText().toString();

        if (value1.isEmpty() || value2.isEmpty() || value3.isEmpty()){
            Toast.makeText(this,"Please fill out all the marks !", Toast.LENGTH_SHORT).show();

        }else {
            Float m1 = Float.parseFloat(value1);
            Float m2 = Float.parseFloat(value2);
            Float m3 = Float.parseFloat(value3);
             float som= m1 + m2 + m3;
             float average = som/3;

        if (average > 10){
                // success
            Intent intent =new Intent(this, ActivitySuccess.class);
            intent.putExtra("average", Float.toString(average));
            startActivity(intent);
        } else {
                // failed
            Intent intent =new Intent(this, ActivityFailed.class);
            intent.putExtra("average", Float.toString(average));
            startActivity(intent);
        }

    }
    }
}
