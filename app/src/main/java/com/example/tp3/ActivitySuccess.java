package com.example.tp3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class ActivitySuccess extends AppCompatActivity {
    TextView avg;
    EditText numTel;
    Button sms;
    String res;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        avg = findViewById(R.id.textView7);
        numTel=findViewById(R.id.editTextText4);
        sms=findViewById(R.id.button2);

        Intent intent=getIntent();
        res = intent.getStringExtra("average");
        float averageValue = Float.parseFloat(res);


        avg.setText("Congratulations :" + averageValue );
        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSms();
            }
        });

    }

    private void sendSms(){
        Intent intent=new Intent(Intent.ACTION_SENDTO);
        String num = numTel.getText().toString();
        Uri uri= Uri.parse("smsto:"+num);
        intent.setData(uri);
        intent.putExtra("sms_body",("Congratulations ! : " +res));
        startActivity(intent);
    }
}
