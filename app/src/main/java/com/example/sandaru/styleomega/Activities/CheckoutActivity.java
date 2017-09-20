package com.example.sandaru.styleomega.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sandaru.styleomega.R;

public class CheckoutActivity extends AppCompatActivity implements View.OnClickListener{

    TextView total;
    EditText cardno;
    EditText exdate;
    EditText vcs;
    Button btnpay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        total = (TextView) findViewById(R.id.totalcart);
        cardno = (EditText) findViewById(R.id.cardno);
        exdate = (EditText) findViewById(R.id.exdate);
        vcs = (EditText) findViewById(R.id.vcs);
        btnpay = (Button) findViewById(R.id.btnpay);

        Intent i = getIntent();
        int totalp = i.getIntExtra("total", 0);
        total.setText(Integer.toString(totalp));
        btnpay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == btnpay.getId()){
            Toast.makeText(getApplicationContext(), "Puchase successfull, your item(s) will deliver to your home soon", Toast.LENGTH_SHORT).show();

        }
    }
}
