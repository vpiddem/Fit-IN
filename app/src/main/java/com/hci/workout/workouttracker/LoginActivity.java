package com.hci.workout.workouttracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;



public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
    }

    public void signIn(View view) {
        Intent intent  = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
