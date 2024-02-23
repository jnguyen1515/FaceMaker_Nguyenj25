package com.example.facemaker_nguyenj25;
//@authoer James Nguyen

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
    private Paint skinColor;
    public int[] skin;
    private Paint eyeColor;
    public int[] eye;
    private Paint hairColor;
    public int[] hair;
    int hair_selection;
    int[][] obj;
    boolean fresh;
    private int selected = 0;
    private Paint[] a;
    private int red = 0;
    private int green = 0;
    private int blue = 0;
    int[] temp;
    //constructor to make face
    public Face(Context context, AttributeSet att) {
        super(context, att);
        setWillNotDraw(false);
        initialize();
    }
// // Initialize the Face object
    private void initialize() {
        Random random = new Random();
        fresh = true;
        skinColor = new Paint();
        red = (int) Math.floor(random.nextFloat() * 255);
        green = (int) Math.floor(random.nextFloat() * 255);
        blue = (int) Math.floor(random.nextFloat() * 255);
        skinColor.setARGB(255, red, green, blue);
        skin = new int[]{red, green, blue};
        eyeColor = new Paint();
        red = (int) Math.floor(random.nextFloat() * 255);
        green = (int) Math.floor(random.nextFloat() * 255);
        blue = (int) Math.floor(random.nextFloat() * 255);
        eyeColor.setARGB(255, red, green, blue);
        eye = new int[]{red, green, blue};
        hairColor = new Paint();
        red = (int) Math.floor(random.nextFloat() * 255);
        green = (int) Math.floor(random.nextFloat() * 255);
        blue = (int) Math.floor(random.nextFloat() * 255);
        a = new Paint[]{hairColor, eyeColor, skinColor};
        hairColor.setARGB(255, red, green, blue);
        hair = new int[]{red, green, blue};
        hair_selection = (int) Math.floor(random.nextFloat() * 3);
        obj = new int[][]{hair, eye, skin};
        temp = new int[]{red, green, blue};
    }

    @Override //draws the face
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        // Paint objects for colors
        hairColor.setARGB(255, obj[0][0], obj[0][1], obj[0][2]);
        Paint hair = hairColor;
        skinColor.setARGB(255, obj[2][0], obj[2][1], obj[2][2]);
        Paint skin = skinColor;
        eyeColor.setARGB(255, obj[1][0], obj[1][1], obj[1][2]);
        Paint eye = eyeColor;
        if (!fresh) {
            a[selected].setColor(Color.argb(255, red, green, blue));
        }
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
        fresh = false;
    }

    // Getter methods
    public Paint getSkinColor() {
        return skinColor;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blu) {
        this.blue = blu;
    }

    public void setRed(int re) {
        this.red = re;
    }

    public void setGreen(int gree) {
        this.green = gree;
    }


    public void setSelected(int selected) {
        this.selected = selected;
    }

    public int getSelected() {
        return this.selected;
    }


    public Paint getEyeColor() {
        return eyeColor;
    }

    public Paint getHairColor() {
        return hairColor;
    }

    public int[] getObj(int ind) {
        return obj[ind];
    }

    public void setObj(int r, int g, int b) {
        obj[selected][0] = r;
        obj[selected][1] = g;
        obj[selected][2] = b;
    }

}