package com.jrivas.examenrivasmendezjosemiguel;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TextOutPut extends Fragment {
public TextView mTextView;

   public TextOutPut(){

   }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mTextView=(TextView)getView().findViewById(R.id.screenText);
        MainActivity activity = (MainActivity) getActivity();
        mTextView.setTextSize(activity.font());
        mTextView.setText(activity.text());
        mTextView.setTextColor(Color.rgb(activity.red(),activity.green(),activity.blue()));

        return inflater.inflate(R.layout.fragment_text_out_put, container, false);
    }

}