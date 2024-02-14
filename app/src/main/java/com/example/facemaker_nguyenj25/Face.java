package com.example.facemaker_nguyenj25;
//@author James Nguyen

import android.graphics.Canvas;

import java.util.Random;

public class Face {
    //private instance variables
    private int skinColor;
    private int eyeColor;
    private int hairColor;
    private int hairStyle;

    public Face() {
        random();
    }
    //this randomizes the int to create a random face out of the ints given

    /**
     * External Citation
     * Date: 13 Feb 2024
     * Problem: Could not remember how to use a random method
     * <p>
     * Resource: https://www.geeksforgeeks.org/java-util-random-nextint-java/?ref=header_search
     * <p>
     * Solution: I used this link to help give me a refresher on what to do
     */
    public void random() {
        Random randomize = new Random();
        skinColor = randomize.nextInt();
        eyeColor = randomize.nextInt();
        hairColor = randomize.nextInt();
        hairStyle = randomize.nextInt();
    }

    //this is a method to draw the Face on a canvas
    public void onDraw(Canvas canvas) {

    }

    //bunch of getter methods
    public int getSkinColor() {
        return skinColor;
    }

    public int getEyeColor() {
        return eyeColor;
    }

    public int getHairColor() {
        return hairColor;
    }

    public int getHairStyle() {
        return hairStyle;
    }
}