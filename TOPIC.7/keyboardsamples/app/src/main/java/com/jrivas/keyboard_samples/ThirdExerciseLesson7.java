package com.jrivas.keyboard_samples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class ThirdExerciseLesson7 extends AppCompatActivity {

    TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_exercise_lesson7);

        mTextView=findViewById(R.id.changing_text);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.radio_blue:
                if (checked)
                    mTextView.setTextColor(getResources().getColor(R.color.electric_blue));
                    break;
            case R.id.radio_red:
                if (checked)
                    mTextView.setTextColor(getResources().getColor(R.color.red));
                    break;
            case R.id.radio_green:
                if (checked)
                    mTextView.setTextColor(getResources().getColor(R.color.green));
                    break;
        }
    }
}