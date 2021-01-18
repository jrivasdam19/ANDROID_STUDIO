package com.jrivas.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String STATE_SCORE_1 = "Team 1 Score";
    String STATE_SCORE_2 = "Team 2 Score";
    int mScore1;
    int mScore2;
    TextView mTextView1;
    TextView mTextView2;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        mScore1 = 0;
        mScore2 = 0;
        mTextView1 = findViewById(R.id.counter_team_1);
        mTextView2 = findViewById(R.id.counter_team_2);
        if (savedInstanceState != null) {
            mScore1 = savedInstanceState.getInt(STATE_SCORE_1);
            mScore2 = savedInstanceState.getInt(STATE_SCORE_2);
//Set the score text views
            mTextView1.setText(String.valueOf(mScore1));
            mTextView2.setText(String.valueOf(mScore2));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//Inflate the menu from XML
        getMenuInflater().inflate(R.menu.main_menu, menu);
//Change the label of the menu based on the state of the app
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//Check if the correct item was clicked
        if (item.getItemId() == R.id.night_mode) {
            AppCompatDelegate.getDefaultNightMode();
        }
        //Get the night mode state of the app
        int nightMode = AppCompatDelegate.getDefaultNightMode();
//Set the theme mode for the restarted activity
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
//Save the scores
        outState.putInt(STATE_SCORE_1, mScore1);
        outState.putInt(STATE_SCORE_2, mScore2);
        super.onSaveInstanceState(outState);
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