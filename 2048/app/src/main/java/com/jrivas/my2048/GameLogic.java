package com.jrivas.my2048;

import android.widget.TextView;

import java.util.Random;

public class GameLogic {
    //Testing Winning Game
    //public int[][] currentArray = {{1024, 0, 0, 0}, {1024, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
    //Testing GameOver
   // public int[][] currentArray = {{2, 4, 2, 4}, {4, 2, 4, 2}, {2, 4, 2, 4}, {4, 2, 4, 2}};
    //public int[][] currentArray = {{2, 0, 2, 0}, {0, 2, 0, 2}, {0, 0, 0, 0}, {0, 0, 0, 0}};
    public int[][] currentArray;
    private int[][] previousArray;
    private int currentScore;
    private int previousScore;
    private TextView currentTextScore;

    public GameLogic(TextView textView) {
        currentTextScore = textView;
        currentArray = new int[4][4];
        previousArray = new int[4][4];
        this.modifyScore(0);
    }

    //------------------------ PRIVATE METHODS -----------------------------------------------------

    /**
     * Copy currentArray's information to previousArray in order to have a previous move to recover
     * if "Undo" Button is clicked.
     */
    private void copyArrays() {
        for (int i = 0; i < currentArray.length; i++) {
            for (int j = 0; j < currentArray[i].length; j++) {
                previousArray[i][j] = currentArray[i][j];
            }
        }
    }

    /**
     * Generate 2 or 4 number. 75% chance to be 2 and 25% to be 4.
     *
     * @return random generated int number.
     */
    private int generateNumber() {
        int[] randomArray = {0, 1, 2, 3};
        int randomNumber = randomArray[new Random().nextInt(randomArray.length)];
        if (randomNumber == 3) {
            randomNumber = 4;
        } else {
            randomNumber = 2;
        }
        return randomNumber;
    }

    /**
     * Generate random location in currentArray in order to set a 2 or 4 number.
     *
     * @return int[] with random generated locations.
     */
    private int[] generateRandomLocations() {
        int[] randomArray = {0, 1, 2, 3};
        int[] locations = new int[2];
        locations[0] = randomArray[new Random().nextInt(randomArray.length)];
        locations[1] = randomArray[new Random().nextInt(randomArray.length)];
        return locations;
    }

    /**
     * Refresh score information.
     *
     * @param score Amount of points to be added.
     */
    private void modifyScore(int score) {
        previousScore = currentScore;
        currentScore += score;
        this.modifyScoreTextSize(currentTextScore, currentScore);
    }

    /**
     * Looks for zeros contained in currentArray.
     *
     * @return true if there are any zero in the array, false instead.
     */
    private boolean searchForZeros() {
        boolean isZero = false;
        for (int i = 0; i < currentArray.length; i++) {
            for (int j = 0; j < currentArray[i].length; j++) {
                if (currentArray[i][j] == 0) {
                    isZero = true;
                }
            }
        }
        return isZero;
    }

    //------------------------ PUBLIC METHODS ------------------------------------------------------

    /**
     * Modifies score text size in order to improve visibility and insert the new information.
     *
     * @param textView Current TextView.
     * @param score    Amount of current points to be set.
     */
    public void modifyScoreTextSize(TextView textView, int score) {
        if (score > 99999) {
            textView.setTextSize(28);
        } else if (score > 999999) {
            textView.setTextSize(24);
        } else if (score > 9999999) {
            textView.setTextSize(21);
        } else {
            textView.setTextSize(30);
        }
        textView.setText(String.valueOf(score));
    }

    /**
     * Introduces 2 or 4 number in random locations of numeric currentArray.
     */
    public void putRandomNumber() {
        if (this.searchForZeros()) {
            int[] locations;
            locations = generateRandomLocations();
            while (currentArray[locations[0]][locations[1]] != 0) {
                locations = generateRandomLocations();
            }
            currentArray[locations[0]][locations[1]] = this.generateNumber();
        }
    }

    /**
     * Set previousScore's and previousArray's information into currentScore variable and numeric
     * currentArray respectively.
     */
    public void recoverPreviousMove() {
        currentScore = previousScore;
        currentTextScore.setText(String.valueOf(currentScore));
        for (int i = 0; i < currentArray.length; i++) {
            for (int j = 0; j < currentArray[i].length; j++) {
                currentArray[i][j] = previousArray[i][j];
            }
        }
    }

    /**
     * Performs swipe down movement in currentArray.
     */
    public void swipeDown() {
        this.copyArrays();
        boolean[] addedCell;
        int score = 0;
        for (int j = 0; j < currentArray.length; j++) {
            addedCell = new boolean[currentArray[j].length];
            for (int i = currentArray.length - 1; i >= 0; i--) {
                for (int k = 1; k < currentArray.length - (currentArray.length - 1 - i); k++) {
                    if (currentArray[i][j] == 0) {
                        currentArray[i][j] = currentArray[i - k][j];
                        currentArray[i - k][j] = 0;
                    } else if (currentArray[i][j] == currentArray[i - k][j] && !addedCell[i]) {
                        currentArray[i][j] += currentArray[i - k][j];
                        currentArray[i - k][j] = 0;
                        addedCell[i] = true;
                        score += currentArray[i][j];
                    } else if (currentArray[i][j - k] == 0) ;
                    else {
                        k = currentArray.length;
                    }
                }
            }
        }
        this.putRandomNumber();
        this.modifyScore(score);
    }

    /**
     * Performs swipe left movement in currentArray.
     */
    public void swipeLeft() {
        this.copyArrays();
        boolean[] addedCell;
        int score = 0;
        for (int i = 0; i < currentArray.length; i++) {
            addedCell = new boolean[currentArray[i].length];
            for (int j = 0; j < currentArray[i].length - 1; j++) {
                for (int k = 1; k < currentArray[i].length - j; k++) {
                    if (currentArray[i][j] == 0) {
                        currentArray[i][j] = currentArray[i][j + k];
                        currentArray[i][j + k] = 0;
                    } else if (currentArray[i][j] == currentArray[i][j + k] && !addedCell[j]) {
                        currentArray[i][j] += currentArray[i][j + k];
                        currentArray[i][j + k] = 0;
                        addedCell[j] = true;
                        score += currentArray[i][j];
                    } else if (currentArray[i][j + k] == 0) ;
                    else {
                        k = currentArray.length;
                    }
                }
            }
        }
        this.putRandomNumber();
        this.modifyScore(score);
    }

    /**
     * Performs swipe right movement in currentArray.
     */
    public void swipeRight() {
        this.copyArrays();
        boolean[] addedCell;
        int score = 0;
        for (int i = 0; i < currentArray.length; i++) {
            addedCell = new boolean[currentArray[i].length];
            for (int j = currentArray[i].length - 1; j >= 0; j--) {
                for (int k = 1; k < currentArray[i].length - (currentArray[i].length - 1 - j); k++) {
                    if (currentArray[i][j] == 0) {
                        currentArray[i][j] = currentArray[i][j - k];
                        currentArray[i][j - k] = 0;
                    } else if (currentArray[i][j] == currentArray[i][j - k] && !addedCell[j]) {
                        currentArray[i][j] += currentArray[i][j - k];
                        currentArray[i][j - k] = 0;
                        addedCell[j] = true;
                        score += currentArray[i][j];
                    } else if (currentArray[i][j - k] == 0) ;
                    else {
                        k = currentArray.length;
                    }
                }
            }
        }
        this.putRandomNumber();
        this.modifyScore(score);
    }

    /**
     * Performs swipe up movement in currentArray.
     */
    public void swipeUp() {
        this.copyArrays();
        boolean[] addedCell;
        int score = 0;
        for (int j = 0; j < currentArray.length; j++) {
            addedCell = new boolean[currentArray[j].length];
            for (int i = 0; i < currentArray.length; i++) {
                for (int k = 1; k < currentArray.length - i; k++) {
                    if (currentArray[i][j] == 0) {
                        currentArray[i][j] = currentArray[i + k][j];
                        currentArray[i + k][j] = 0;
                    } else if (currentArray[i][j] == currentArray[i + k][j] && !addedCell[i]) {
                        currentArray[i][j] += currentArray[i + k][j];
                        currentArray[i + k][j] = 0;
                        addedCell[i] = true;
                        score += currentArray[i][j];
                    } else if (currentArray[i + k][j] == 0) ;
                    else {
                        k = currentArray.length;
                    }
                }
            }
        }
        this.putRandomNumber();
        this.modifyScore(score);
    }

    /**
     * Tests whether it is any possible move on down swipe.
     *
     * @return true if there is a possible move, false instead.
     */
    public boolean testSwipeDown() {
        boolean possibleMove = false;
        for (int j = 0; j < currentArray.length; j++) {
            for (int i = currentArray.length - 1; i >= 0; i--) {
                for (int k = 1; k < currentArray.length - (currentArray.length - 1 - i); k++) {
                    if (currentArray[i][j] == 0) {
                        possibleMove = true;
                    } else if (currentArray[i][j] == currentArray[i - k][j]) {
                        possibleMove = true;
                    } else if (currentArray[i - k][j] == 0) ;
                    else {
                        k = currentArray.length;
                    }
                }
            }
        }
        return possibleMove;
    }

    /**
     * Tests whether it is any possible move on left swipe.
     *
     * @return true if there is a possible move, false instead.
     */
    public boolean testSwipeLeft() {
        boolean possibleMove = false;
        for (int i = 0; i < currentArray.length; i++) {
            for (int j = 0; j < currentArray[i].length - 1; j++) {
                for (int k = 1; k < currentArray[i].length - j; k++) {
                    if (currentArray[i][j] == 0) {
                        possibleMove = true;
                    } else if (currentArray[i][j] == currentArray[i][j + k]) {
                        possibleMove = true;
                    } else if (currentArray[i][j + k] == 0) ;
                    else {
                        k = currentArray.length;
                    }
                }
            }
        }
        return possibleMove;
    }

    /**
     * Tests whether it is any possible move on right swipe.
     *
     * @return true if there is a possible move, false instead.
     */
    public boolean testSwipeRight() {
        boolean possibleMove = false;
        for (int i = 0; i < currentArray.length; i++) {
            for (int j = currentArray[i].length - 1; j >= 0; j--) {
                for (int k = 1; k < currentArray[i].length - (currentArray[i].length - 1 - j); k++) {
                    if (currentArray[i][j] == 0) {
                        possibleMove = true;
                    } else if (currentArray[i][j] == currentArray[i][j - k]) {
                        possibleMove = true;
                    } else if (currentArray[i][j - k] == 0) ;
                    else {
                        k = currentArray.length;
                    }
                }
            }
        }
        return possibleMove;
    }

    /**
     * Tests whether it is any possible move on up swipe.
     *
     * @return true if there is a possible move, false instead.
     */
    public boolean testSwipeUp() {
        boolean possibleMove = false;
        for (int j = 0; j < currentArray.length; j++) {
            for (int i = 0; i < currentArray.length; i++) {
                for (int k = 1; k < currentArray.length - i; k++) {
                    if (currentArray[i][j] == 0) {
                        possibleMove = true;
                    } else if (currentArray[i][j] == currentArray[i + k][j]) {
                        possibleMove = true;
                    } else if (currentArray[i + k][j] == 0) ;
                    else {
                        k = currentArray.length;
                    }
                }
            }
        }
        return possibleMove;
    }
}
