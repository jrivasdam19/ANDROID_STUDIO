package com.jrivas.keyboard_samples;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

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

    /*private void getData() {
        if (getIntent().hasExtra("data1") && getIntent().hasExtra("data2")) {

            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");

        } else {
            Toast.makeText(this, "No data founded", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        title.setText(data1);
        description.setText(data2);
    }*/
}