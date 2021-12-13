package com.grupo4.quickmeal_v28_def;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class FormActivity extends AppCompatActivity {

    private TextView elemento;
    String name="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        elemento =(TextView) findViewById(R.id.elemento);
        Intent intent = getIntent();
        name= intent.getStringExtra("name");
        elemento.setText(name);
    }
}