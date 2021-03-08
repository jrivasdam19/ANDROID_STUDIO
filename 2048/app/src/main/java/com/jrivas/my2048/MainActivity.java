package com.jrivas.my2048;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private String[] mArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recycler_view);
        mArray = getResources().getStringArray(R.array.main_menu);
        mRecyclerView.setAdapter(new MainMenuAdapter(this, mArray));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}