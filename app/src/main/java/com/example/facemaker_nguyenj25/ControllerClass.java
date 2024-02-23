package com.example.facemaker_nguyenj25;

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
    private final SeekBar seek1;
    private final SeekBar seek2;
    private final SeekBar seek3;
    private final Spinner spin;

    //face object
    Face face;

    private int selected = 0;
    private final RadioButton eyes;
    private final RadioButton hair;
    private final RadioButton skin;

    public ControllerClass(Face face, SeekBar red_seekbar, SeekBar blue_seekbar, SeekBar green_seekbar, Spinner spinner,
                           RadioButton radioEyes, RadioButton radioHair, RadioButton radioSkin) {
        seek1 = red_seekbar;
        seek2 = green_seekbar;
        seek3 = blue_seekbar;
        spin = spinner;
        eyes = radioEyes;
        hair = radioHair;
        skin = radioSkin;

        this.face = face;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        int red = face.getRed();
        int green = face.getGreen();
        int blue = face.getBlue();

        if (seekBar.getId() == R.id.red_seekbar ) {
            red = progress;
        } else if (seekBar.getId() == R.id.green_seekbar) {
            green = progress;
        } else if (seekBar.getId() == R.id.blue_seekbar) {
            blue = progress;
        }

        int intColor = Color.argb(255, red, green, blue);
        face.updateFaceColor(red,green,blue,selected);
        face.invalidate();
    }


    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner spin = (Spinner) parent;
        face.hair_selection = position;
        face.invalidate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // This method is called when nothing is selected in the spinner
    }


    @Override
    public void onClick(View v) {
        if (v instanceof RadioButton) {
            int red = seek1.getProgress();
            int green = seek2.getProgress();
            int blue = seek3.getProgress();

            if (v.getId() == R.id.eyes_radio) {
                // Update color for eyes
                face.setEyeColor(Color.rgb(red, green, blue));
            } else if (v.getId() == R.id.hair_radio) {
                // Update color for hair
                face.setHairColor(Color.rgb(red, green, blue));
            } else if (v.getId() == R.id.skin_radio) {
                // Update color for skin
                face.setSkinColor(Color.rgb(red, green, blue));
            }
        }
        face.invalidate();
    }
}
