package com.myfirstproject.touchgestures;

import androidx.core.view.GestureDetectorCompat;
import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

public class MainActivity extends Activity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
    //We implements the GestureDetector.OnGestureListener in order to use its methods.
    private GestureDetectorCompat mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // get the gesture detector
        mGestureDetector = new GestureDetectorCompat(this, this);
        mGestureDetector.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        if (this.mGestureDetector.onTouchEvent(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        Toast.makeText(MainActivity.this, R.string.onDown, Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        Toast.makeText(MainActivity.this, R.string.onShowPress, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Toast.makeText(MainActivity.this, R.string.onSingleTapUp, Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Toast.makeText(MainActivity.this, R.string.onScroll, Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Toast.makeText(MainActivity.this, R.string.onLongPress, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Toast.makeText(MainActivity.this, R.string.onFling, Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        Toast.makeText(MainActivity.this, R.string.onSingleTapConfirmed, Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Toast.makeText(MainActivity.this, R.string.onDoubleTap, Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        Toast.makeText(MainActivity.this, R.string.onDoubleTapEvent, Toast.LENGTH_SHORT).show();
        return true;
    }
}