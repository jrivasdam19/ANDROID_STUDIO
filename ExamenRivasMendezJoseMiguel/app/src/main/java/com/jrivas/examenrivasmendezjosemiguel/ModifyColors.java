package com.jrivas.examenrivasmendezjosemiguel;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;


public class ModifyColors extends Fragment {
public int red, green, blue;
    public ModifyColors(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myModifyColor = inflater.inflate(R.layout.fragment_modify_colors, container, false);
        SeekBar redBar=(SeekBar)myModifyColor.findViewById(R.id.redBar);
        SeekBar greenBar=(SeekBar)myModifyColor.findViewById(R.id.greenBar);
        SeekBar blueBar=(SeekBar)myModifyColor.findViewById(R.id.blueBar);
        Button changeColor=(Button)myModifyColor.findViewById(R.id.changeColor);
        redBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                red=progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        greenBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                green=progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        blueBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                blue=progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        changeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity activity=getActivity();
                ((ComunicatingInformation)activity).comunicateRed(red);
                ((ComunicatingInformation)activity).comunicateGreen(green);
                ((ComunicatingInformation)activity).comunicateBlue(blue);
            }
        });
        return myModifyColor;
    }
}