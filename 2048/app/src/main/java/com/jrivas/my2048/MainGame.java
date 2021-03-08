package com.jrivas.my2048;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import java.util.ArrayList;

import static java.lang.Math.abs;

public class MainGame extends AppCompatActivity implements GestureDetector.OnGestureListener {
    private GestureDetectorCompat mDetector;
    private ImageView mImageView, mImageView1, mImageView2, mImageView3, mImageView4, mImageView5,
            mImageView6, mImageView7, mImageView8, mImageView9, mImageView10, mImageView11,
            mImageView12, mImageView13, mImageView14, mImageView15;
    private static TextView sCurrentTextScore;
    private TextView mBestScore;
    private ArrayList<ImageView> mImageList = new ArrayList<>();
    private GameLogic mGameLogic;
    private Button mUndo, mNewGame;
    private static ScoresHelper mDB;
    private LinearLayout mLayout;
    public static String mUserName = "Anonymous";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        mDB = new ScoresHelper(this);
        this.findViewsById();
        mGameLogic = new GameLogic(sCurrentTextScore);
        mGameLogic.modifyScoreTextSize(mBestScore, mDB.selectMaxScore());
        mDetector = new GestureDetectorCompat(this, this);
        this.constructTextViewArray();
        mGameLogic.putRandomNumber();
        this.paintArray(mGameLogic.currentArray);
    }

    //------------------------ PRIVATE METHODS -----------------------------------------------------

    /**
     * Checks if is any possible move after user's move. If there is no more possible moves it shows
     * a GameOver View with a Try Again button to restart the game.
     */
    private void checkNextMove() {
        if (!mGameLogic.testSwipeUp() && !mGameLogic.testSwipeDown() && !mGameLogic.testSwipeLeft()
                && !mGameLogic.testSwipeRight()) {
            mLayout.setVisibility(View.VISIBLE);
            Animation fade = AnimationUtils.loadAnimation(this, R.anim.fade_in3);
            mLayout.startAnimation(fade);
        }
    }

    /**
     * Choose an image resource associated to a number in array.
     * @param view Current ImageView in GridLayout.
     * @param number Number from the current numeric array.
     */
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

    /**
     * Finds all ImageViews contained in GridLayout and hold them in mImageList ArrayList.
     */
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
        mImageList.add(mImageView);
        mImageList.add(mImageView1);
        mImageList.add(mImageView2);
        mImageList.add(mImageView3);
        mImageList.add(mImageView4);
        mImageList.add(mImageView5);
        mImageList.add(mImageView6);
        mImageList.add(mImageView7);
        mImageList.add(mImageView8);
        mImageList.add(mImageView9);
        mImageList.add(mImageView10);
        mImageList.add(mImageView11);
        mImageList.add(mImageView12);
        mImageList.add(mImageView13);
        mImageList.add(mImageView14);
        mImageList.add(mImageView15);
    }

    /**
     * Finds the first descendant view with the given ID of all views in the activity.
     */
    private void findViewsById(){
        sCurrentTextScore = findViewById(R.id.score_text);
        mBestScore = findViewById(R.id.best_text);
        mLayout = findViewById(R.id.game_over);
        mUndo = findViewById(R.id.undo_button);
        mNewGame = findViewById(R.id.new_game_button);
    }

    /**
     * Set information stored in mGameLogic current Array on GridLayout's ImageViews.
     * @param array The current integer array.
     */
    private void paintArray(int[][] array) {
        int aux = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                this.chooseNumber(mImageList.get(aux), array[i][j]);
                aux++;
            }
        }
    }

    //------------------------ PUBLIC METHODS ------------------------------------------------------

    /**
     * Restarts game by invoking mGameLogic constructor.
     * @param view "New Game" and "Try Again" Buttons.
     */
    public void restartGame(View view) {
        if (mLayout.getVisibility() != View.GONE) {
            mLayout.setVisibility(View.GONE);
        }
        mGameLogic = new GameLogic(sCurrentTextScore);
        mGameLogic.putRandomNumber();
        this.paintArray(mGameLogic.currentArray);
    }

    /**
     * Shows an AlertDialog in which users can introduce a name to be saved with the score they have
     * gotten. Instead, the default name is "Anonymous".
     * @param view Save ImageButton.
     */
    public void showAlert(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        LayoutInflater inflater = LayoutInflater.from(this);
        final View inflator = inflater.inflate(R.layout.dialog_signin, null);
        alert.setTitle("2048 User");
        alert.setMessage("Insert a user name to save the score:");
        alert.setView(inflator);
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                Dialog dialogObj = Dialog.class.cast(dialog);
                MainGame.mUserName = ((EditText) dialogObj.findViewById(R.id.username)).getText().toString();
                if (MainGame.mUserName.isEmpty()) {
                    MainGame.mUserName = "Anonymous";
                }
                MainGame.insertScore(MainGame.mUserName);
            }
        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainGame.insertScore(MainGame.mUserName);
                        dialog.cancel();
                    }
                });
        alert.show();
    }

    /**
     * Recovers previous user's move.
     * @param view "Undo" Button.
     */
    public void undoMovement(View view) {
        mGameLogic.recoverPreviousMove();
        this.paintArray(mGameLogic.currentArray);
    }

    //------------------------ PUBLIC STATIC METHODS -----------------------------------------------

    /**
     * Inserts a new ScoreItem object in DataBase.
     * @param userName String value of user name.
     */
    public static void insertScore(String userName) {
        String score = sCurrentTextScore.getText().toString();
        ScoreItem item = new ScoreItem(Integer.valueOf(score), userName);
        mDB.insert(item);
    }

    //------------------------ OVERWRITTEN METHODS -------------------------------------------------

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    /**
     * Defines swipe gesture's direction and execute pertinent method.
     * @param e1 The first down motion event that started the fling.
     * @param e2 The move motion event that triggered the current onFling.
     * @param velocityX The velocity of this fling measured in pixels per second along the x axis.
     * @param velocityY The velocity of this fling measured in pixels per second along the y axis.
     * @return true if the event is consumed, else false.
     */
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        float xI = e1.getX();
        float yI = e1.getY();
        float xF = e2.getX();
        float yF = e2.getY();
        if (abs(xI - xF) > abs(yI - yF)) {
            if ((xI - xF) < 0) {
                if (mGameLogic.testSwipeRight()) {
                    mGameLogic.swipeRight();
                    paintArray(mGameLogic.currentArray);
                }
            } else if ((xI - xF) > 0) {
                if (mGameLogic.testSwipeLeft()) {
                    mGameLogic.swipeLeft();
                    paintArray(mGameLogic.currentArray);
                }
            }
        } else if (abs(xI - xF) < abs(yI - yF)) {
            if ((yI - yF) < 0) {
                if (mGameLogic.testSwipeDown()) {
                    mGameLogic.swipeDown();
                    paintArray(mGameLogic.currentArray);
                }
            } else if ((yI - yF) > 0) {
                if (mGameLogic.testSwipeUp()) {
                    mGameLogic.swipeUp();
                    paintArray(mGameLogic.currentArray);
                }
            }
        }
        this.checkNextMove();
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
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
    public boolean onTouchEvent(MotionEvent event) {
        if (this.mDetector.onTouchEvent(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }
}