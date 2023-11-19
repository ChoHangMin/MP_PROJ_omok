package com.example.mp_proj_omok;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {


    ImageButton[][] omokArray = new ImageButton[6][6];
    Button placeCompleteButton;

    int currentPlayer = 0; // 0 = 흑, 1 = 백
    int[][] boardState = new int[6][6];
    int selectedRow = -1;
    int selectedCol = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        placeCompleteButton = findViewById(R.id.placeCompleteButton);
        placeCompleteButton.setOnClickListener(this);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                int buttonId = getResources().getIdentifier("button" + ((i * 6) + j + 1), "id", getPackageName());
                omokArray[i][j] = findViewById(buttonId);
                omokArray[i][j].setOnClickListener(this);
                omokArray[i][j].setImageResource(R.drawable.empty);
                omokArray[i][j].setAdjustViewBounds(true);
            }

        }


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.placeCompleteButton) {
            if (selectedRow != -1 && selectedCol != -1) {
                if (omokArray[selectedRow][selectedCol].getDrawable().getConstantState().equals(getResources().getDrawable(R.drawable.empty).getConstantState())) {
                    placeStone(selectedRow, selectedCol);
                    Log.d("GameActivity", "Place Stone row, col values" + selectedRow +","+selectedCol);
                } else {
                    Toast.makeText(GameActivity.this, "이미 차지되어 있습니다.", Toast.LENGTH_SHORT).show();

                }
            }
        } else {
            int buttonId = view.getId();
            String buttonNumber = getResources().getResourceEntryName(buttonId).substring("button".length());
            int selectedButtonNumber = Integer.parseInt(buttonNumber);
            Log.d("GameActivity", "Check button id" + selectedButtonNumber);
            selectedRow = (selectedButtonNumber - 1) / 6;
            selectedCol = (selectedButtonNumber - 1) % 6;
            Log.d("GameActivity", "Check row, col values" + selectedRow +","+selectedCol);

        }
    }

    private void togglePlayer() {
        currentPlayer = (currentPlayer == 0) ? 1 : 0;

    }

    private void placeStone(int i, int j) {
        if (currentPlayer == 0) {
            omokArray[i][j].setImageResource(R.drawable.black);
            omokArray[i][j].setAdjustViewBounds(true);

        } else {
            omokArray[i][j].setImageResource(R.drawable.white);
            omokArray[i][j].setAdjustViewBounds(true);

        }
        togglePlayer();
    }

}













