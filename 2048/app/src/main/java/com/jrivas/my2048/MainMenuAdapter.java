package com.jrivas.my2048;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainMenuAdapter extends RecyclerView.Adapter<MainMenuAdapter.ViewHolder> {

    String[] mArray;
    Context mContext;

    public MainMenuAdapter(Context context, String[] array) {
        this.mContext = context;
        this.mArray = array;
    }

    //------------------------ OVERWRITTEN METHODS -------------------------------------------------

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.adapter_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mTextView.setText(this.mArray[position]);
        holder.mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;
                switch (position) {
                    case 0:
                        intent = new Intent(mContext, MainGame.class);
                        break;
                    case 1:
                        intent = new Intent(mContext, Scores.class);
                        break;
                }
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.mArray.length;
    }

    //---------------------------VIEWHOLDER INNER CLASS---------------------------------------------

    class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout mLinearLayout;
        TextView mTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mLinearLayout = itemView.findViewById(R.id.recycler_layout);
            this.mTextView = itemView.findViewById(R.id.word);
        }
    }
}
