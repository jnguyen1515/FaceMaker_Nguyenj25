package com.example.facemaker_nguyenj25;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.graphics.Paint;

import java.util.Random;

public class Face extends SurfaceView {
    public Color color;
    //private instance variables
    private int skinColor;
    private int eyeColor;
    private int hairColor;
    private int hairStyle;
    int hair_selection;


    private int selected;
    private int[] a = {skinColor,eyeColor,hairColor};
    private int red = 0;
    private int green = 0;
    private int blue = 0;


    public Face(Context context, AttributeSet att) {
        super(context, att);
        setWillNotDraw(false);
        initialize();
    }

    private void initialize() {
        Random random = new Random();
        skinColor = random.nextInt();
        eyeColor = random.nextInt();
        hairColor = random.nextInt();
        hairStyle = random.nextInt();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // Paint objects for colors
        Paint hair = new Paint();
        hair.setColor(hairColor);
        Paint skin = new Paint();
        skin.setColor(skinColor);
        Paint eye = new Paint();
        eye.setColor(eyeColor);
        Paint hatPaint = new Paint();
        hatPaint.setColor(Color.BLUE);




        // Draw hair based on hair_selection
        if (hair_selection == 1) {
            // Draw block Hair
            canvas.drawRect(300.0f, 500.0f, 650.0f, 300.0f, hair);
        }

        // Draw head
        canvas.drawRect(420.0f, 475.0f, 525.0f, 900.0f, skin);
        canvas.drawCircle(475.0f, 525.0f, 175.0f, skin);
        canvas.drawOval(380.0f, 445.0f, 410.0f, 500.0f, eye);
        canvas.drawOval(440.0f, 445.0f, 470.0f, 500.0f, eye);

        if (hair_selection == 2) {
            // Draw long hair
            canvas.drawOval(260.0f, 350.0f, 700.0f, 400.0f, hair);
            canvas.drawRect(270.0f, 370.0f, 350.0f, 800.0f, hair);
            canvas.drawRect(600.0f, 370.0f, 700.0f, 800.0f, hair);
        }

        // Draw shirt
        canvas.drawRect(165.0f, 900.0f, 800.0f, 1200.0f, hatPaint);
        canvas.drawOval(165.0f, 745.0f, 800.0f, 1100.0f, hatPaint);
    }

    // Getter methods
    public int getSkinColor() {
        return skinColor;
    }
    public int getRed(){
        return red;
    }

    public int getGreen(){
        return green;
    }

    public int getBlue(){
        return blue;
    }

    public void setBlue(int blu){
        this.blue = blu;
    }

    public void setRed(int re){
        this.red = re;
    }

    public void setGreen(int gree){
        this.green = gree;
    }


    public void setSelected(int selected){
        this.selected = selected;
    }
    public int getSelected(){
        return this.selected;
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

    // Setter methods
    public void setEyeColor(int rgb) {
        eyeColor = rgb;
        invalidate();
    }

    public void setHairColor(int rgb) {
        hairColor = rgb;
        invalidate();
    }

    public void setSkinColor(int rgb) {
        skinColor = rgb;
        invalidate();
    }

    // Method to update face color based on SeekBar progress
    public void updateFaceColor(int redProgress, int greenProgress, int blueProgress, int A) {
        if (A == 0) {
            setHairColor(Color.rgb(redProgress,greenProgress,blueProgress));
        } else if (A == 1){
            setEyeColor(Color.rgb(redProgress, greenProgress, blueProgress));
        } else if (A == 2){
            setSkinColor(Color.rgb(redProgress, greenProgress, blueProgress));
        }

        invalidate();
    }
}