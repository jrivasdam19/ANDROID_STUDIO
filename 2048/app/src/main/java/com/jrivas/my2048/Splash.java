package com.jrivas.my2048;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {
    private TextView mLogo1;
    private TextView mLogo2;
    private TableLayout mTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mLogo1 = findViewById(R.id.TextViewTopTitle);
        mLogo2 = findViewById(R.id.TextViewBottomTitle);
        mTable = findViewById(R.id.TableLayout01);
        this.setAnimations(mLogo1, mTable);
    }

    //------------------------ PRIVATE METHODS -----------------------------------------------------

    /**
     * Set Splash.class animations.
     *
     * @param textView    "2048!" TextView.
     * @param tableLayout TableLayout with 4 images contained.
     */
    private void setAnimations(TextView textView, TableLayout tableLayout) {
        Animation fade1 = AnimationUtils.loadAnimation(this, R.anim.fade_in1);
        textView.startAnimation(fade1);
        Animation spinning = AnimationUtils.loadAnimation(this, R.anim.custom_anim);
        LayoutAnimationController controller =
                new LayoutAnimationController(spinning);
        controller.setOrder(LayoutAnimationController.ORDER_RANDOM);
        for (int i = 0; i < tableLayout.getChildCount(); i++) {
            TableRow row = (TableRow) tableLayout.getChildAt(i);
            row.setLayoutAnimation(controller);
        }
        Animation fade2 = AnimationUtils.loadAnimation(this, R.anim.fade_in2);
        fade2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(Splash.this, MainActivity.class));
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        textView.startAnimation(fade2);
    }

    //------------------------ OVERWRITTEN METHODS -------------------------------------------------

    @Override
    protected void onPause() {
        super.onPause();
        mLogo1.clearAnimation();
        mLogo2.clearAnimation();
        for (int i = 0; i < mTable.getChildCount(); i++) {
            TableRow row = (TableRow) mTable.getChildAt(i);
            row.clearAnimation();
        }
    }
}