package com.jrivas.keyboard_samples;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class SecondExerciseLesson7 extends AppCompatActivity {

    ImageButton mImageButton;
    TextView mTextView;
    EditText mFirstEditText;
    EditText mSecondEditText;
    MediaPlayer dogBark;
    CheckBox mCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_exercise_lesson7);

        mImageButton=findViewById(R.id.dog_barking);
        mFirstEditText=findViewById(R.id.first_edit_text);
        mSecondEditText=findViewById(R.id.second_edit_text);
        mTextView=findViewById(R.id.invisible_text);
        dogBark = MediaPlayer.create(this,R.raw.barks);
        mCheckBox = findViewById(R.id.checkbox_1);
    }

    public void emitBark(View view){
        dogBark.start();
        mTextView.setVisibility(View.VISIBLE);
        String content = mFirstEditText.getText().toString();
        mSecondEditText.setText(content);
    }

    public void onCheckboxClicked(View view){
        if(((CheckBox) view).isChecked()){
            mCheckBox.setText(getResources().getString(R.string.box_checked));
        }
        if(!((CheckBox) view).isChecked()){
            mCheckBox.setText(getResources().getString(R.string.box_unchecked));
        }
    }
}