package me.davidlake.lumos.activities;

import android.content.Intent;
import android.os.Bundle;
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

            EditText firstNameEditText = findViewById(R.id.first_name_edit_text);
            EditText lastNameEditText = findViewById(R.id.last_name_edit_text);
            EditText emailEditText = findViewById(R.id.email_edit_text);
            EditText passwordEditText = findViewById(R.id.password_edit_text);
            EditText identificationIdEditText = findViewById(R.id.identification_id_edit_text);

            String firstName = firstNameEditText.getText().toString().trim();
            String lastName = lastNameEditText.getText().toString().trim();
            String email = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();
            String identificationId = identificationIdEditText.getText().toString().trim();

            if(firstName.length() < 3) {
                firstNameEditText.setError(getString(R.string.first_name_len_constraint));
                firstNameEditText.requestFocus();
                return;
            }

            if(lastName.length() < 3) {
                lastNameEditText.setError(getString(R.string.last_name_len_constraint));
                lastNameEditText.requestFocus();
                return;
            }

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

            if (identificationId.length() < 8) {
                identificationIdEditText.setError(getString(R.string.id_len_constraint));
                identificationIdEditText.requestFocus();
                return;
            }

            userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

            userViewModel.registerUser(email, password, firstName, lastName, identificationId).observe(this, user -> {
                if(user != null) {
                    userViewModel.setCurrentUserId(user.getId());
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), getString(R.string.already_existing_user), Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}