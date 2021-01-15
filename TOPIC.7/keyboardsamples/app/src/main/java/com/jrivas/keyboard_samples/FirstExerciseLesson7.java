package com.jrivas.keyboard_samples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FirstExerciseLesson7 extends AppCompatActivity {
    Button mButton;
    TextView mTextView;
    LinearLayout mLinearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_exercise_lesson7);
        mButton=findViewById(R.id.date_button);
        mTextView=findViewById(R.id.dateTimeText);
        mLinearLayout=findViewById(R.id.first_layout);
    }

    public void showDateTime(View view){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
        String date = simpleDateFormat.format(new Date());
        mTextView.setText(date);
    }

    public void setBackgroundColor(View view){
        mLinearLayout.setBackgroundColor(getResources().getColor(R.color.electric_blue));
    }
}