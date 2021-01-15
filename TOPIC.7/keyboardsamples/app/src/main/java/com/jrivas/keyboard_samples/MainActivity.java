package com.jrivas.keyboard_samples;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    String menu1[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView=findViewById(R.id.recycler_view);

        menu1=getResources().getStringArray(R.array.main_tasks);

        MyAdapter1 myAdapter1 =new MyAdapter1(this,menu1);
        mRecyclerView.setAdapter(myAdapter1);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}