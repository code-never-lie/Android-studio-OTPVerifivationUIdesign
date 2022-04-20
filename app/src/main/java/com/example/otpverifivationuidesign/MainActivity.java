package com.example.otpverifivationuidesign;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.chaos.view.PinView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
private PinView pinView;
private Button next;
private EditText userName,userPhone;
private ConstraintLayout first,second;
private TextView textViewU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pinView=findViewById(R.id.pinView);
        next=findViewById(R.id.button);
        userName=findViewById(R.id.editText);
        userPhone=findViewById(R.id.editText2);
        first=findViewById(R.id.first_step);
        second=findViewById(R.id.second_step);
        textViewU=findViewById(R.id.textU);
        first.setVisibility(View.VISIBLE);


        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(next.getText().equals("Let's Go!")){
            String name=userName.getText().toString();
            String phone=userPhone.getText().toString();

            if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(phone)){
                next.setText("Verify");
                first.setVisibility(View.GONE);
                second.setVisibility(View.VISIBLE);
            }
            else{
                Toast.makeText(MainActivity.this, "Please enter the details", Toast.LENGTH_SHORT).show();
            }
        }
        else if(next.getText().equals("Verify")){
            String OTP=pinView.getText().toString();
            if(OTP.equals("3456")){
                pinView.setLineColor(Color.GREEN);
                textViewU.setText("OTP Verified");
                textViewU.setTextColor(Color.GREEN);
            }
            else{
                pinView.setLineColor(Color.RED);
                textViewU.setText("x Incorrect OTP");
                textViewU.setTextColor(Color.RED);
            }
        }

    }
}
