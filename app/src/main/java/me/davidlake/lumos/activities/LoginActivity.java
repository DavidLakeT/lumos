package me.davidlake.lumos.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import me.davidlake.lumos.R;
import me.davidlake.lumos.viewmodel.UserViewModel;

public class LoginActivity  extends AppCompatActivity {

    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button signinButton = findViewById(R.id.signin_button);
        Button signupButton = findViewById(R.id.register_button);

        signinButton.setOnClickListener(v -> {

            EditText emailEditText = findViewById(R.id.email_edit_text);
            EditText passwordEditText = findViewById(R.id.password_edit_text);

            String email = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailEditText.setError(getString(R.string.valid_email_constraint));
                emailEditText.requestFocus();
                return;
            }

            if (password.length() < 8) {
                passwordEditText.setError(getString(R.string.password_len_constraint));
                passwordEditText.requestFocus();
                return;
            }

            userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

            userViewModel.checkUser(email, password).observe(this, user -> {
                if (user != null) {
                    userViewModel.setCurrentUserId(user.getId());
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), getString(R.string.invalid_credentials), Toast.LENGTH_SHORT).show();
                }
            });

        });

        signupButton.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }
}
