package com.jrivas.examenrivasmendezjosemiguel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import androidx.fragment.app.Fragment;

public class ModifyText extends Fragment {
public int fontSize;
public String text;
    public ModifyText(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myModifyText=  inflater.inflate(R.layout.fragment_edit_text, container, false);
        EditText editText =(EditText) myModifyText.findViewById(R.id.editableText);
        SeekBar greyBar =(SeekBar)myModifyText.findViewById(R.id.sizeSeekBar);
        Button changeText=(Button)myModifyText.findViewById(R.id.changeTextButton);
        fontSize=12;
        text="";
        greyBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Intent intent= new Intent(myModifyText, MainActivity.class);
                fontSize=progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        changeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text=editText.getText().toString();
                Activity activity=getActivity();
                ((ComunicatingInformation)activity).comunicateSize(fontSize);
                ((ComunicatingInformation)activity).comunicateText(text);
            }
        });
        return myModifyText;
    }
}