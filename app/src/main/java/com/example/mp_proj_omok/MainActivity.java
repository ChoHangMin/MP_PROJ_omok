package com.example.mp_proj_omok;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startButton = findViewById(R.id.startGameButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    // Create an Intent to start the GameActivity
                    Intent intent = new Intent(MainActivity.this, GameActivity.class);
                    startActivity(intent);
                } catch (Exception e) {
                    // Log an error message if there is an exception
                    Log.e("MainActivity", "Error starting GameActivity: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        });
    }
}
