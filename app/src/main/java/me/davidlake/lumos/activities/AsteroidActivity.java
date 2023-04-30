package me.davidlake.lumos.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import me.davidlake.lumos.R;

public class AsteroidActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asteroid);

        Intent intent = this.getIntent();
        TextView nameTextView = findViewById(R.id.asteroid_name);
        TextView idTextView = findViewById(R.id.asteroid_id);
        TextView diameterTextView = findViewById(R.id.asteroid_diameter);
        TextView isDangerousTextView = findViewById(R.id.asteroid_is_dangerous);

        if (intent != null){

            String name = intent.getStringExtra("asteroid_name");
            String id = intent.getStringExtra("asteroid_id");
            String estimatedDiameter = intent.getStringExtra("asteroid_estimated_diameter");
            String asteroidVelocity = intent.getStringExtra("asteroid_is_dangerous");

            nameTextView.setText(name);
            idTextView.setText(id);
            diameterTextView.setText(estimatedDiameter);
            isDangerousTextView.setText(asteroidVelocity);
        }
    }
}
