package com.example.jazzzzum.labquiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    String username, password;
    EditText et_username;
    EditText et_password;
    Button btn_remember;
    Button btn_login;
    SharedPreferences loginPreferences;
    SharedPreferences.Editor loginPrefsEditor;
    Boolean saveLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_username = (EditText) findViewById(R.id.etusername);
        et_password = (EditText) findViewById(R.id.etpassword);
        btn_remember = (Button) findViewById(R.id.btnremember);
        btn_login = (Button) findViewById(R.id.btnlogin);
        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();

        saveLogin = loginPreferences.getBoolean("saveLogin", false);
        if (saveLogin == true) {
            et_username.setText(loginPreferences.getString("username", ""));
            et_password.setText(loginPreferences.getString("password", ""));
            btn_remember.callOnClick();
        }
    }

    public void onClick(View view) {
        if (view == btn_login) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(et_username.getWindowToken(), 0);

            username = et_username.getText().toString();
            password = et_password.getText().toString();

            if (btn_remember.callOnClick()) {
                loginPrefsEditor.putBoolean("saveLogin", true);
                loginPrefsEditor.putString("username", username);
                loginPrefsEditor.putString("password", password);
                loginPrefsEditor.commit();
            } else {
                loginPrefsEditor.clear();
                loginPrefsEditor.commit();
            }
        }
    }

    public void nextactivity (View view){
        Intent intent = new Intent(this, NextActivity.class);
        startActivity(intent);
    }
}
