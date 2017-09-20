package com.example.sandaru.styleomega.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sandaru.styleomega.DBmanage.DbHelper;
import com.example.sandaru.styleomega.Helper_Validate.ValidateInput;
import com.example.sandaru.styleomega.R;


public class EditProfileActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editnametxt;
    EditText currentpasstxt;
    EditText newpasstxt;
    EditText newpasstxt2;

    Button namesubmit;
    Button passsubmit;

    ValidateInput validate;
    DbHelper db;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        editnametxt = (EditText) findViewById(R.id.editnametxt);
        currentpasstxt = (EditText) findViewById(R.id.currentpasstxt);
        newpasstxt = (EditText) findViewById(R.id.newpasstxt);
        newpasstxt2 = (EditText) findViewById(R.id.newpasstt2);
        namesubmit = (Button) findViewById(R.id.submitname);
        passsubmit = (Button) findViewById(R.id.submitpass);


        validate = new ValidateInput(this);
        db = new DbHelper(this);
        Intent i = getIntent();
        email = i.getStringExtra("EMAIL");
        namesubmit.setOnClickListener(this);
        passsubmit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
            String msg;
        if(v.getId() == namesubmit.getId()){
            if(!validate.isNameEmpty(editnametxt.getText().toString())) {
                msg = db.updateUser(email, 1, editnametxt.getText().toString().trim(), null);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                editnametxt.setText("");
            }
        }
        if(v.getId() == passsubmit.getId()){
            if(newpasstxt.getText().toString().trim().equals(newpasstxt2.getText().toString().trim())) {
                if(!validate.isNameEmpty(newpasstxt.getText().toString().trim()) && validate.isNameEmpty(newpasstxt2.getText().toString().trim())) {

                    msg = db.updateUser(email, 2, newpasstxt.getText().toString().trim(), currentpasstxt.getText().toString().trim());
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                    currentpasstxt.setText("");
                    newpasstxt.setText("");
                    newpasstxt2.setText("");
                }
            }
            else {
                Toast.makeText(getApplicationContext(), "New passwords don't match", Toast.LENGTH_SHORT).show();
                newpasstxt.setText("");
                newpasstxt2.setText("");
            }

        }

    }
}
