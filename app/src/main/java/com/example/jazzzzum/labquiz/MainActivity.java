package com.example.jazzzzum.labquiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jazzzzum.labquiz.NextActivity;

public class MainActivity extends AppCompatActivity {
    SharedPreferences preferences;
    EditText etuser, etpass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etuser = (EditText)findViewById(R.id.et_user);
        etpass = (EditText)findViewById(R.id.et_pass);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);

    }

    public void Login (View view) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", etuser.getText().toString());
        editor.putString("password", etpass.getText().toString());
        editor.commit();
        Nextact();

    }
    public void rememberme (View view){
        String username = preferences.getString("username","");
        String password = preferences.getString("password","");

        etuser.setText(username,TextView.BufferType.EDITABLE);
        etpass.setText(password,TextView.BufferType.EDITABLE);

    }
    public void Nextact (){
        Intent intent = new Intent(this, NextActivity.class);

        startActivity(intent);

    }
}