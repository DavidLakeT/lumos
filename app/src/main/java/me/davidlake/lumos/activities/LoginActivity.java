package me.davidlake.lumos.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import me.davidlake.lumos.R;

public class LoginActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Log.d("DAVID-DEBUG", "HOLA DESDE LOGIN");

        Button signin_button = findViewById(R.id.signin_button);
        Button signup_button = findViewById(R.id.register_button);

        signin_button.setOnClickListener(v -> {
            Log.d("DAVID-DEBUG", "BOTON DE INICIO DE SESION PRESIONADO");
            //Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            //startActivity(intent);
        });

        signup_button.setOnClickListener(v -> {
            Log.d("DAVID-DEBUG", "BOTON DE REGISTRO PRESIONADO");
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }
}
