package com.jrivas.keyboard_samples;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SecondActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    String menu[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mRecyclerView=findViewById(R.id.recycler_view2);
        menu=getResources().getStringArray(R.array.lesson_7_tasks);

        MyAdapter2 myAdapter2=new MyAdapter2(this,menu);
        mRecyclerView.setAdapter(myAdapter2);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}