package com.jrivas.myrecyclerview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter {

    String[] mArray;

    public MyAdapter(String[] array){
        this.mArray=array;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView myText1;
        LinearLayout mLinearLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.myText1 = itemView.findViewById(R.id.word);
            mLinearLayout = itemView.findViewById(R.id.recycler_layout);

        }
    }
}
