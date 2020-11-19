package com.jrivas.showingformateddate;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updateTime(findViewById(R.id.button));
    }

    public void updateTime(View button) {
        TextView textView = findViewById(R.id.date);
        DateFormat dateFormat = new DateFormat();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
        String date = simpleDateFormat.format(new Date());
        textView.setText(date);
    }
}