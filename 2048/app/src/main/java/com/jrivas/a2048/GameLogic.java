package com.jrivas.a2048;

import java.util.Random;

public class GameLogic {

    public int[][] currentArray = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
    private int[][] previousArray = new int[4][4];

    public GameLogic() {
    }

    public void copyArrays() {
        for (int i = 0; i < currentArray.length; i++) {
            for (int j = 0; j < currentArray[i].length; j++) {
                previousArray[i][j] = currentArray[i][j];
            }
        }
    }

    public void recoverPreviousMove() {
        for (int i = 0; i < currentArray.length; i++) {
            for (int j = 0; j < currentArray[i].length; j++) {
                currentArray[i][j] = previousArray[i][j];
            }
        }
    }

    private int[] generateRandomLocations() {
        int[] randomArray = {0, 1, 2, 3};
        int[] locations = new int[2];
        locations[0] = randomArray[new Random().nextInt(randomArray.length)];
        locations[1] = randomArray[new Random().nextInt(randomArray.length)];
        return locations;
    }

    private void putRandomNumber() {
        int[] locations;
        locations = generateRandomLocations();
        while (currentArray[locations[0]][locations[1]] != 0) {
            locations = generateRandomLocations();
        }
        currentArray[locations[0]][locations[1]] = this.generateNumber();
    }

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

    public void swipeUp() {
        this.copyArrays();
        boolean added;
        for (int i = 1; i < currentArray.length; i++) {
            for (int j = 0; j < currentArray[i].length; j++) {
                int number = currentArray[i][j];
                added = false;
                for (int k = 1; k <= i; k++) {
                    if (number != 0) {
                        if (currentArray[i - k][j] == 0) {
                            number += currentArray[i - k][j];
                            currentArray[i - k][j] = number;
                            currentArray[i - k + 1][j] = 0;
                        } else if (currentArray[i - k][j] == number && !added) {
                            number += currentArray[i - k][j];
                            currentArray[i - k][j] = number;
                            currentArray[i - k + 1][j] = 0;
                            added = true;
                        } else {
                            k = i;
                        }
                    }
                }
            }
        }
        this.putRandomNumber();
    }

    public void swipeDown() {
        this.copyArrays();
        boolean added;
        for (int i = 2; i >= 0; i--) {
            for (int j = 0; j < currentArray[i].length; j++) {
                int number = currentArray[i][j];
                added = false;
                for (int k = 1; k < currentArray.length - i; k++) {
                    if (number != 0) {
                        if (currentArray[i + k][j] == 0) {
                            number += currentArray[i + k][j];
                            currentArray[i + k][j] = number;
                            currentArray[i + k - 1][j] = 0;
                        } else if (currentArray[i + k][j] == number && !added) {
                            number += currentArray[i + k][j];
                            currentArray[i + k][j] = number;
                            currentArray[i + k - 1][j] = 0;
                            added = true;
                        } else {
                            k = currentArray.length;
                        }
                    }
                }
            }
        }
        this.putRandomNumber();
    }

    public void swipeLeft() {
        this.copyArrays();
        boolean added;
        for (int j = 1; j < currentArray[0].length; j++) {
            for (int i = 0; i < currentArray.length; i++) {
                int number = currentArray[i][j];
                added = false;
                for (int k = 1; k <= j; k++) {
                    if (number != 0) {
                        if (currentArray[i][j - k] == 0) {
                            number += currentArray[i][j - k];
                            currentArray[i][j - k] = number;
                            currentArray[i][j - k + 1] = 0;
                        } else if (currentArray[i][j - k] == number && !added) {
                            number += currentArray[i][j - k];
                            currentArray[i][j - k] = number;
                            currentArray[i][j - k + 1] = 0;
                            added = true;
                        } else {
                            k = j + 1;
                        }
                    }
                }
            }
        }
        this.putRandomNumber();
    }

    public void swipeRight() {
        this.copyArrays();
        boolean added;
        for (int j = 2; j >= 0; j--) {
            for (int i = 0; i < currentArray.length; i++) {
                int number = currentArray[i][j];
                added = false;
                for (int k = 1; k < currentArray.length - j; k++) {
                    if (number != 0) {
                        if (currentArray[i][j + k] == 0) {
                            number += currentArray[i][j + k];
                            currentArray[i][j + k] = number;
                            currentArray[i][j + k - 1] = 0;
                        } else if (currentArray[i][j + k] == number && !added) {
                            number += currentArray[i][j + k];
                            currentArray[i][j + k] = number;
                            currentArray[i][j + k - 1] = 0;
                            added = true;
                        } else {
                            k = currentArray.length;
                        }
                    }
                }
            }
        }
        this.putRandomNumber();
    }
}
