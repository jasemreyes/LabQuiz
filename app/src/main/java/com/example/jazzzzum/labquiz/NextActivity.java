package com.example.jazzzzum.labquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {
    TextView tv_display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        tv_display = (TextView) findViewById(R.id.tvdisplay);
    }
    public void logout(View view){
        Intent myIntent = new Intent(this, MainActivity.class);
        NextActivity.this.startActivity(myIntent);
    }
}
