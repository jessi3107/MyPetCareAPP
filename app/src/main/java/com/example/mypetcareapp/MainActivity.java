package com.example.mypetcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, RegistroActivity.class);
        startActivity(intent);
    }

    public void sendMessage2(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, RegistroPerfilMascotaActivity.class);
        startActivity(intent);
    }
}