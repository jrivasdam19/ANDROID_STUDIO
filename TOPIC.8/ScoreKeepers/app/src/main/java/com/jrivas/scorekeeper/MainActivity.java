package com.jrivas.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int mScore1;
    int mScore2;
    TextView mTextView1;
    TextView mTextView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mScore1 = 0;
        mScore2 = 0;
        mTextView1 = findViewById(R.id.counter_team_1);
        mTextView2 = findViewById(R.id.counter_team_2);
    }

    public void increaseScore(View view) {
        switch (view.getId()) {
            case R.id.plus_team_1:
                mScore1++;
                mTextView1.setText(Integer.toString(mScore1));
                break;
            case R.id.plus_team_2:
                mScore2++;
                mTextView2.setText(Integer.toString(mScore2));
                break;
            default:
                Toast.makeText(this, "Error. Plus button unhandled", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void decreaseScore(View view) {
        switch (view.getId()) {
            case R.id.minus_team_1:
                if (mScore1 == 0) {
                    Toast.makeText(this, "Team 1 can't have less than 0 scores", Toast.LENGTH_SHORT).show();
                } else {
                    mScore1--;
                    mTextView1.setText(Integer.toString(mScore1));
                }
                break;
            case R.id.minus_team_2:
                if (mScore2 == 0) {
                    Toast.makeText(this, "Team 2 can't have less than 0 scores", Toast.LENGTH_SHORT).show();
                } else {
                    mScore2--;
                    mTextView2.setText(Integer.toString(mScore2));
                }
                break;
            default:
                Toast.makeText(this, "Error. Minus button unhandled", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}