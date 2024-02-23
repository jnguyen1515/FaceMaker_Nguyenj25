package com.example.facemaker_nguyenj25;
//@authoer James Nguyen

import java.util.Random;
import android.graphics.Color;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.RadioButton;

public class ControllerClass implements SeekBar.OnSeekBarChangeListener,
        AdapterView.OnItemSelectedListener, View.OnClickListener {
    //private instance variables

    private final SeekBar seek1;
    private final SeekBar seek2;
    private final Button rand;
    private final SeekBar seek3;
    private final Spinner spin;
    Random random = new Random();

    //object
    Face face;

    private int selected = 0;
    private final RadioButton eyes;
    private final RadioButton hair;
    private final RadioButton skin;

    // A Constructor that initialize the ControllerClass
    public ControllerClass(Face face, SeekBar red_seekbar, SeekBar blue_seekbar, SeekBar green_seekbar, Spinner spinner,
                           RadioButton radioEyes, RadioButton radioHair, RadioButton radioSkin, Button random) {
        seek1 = red_seekbar;
        seek2 = green_seekbar;
        seek3 = blue_seekbar;
        spin = spinner;
        eyes = radioEyes;
        hair = radioHair;
        skin = radioSkin;
        this.rand = random;

        this.face = face;
        // Set initial progress of SeekBars
        seek1.setProgress(face.getRed());
        seek2.setProgress(face.getGreen());
        seek3.setProgress(face.getBlue());
    }

    // Called when SeekBar progresses
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        // Check which SeekBar was changed and updates the color value
        if (seekBar.getId() == R.id.red_seekbar && fromUser) {
            face.setRed(progress);
            face.setObj(progress, face.getGreen(), face.getBlue());
        } else if (seekBar.getId() == R.id.green_seekbar && fromUser) {
            face.setGreen(progress);
            face.setObj(face.getRed(), progress, face.getBlue());
        } else if (seekBar.getId() == R.id.blue_seekbar && fromUser) {
            face.setBlue(progress);
            face.setObj(face.getRed(), face.getGreen(), progress);
        }
        // Redraw the face view
        face.invalidate();
    }

    // Called when the user starts touching a SeekBar
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // Not used in this implementation
    }

    // Called when the user stops touching a SeekBar
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // Not used in this implementation
    }

    // Called when an item in the spinner is selected
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // Update hair selection in face object
        face.hair_selection = position;
        // Redraw the face view
        face.invalidate();
    }

    // Called when nothing is selected in the spinner
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // This method is called when nothing is selected in the spinner
    }

    // Called when a View (RadioButton or Button) is clicked
    @Override
    public void onClick(View v) {
        if (v instanceof RadioButton) {
            // Handle RadioButton clicks
            if (v.getId() == R.id.eyes_radio) {

                face.setSelected(1);

                face.setRed(face.obj[1][0]);
                face.setGreen(face.obj[1][1]);
                face.setBlue(face.obj[1][2]);

                seek1.setProgress(face.getRed());
                seek2.setProgress(face.getGreen());
                seek3.setProgress(face.getBlue());
            } else if (v.getId() == R.id.hair_radio) {

                face.setSelected(0);

                face.setRed(face.obj[0][0]);
                face.setGreen(face.obj[0][1]);
                face.setBlue(face.obj[0][2]);

                seek1.setProgress(face.getRed());
                seek2.setProgress(face.getGreen());
                seek3.setProgress(face.getBlue());
            } else if (v.getId() == R.id.skin_radio) {
                // Update selected feature to skin
                face.setSelected(2);
                // Update RGB values based on selected feature
                face.setRed(face.obj[2][0]);
                face.setGreen(face.obj[2][1]);
                face.setBlue(face.obj[2][2]);
                // Update SeekBars to reflect new RGB values
                seek1.setProgress(face.getRed());
                seek2.setProgress(face.getGreen());
                seek3.setProgress(face.getBlue());
            }
        } else if (v instanceof Button) {
            // Handle Button (random) click
            face.hair_selection = (int) Math.floor(random.nextFloat() * 3);
            int temp = face.getSelected();
            for (int i = 0; i < 3; i++) {
                face.setSelected(i);
                face.setRed((int) Math.floor(random.nextFloat() * 255));
                face.setGreen((int) Math.floor(random.nextFloat() * 255));
                face.setBlue((int) Math.floor(random.nextFloat() * 255));
                face.setObj(face.getRed(), face.getGreen(), face.getBlue());
            }
            face.setSelected(temp);

            face.setRed(face.obj[selected][0]);
            face.setGreen(face.obj[selected][1]);
            face.setBlue(face.obj[selected][2]);
        }
        // Redraw the face view
        face.invalidate();
    }
}

