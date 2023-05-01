package me.davidlake.lumos.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import me.davidlake.lumos.R;
import me.davidlake.lumos.viewmodel.UserViewModel;

public class RegisterActivity  extends AppCompatActivity {

    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Button signup_button = findViewById(R.id.signup_button);

        signup_button.setOnClickListener(v -> {

            EditText emailEditText = findViewById(R.id.email_edit_text);
            EditText passwordEditText = findViewById(R.id.password_edit_text);
            EditText identificationIdEditText = findViewById(R.id.identification_id_edit_text);

            String email = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();
            String identificationId = identificationIdEditText.getText().toString().trim();

            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailEditText.setError("Invalid email address");
                emailEditText.requestFocus();
                return;
            }

            if (password.length() < 8) {
                passwordEditText.setError("Password must be at least 8 characters long");
                passwordEditText.requestFocus();
                return;
            }

            if (identificationId.length() < 8) {
                identificationIdEditText.setError("ID must have at least 8 digits");
                identificationIdEditText.requestFocus();
                return;
            }

            userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

            userViewModel.registerUser(email, password, identificationId).observe(this, user -> {
                if(user != null) {
                    userViewModel.setCurrentUserId(user.getId());
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "User already exists", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}