package com.jrivas.a2048;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static java.lang.Math.abs;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {

    private GestureDetectorCompat mDetector;
    private ImageView mImageView, mImageView1, mImageView2, mImageView3, mImageView4, mImageView5,
            mImageView6, mImageView7, mImageView8, mImageView9, mImageView10, mImageView11,
            mImageView12, mImageView13, mImageView14, mImageView15;
    private ArrayList<ImageView> imageList = new ArrayList<>();
    private GameLogic mGameLogic = new GameLogic();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDetector = new GestureDetectorCompat(this, this);
        this.constructTextViewArray();
        this.paintArray(mGameLogic.currentArray);
    }

    private void paintArray(int[][] array) {
        int aux = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                this.chooseNumber(imageList.get(aux),array[i][j]);
                aux++;
            }
        }
    }

    private void chooseNumber(ImageView view, int number) {
        switch (number) {
            case 0:
                view.setImageResource(R.drawable.number_0);
                break;
            case 2:
                view.setImageResource(R.drawable.number_2);
                break;
            case 4:
                view.setImageResource(R.drawable.number_4);
                break;
            case 8:
                view.setImageResource(R.drawable.number_8);
                break;
            case 16:
                view.setImageResource(R.drawable.number_16);
                break;
            case 32:
                view.setImageResource(R.drawable.number_32);
                break;
            case 64:
                view.setImageResource(R.drawable.number_64);
                break;
            case 128:
                view.setImageResource(R.drawable.number_128);
                break;
            case 256:
                view.setImageResource(R.drawable.number_256);
                break;
            case 512:
                view.setImageResource(R.drawable.number_512);
                break;
            case 1024:
                view.setImageResource(R.drawable.number_1024);
                break;
            case 2048:
                view.setImageResource(R.drawable.number_2048);
                break;
        }
    }

    private void constructTextViewArray() {
        mImageView = findViewById(R.id.cell0);
        mImageView1 = findViewById(R.id.cell1);
        mImageView2 = findViewById(R.id.cell2);
        mImageView3 = findViewById(R.id.cell3);
        mImageView4 = findViewById(R.id.cell4);
        mImageView5 = findViewById(R.id.cell5);
        mImageView6 = findViewById(R.id.cell6);
        mImageView7 = findViewById(R.id.cell7);
        mImageView8 = findViewById(R.id.cell8);
        mImageView9 = findViewById(R.id.cell9);
        mImageView10 = findViewById(R.id.cell10);
        mImageView11 = findViewById(R.id.cell11);
        mImageView12 = findViewById(R.id.cell12);
        mImageView13 = findViewById(R.id.cell13);
        mImageView14 = findViewById(R.id.cell14);
        mImageView15 = findViewById(R.id.cell15);
        imageList.add(mImageView);
        imageList.add(mImageView1);
        imageList.add(mImageView2);
        imageList.add(mImageView3);
        imageList.add(mImageView4);
        imageList.add(mImageView5);
        imageList.add(mImageView6);
        imageList.add(mImageView7);
        imageList.add(mImageView8);
        imageList.add(mImageView9);
        imageList.add(mImageView10);
        imageList.add(mImageView11);
        imageList.add(mImageView12);
        imageList.add(mImageView13);
        imageList.add(mImageView14);
        imageList.add(mImageView15);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (this.mDetector.onTouchEvent(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        float xI = e1.getX();
        float yI = e1.getY();
        float xF = e2.getX();
        float yF = e2.getY();
        if (abs(xI - xF) > abs(yI - yF)) {
            if ((xI - xF) < 0) {
                mGameLogic.swipeRight();
                paintArray(mGameLogic.currentArray);
            } else if ((xI - xF) > 0) {
                mGameLogic.swipeLeft();
                paintArray(mGameLogic.currentArray);
            }
        } else if (abs(xI - xF) < abs(yI - yF)) {
            if ((yI - yF) < 0) {
                mGameLogic.swipeDown();
                paintArray(mGameLogic.currentArray);
            } else if ((yI - yF) > 0) {
                mGameLogic.swipeUp();
                paintArray(mGameLogic.currentArray);
            }
        }
        return false;
    }
}