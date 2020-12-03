package com.jrivas.examenrivasmendezjosemiguel;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements ComunicatingInformation {
public int sizeFont, redRGB, greenRGB, blueRGB;
public String text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void comunicateSize(int fontSize) {
        sizeFont=fontSize;
    }

    public int font(){
        return sizeFont;
    }

    @Override
    public void comunicateText(String text) {
        text1=text;
    }

    public String text(){
        return text1;
    }

    @Override
    public void comunicateRed(int red) {
        Intent in = new Intent(this, TextOutPut.class);
        in.putExtra("red", red);
    }

    public int red(){
        return redRGB;
    }

    @Override
    public void comunicateGreen(int green) {
        Intent in = new Intent(this, TextOutPut.class);
        in.putExtra("green", green);
    }

    public int green(){
        return greenRGB;
    }

    @Override
    public void comunicateBlue(int blue) {
        Intent in = new Intent(this, TextOutPut.class);
        in.putExtra("blue", blue);
    }

    public int blue(){
        return blueRGB;
    }
}