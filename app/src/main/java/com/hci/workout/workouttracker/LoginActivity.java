package com.hci.workout.workouttracker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        boolean isLoggedIn = sharedPref.getBoolean(getString(R.string.is_logged_in),false);

        if(isLoggedIn) {
            Intent intent  = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    public void signIn(View view) {

        String email   = ((EditText)findViewById(R.id.email)).getText().toString();
        String password = ((EditText)findViewById(R.id.password)).getText().toString();
        TextView emailError =  (TextView)findViewById(R.id.email_error);
        emailError.setVisibility(View.INVISIBLE);
        TextView passwordError =  (TextView)findViewById(R.id.password_error);
        passwordError.setVisibility(View.INVISIBLE);


        boolean isError = false;
        if(email == null || email.length() == 0 )
        {
            emailError.setHint(getResources().getString(R.string.enter_email));
            emailError.setVisibility(View.VISIBLE);
            isError = true;
        }
        if(password == null || password.length() == 0 )
        {
            passwordError.setHint(getResources().getString(R.string.enter_password));
            passwordError.setVisibility(View.VISIBLE);
            isError = true;
        }
        if(isError)
            return;
        if(!(email.equals(getResources().getString(R.string.email)) && password.equals(getResources().getString(R.string.pwd))))
        {
            emailError.setHint(getResources().getString(R.string.email_pwd_incorrect));
            emailError.setVisibility(View.VISIBLE);
            return;
        }

        Intent intent  = new Intent(this, MainActivity.class);
        startActivity(intent);

        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(getString(R.string.is_logged_in), true);
        editor.commit();
    }

}
