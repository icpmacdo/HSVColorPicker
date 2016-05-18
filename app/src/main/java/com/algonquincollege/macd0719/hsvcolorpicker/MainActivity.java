package com.algonquincollege.macd0719.hsvcolorpicker;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.graphics.Color.HSVToColor;

public class MainActivity extends AppCompatActivity {


    public static float hueProgress = 0;
    public static float saturationProgress = 0;
    public static float lightnessProgress = 0;
    private static final String ABOUT_DIALOG_TAG;



    static {
        hueProgress = 0;
        saturationProgress = 0;
        lightnessProgress = 0;
        ABOUT_DIALOG_TAG = "About Dialog";

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final SeekBar hueSeekBar = (SeekBar) findViewById(R.id.hueSeekBarId);
        final TextView hueText = (TextView) findViewById(R.id.hueTextId);

        final SeekBar saturationSeekBar = (SeekBar) findViewById(R.id.saturationSeekBarId);
        final TextView saturationText = (TextView) findViewById(R.id.saturationTextId);

        final SeekBar lightnessSeekBar = (SeekBar) findViewById(R.id.lightnessSeekBarId);
        final TextView lightnessText = (TextView) findViewById(R.id.lightnessTextId);

        final Button blackBtn = (Button) findViewById(R.id.blackButtonId);
        final Button redBtn = (Button) findViewById(R.id.redButtonId);
        final Button limeBtn = (Button) findViewById(R.id.limeButtonId);
        final Button blueBtn = (Button) findViewById(R.id.blueButtonId);
        final Button yellowBtn = (Button) findViewById(R.id.yellowButtonId);

        final Button cyanBtn = (Button) findViewById(R.id.cyanButtonId);
        final Button magentaBtn = (Button) findViewById(R.id.magentaButtonId);
        final Button silverBtn = (Button) findViewById(R.id.silverButtonId);
        final Button grayBtn = (Button) findViewById(R.id.grayButtonId);
        final Button maroonBtn = (Button) findViewById(R.id.maroonButtonId);

        final Button oliveBtn = (Button) findViewById(R.id.oliveButtonId);
        final Button greenBtn = (Button) findViewById(R.id.greenButtonId);
        final Button purpleBtn = (Button) findViewById(R.id.purpleButtonId);
        final Button tealBtn = (Button) findViewById(R.id.tealButtonId);
        final Button navyBtn = (Button) findViewById(R.id.navyButtonId);

        hueSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                //hueText.setText(progress);
                //Toast.makeText(getApplicationContext(), String.valueOf("Progress: " + progress), Toast.LENGTH_LONG).show();
                hueProgress = progress;
                hueText.setText("HUE: " + Math.round(hueProgress) + "\u00B0");

                //Changes setting colors HERE
                setTextviewColor(hueProgress, saturationProgress, lightnessProgress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


                //Toast.makeText(getApplicationContext(), String.valueOf("on Start Tracking Touch"), Toast.LENGTH_LONG).show();
                hueText.setText("HUE: " + Math.round(hueProgress) + "\u00B0" );
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(getApplicationContext(), String.valueOf("on Stop Tracking Touch"), Toast.LENGTH_LONG).show();
                hueText.setText("Hue");

            }
        });

        saturationSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                //hueText.setText(progress);
                //Toast.makeText(getApplicationContext(), String.valueOf("Progress: " + progress), Toast.LENGTH_LONG).show();
                saturationProgress = progress;
                saturationText.setText("SATURATION: " + Math.round(saturationProgress) + "%");



                //Changes setting colors HERE
                setTextviewColor(hueProgress, saturationProgress, lightnessProgress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


                //Toast.makeText(getApplicationContext(), String.valueOf("on Start Tracking Touch"), Toast.LENGTH_LONG).show();
                saturationText.setText("SATURATION: " + Math.round(saturationProgress)  + "%");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(getApplicationContext(), String.valueOf("on Stop Tracking Touch"), Toast.LENGTH_LONG).show();
                saturationText.setText("Saturation");

            }
        });

        lightnessSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                //hueText.setText(progress);
                //Toast.makeText(getApplicationContext(), String.valueOf("Progress: " + progress), Toast.LENGTH_LONG).show();
                lightnessProgress = progress;
                lightnessText.setText("VALUE / LIGHTNESS: " + Math.round(lightnessProgress) + "%");

                //Changes setting color HERE
                setTextviewColor(hueProgress, saturationProgress, lightnessProgress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                lightnessText.setText("VALUE / LIGHTNESS: " + Math.round(lightnessProgress) + "%");
                //Toast.makeText(getApplicationContext(), String.valueOf("on Start Tracking Touch"), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(getApplicationContext(), String.valueOf("on Stop Tracking Touch"), Toast.LENGTH_LONG).show();
                lightnessText.setText("Value / Lightness");

            }
        });

        blackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setTextviewColor(0, 0, 0);
                hueSeekBar.setProgress(0);
                saturationSeekBar.setProgress(0);
                lightnessSeekBar.setProgress(0);
                lightnessText.setText("Value / Lightness");
                saturationText.setText("Saturation");
                hueText.setText("Hue");
                Toast.makeText(getApplicationContext(), "H: 0° S: O% V: 0%", Toast.LENGTH_SHORT).show();


            }
        });


        redBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTextviewColor(0, 100, 100);
                hueSeekBar.setProgress(0);
                saturationSeekBar.setProgress(100);
                lightnessSeekBar.setProgress(100);
                lightnessText.setText("Value / Lightness");
                saturationText.setText("Saturation");
                hueText.setText("Hue");
                Toast.makeText(getApplicationContext(), "H: 0° S: 10O% V: 100%", Toast.LENGTH_SHORT).show();

            }
        });

        limeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTextviewColor(120, 100, 100);
                hueSeekBar.setProgress(120);
                saturationSeekBar.setProgress(100);
                lightnessSeekBar.setProgress(100);
                lightnessText.setText("Value / Lightness");
                saturationText.setText("Saturation");
                hueText.setText("Hue");
                Toast.makeText(getApplicationContext(), "H: 120° S: 10O% V: 100%", Toast.LENGTH_SHORT).show();

            }
        });

        blueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTextviewColor(240, 100, 100);
                hueSeekBar.setProgress(240);
                saturationSeekBar.setProgress(100);
                lightnessSeekBar.setProgress(100);
                lightnessText.setText("Value / Lightness");
                saturationText.setText("Saturation");
                hueText.setText("Hue");
                Toast.makeText(getApplicationContext(), "H: 240° S: 10O% V: 100%", Toast.LENGTH_SHORT).show();

            }
        });

        yellowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTextviewColor(60, 100, 100);
                hueSeekBar.setProgress(60);
                saturationSeekBar.setProgress(100);
                lightnessSeekBar.setProgress(100);
                lightnessText.setText("Value / Lightness");
                saturationText.setText("Saturation");
                hueText.setText("Hue");
                Toast.makeText(getApplicationContext(), "H: 60° S: 10O% V: 100%", Toast.LENGTH_SHORT).show();

            }
        });

        cyanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTextviewColor(180, 100, 100);
                hueSeekBar.setProgress(180);
                saturationSeekBar.setProgress(100);
                lightnessSeekBar.setProgress(100);
                lightnessText.setText("Value / Lightness");
                saturationText.setText("Saturation");
                hueText.setText("Hue");
                Toast.makeText(getApplicationContext(), "H: 180° S: 10O% V: 100%", Toast.LENGTH_SHORT).show();

            }
        });

        magentaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTextviewColor(300, 100, 100);
                hueSeekBar.setProgress(300);
                saturationSeekBar.setProgress(100);
                lightnessSeekBar.setProgress(100);
                lightnessText.setText("Value / Lightness");
                saturationText.setText("Saturation");
                hueText.setText("Hue");
                Toast.makeText(getApplicationContext(), "H: 300° S: 100% V: 100%", Toast.LENGTH_SHORT).show();

            }
        });

        silverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTextviewColor(0, 0, 75);
                hueSeekBar.setProgress(0);
                saturationSeekBar.setProgress(0);
                lightnessSeekBar.setProgress(75);
                lightnessText.setText("Value / Lightness");
                saturationText.setText("Saturation");
                hueText.setText("Hue");
                Toast.makeText(getApplicationContext(), "H: 0° S: O% V: 75%", Toast.LENGTH_SHORT).show();

            }
        });

        grayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTextviewColor(0, 0, 50);
                hueSeekBar.setProgress(0);
                saturationSeekBar.setProgress(0);
                lightnessSeekBar.setProgress(50);
                lightnessText.setText("Value / Lightness");
                saturationText.setText("Saturation");
                hueText.setText("Hue");
                Toast.makeText(getApplicationContext(), "H: 0° S: O% V: 50%", Toast.LENGTH_SHORT).show();

            }
        });

        maroonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTextviewColor(0, 100, 50);
                hueSeekBar.setProgress(0);
                saturationSeekBar.setProgress(100);
                lightnessSeekBar.setProgress(50);
                lightnessText.setText("Value / Lightness");
                saturationText.setText("Saturation");
                hueText.setText("Hue");
                Toast.makeText(getApplicationContext(), "H: 0° S: 10O% V: 50%", Toast.LENGTH_SHORT).show();

            }
        });

        oliveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTextviewColor(60, 100, 50);
                hueSeekBar.setProgress(60);
                saturationSeekBar.setProgress(100);
                lightnessSeekBar.setProgress(50);
                lightnessText.setText("Value / Lightness");
                saturationText.setText("Saturation");
                hueText.setText("Hue");
                Toast.makeText(getApplicationContext(), "H: 60° S: 10O% V: 50%", Toast.LENGTH_SHORT).show();

            }
        });

        greenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTextviewColor(120, 100, 50);
                hueSeekBar.setProgress(120);
                saturationSeekBar.setProgress(100);
                lightnessSeekBar.setProgress(50);
                lightnessText.setText("Value / Lightness");
                saturationText.setText("Saturation");
                hueText.setText("Hue");
                Toast.makeText(getApplicationContext(), "H: 120° S: 10O% V: 50%", Toast.LENGTH_SHORT).show();

            }
        });

        purpleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTextviewColor(300, 100, 50);
                hueSeekBar.setProgress(300);
                saturationSeekBar.setProgress(100);
                lightnessSeekBar.setProgress(50);
                lightnessText.setText("Value / Lightness");
                saturationText.setText("Saturation");
                hueText.setText("Hue");
                Toast.makeText(getApplicationContext(), "H: 300° S: 10O% V: 50%", Toast.LENGTH_SHORT).show();

            }
        });

        tealBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTextviewColor(180, 100, 50);
                hueSeekBar.setProgress(180);
                saturationSeekBar.setProgress(100);
                lightnessSeekBar.setProgress(50);
                lightnessText.setText("Value / Lightness");
                saturationText.setText("Saturation");
                hueText.setText("Hue");
                Toast.makeText(getApplicationContext(), "H: 180° S: 10O% V: 50%", Toast.LENGTH_SHORT).show();

            }
        });

        navyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTextviewColor(240, 100, 50);
                hueSeekBar.setProgress(240);
                saturationSeekBar.setProgress(100);
                lightnessSeekBar.setProgress(50);
                lightnessText.setText("Value / Lightness");
                saturationText.setText("Saturation");
                hueText.setText("Hue");
                Toast.makeText(getApplicationContext(), "H: 240° S: 10O% V: 50%", Toast.LENGTH_SHORT).show();

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            DialogFragment newFragment = new AboutDialogFragment();
            newFragment.show( getFragmentManager(), ABOUT_DIALOG_TAG );
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setTextviewColor(float a, float b, float c){
        b = b / 100;
        c = c / 100;
        final TextView mainColorTxtView = (TextView) findViewById(R.id.mainColorId);
        final float[] hueSatLightValues = {a,b,c};
        int colorValBack = HSVToColor(hueSatLightValues);
        mainColorTxtView.setBackgroundColor(colorValBack);
        mainColorTxtView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getApplicationContext(), "H: " + Math.round(hueSatLightValues[0]) + "° S: " + Math.round((hueSatLightValues[1]) * 100) + "% V: " + Math.round((hueSatLightValues[2]) * 100) + "%", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}
