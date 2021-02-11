package com.jrivas.myrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    LinkedList<String> mArray;
    Context mContext;

    public WordListAdapter(Context context, LinkedList<String> s1) {
        this.mContext = context;
        this.mArray = s1;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.wordlist_item, parent, false);
        return new WordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        holder.mWordItemView.setText(this.mArray.get(position));
        holder.mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.mWordItemView.setText("Clicked! " + holder.mWordItemView.getText());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mArray.size();
    }

    class WordViewHolder extends RecyclerView.ViewHolder {
        LinearLayout mLinearLayout;
        TextView mWordItemView;

        public WordViewHolder(View itemView) {
            super(itemView);
            this.mWordItemView = itemView.findViewById(R.id.word);
            this.mLinearLayout = itemView.findViewById(R.id.recycler_layout);
        }
    }
}
