package com.example.hellorelative;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
public int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter=0;
    }

    public void increaseCounter(View view){
        counter++;
        showNumber();
    }

    public void showNumber(){
        TextView textView = (TextView) findViewById(R.id.show_count);
        textView.setText(counter);
    }
}