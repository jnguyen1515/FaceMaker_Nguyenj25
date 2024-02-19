package com.example.facemaker_nguyenj25;
//@author James Nguyen

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceView;

import java.util.Random;

public class Face extends SurfaceView {
    //private instance variables
    private int skinColor;
    private int eyeColor;
    private int hairColor;
    private int hairStyle;

    public Face(Context context) {
        super(context);
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
        canvas.drawCircle(200.0f, 300.0f, 50.0f, // color needed);
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