package com.example.facemaker_nguyenj25;
//@author James Nguyen

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.RadioButton;
import android.widget.SeekBar;


public class MainActivity extends AppCompatActivity {

    private Face surfaceView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        surfaceView = findViewById(R.id.surfaceView1);
        // Initialize the spinner and populate it with the hair options from resources
        Spinner spinner = findViewById(R.id.hair_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.hair_array, android.R.layout.simple_spinner_item);
        // Set the layout for the drop-down items
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Set the adapter for the spinner
        spinner.setAdapter(adapter);


        SeekBar rSeekbar = findViewById(R.id.red_seekbar);
        SeekBar gSeekbar = findViewById(R.id.green_seekbar);
        SeekBar bSeekbar = findViewById(R.id.blue_seekbar);

        RadioButton radioEyes = findViewById(R.id.eyes_radio);
        RadioButton radioHair = findViewById(R.id.hair_radio);
        RadioButton radioSkin = findViewById(R.id.skin_radio);

        ControllerClass colorControl = new ControllerClass(surfaceView, rSeekbar, gSeekbar, bSeekbar,
                spinner, radioEyes, radioHair, radioSkin);

        spinner.setOnItemSelectedListener(colorControl);
        rSeekbar.setOnSeekBarChangeListener(colorControl);
        gSeekbar.setOnSeekBarChangeListener(colorControl);
        bSeekbar.setOnSeekBarChangeListener(colorControl);
    }
}


