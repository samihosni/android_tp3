package com.example.tp3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityFailed extends AppCompatActivity {
    TextView avg;
    EditText numTel;
    Button sms;

    String moy;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_failed);
        avg = findViewById(R.id.textView8);
        numTel=findViewById(R.id.editTextText5);
        sms=findViewById(R.id.button4);

        Intent intent=getIntent();
        moy = intent.getStringExtra("average");
        float averageValue = Float.parseFloat(moy);

        avg.setText("You failed ! :" +averageValue );
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
        intent.putExtra("sms_body",("You failed ! : "+moy));
        startActivity(intent);
    }
}
