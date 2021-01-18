package com.jrivas.keyboard_samples;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Calendar;

public class MyAdapter1 extends RecyclerView.Adapter<MyAdapter1.MyViewHolder> {

    String[] data1;
    Context mContext;

    public MyAdapter1(Context context, String[] s1) {
        this.mContext = context;
        this.data1 = s1;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.main_menu, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.myText1.setText(data1[position]);
        holder.mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=null;
                switch (position){
                    case 0:
                        intent=new Intent(mContext,SecondActivity.class);
                        break;
                    case 1:
                        intent=new Intent(mContext,KeyboardInputType.class);
                        break;
                    case 2:
                        intent=new Intent(mContext,AlertDialogs.class);
                        break;
                    case 3:
                        intent=new Intent(mContext,DroidDesserts.class);
                        break;
                }
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView myText1;
        LinearLayout mLinearLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.myText1 = itemView.findViewById(R.id.myText1);
            mLinearLayout = itemView.findViewById(R.id.main_menu);
        }
    }
}
