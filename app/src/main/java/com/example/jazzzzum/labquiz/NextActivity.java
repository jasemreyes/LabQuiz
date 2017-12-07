package com.example.jazzzzum.labquiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {
    TextView tvdisplay;
    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        tvdisplay = (TextView)findViewById(R.id.tv_display);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        Loadpref();

    }
    public void Loadpref(){
        String user = preferences.getString("username","");
        tvdisplay.setText(user);
    }

    public void Logout(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}