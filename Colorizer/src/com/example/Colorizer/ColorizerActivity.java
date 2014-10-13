package com.example.Colorizer;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class ColorizerActivity extends Activity implements OnSeekBarChangeListener{
    /**
     * Called when the activity is first created.
     */
    private SeekBar seekBarColor;
    private LinearLayout colorShow;
    private int[] arrayColor ={0xFFFF0000, 0xFFFFFF00, 0xFF00FF00,
            0xFF00FFFF, 0xFF0000FF,
            0xFFFF00FF, 0xFFFF0000};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        seekBarColor = (SeekBar) findViewById(R.id.seekId);
        colorShow = (LinearLayout) findViewById(R.id.colorLayoutId);
        DisplayMetrics metrics = new DisplayMetrics();

        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        LinearGradient rainbow = new LinearGradient(0f, 0f, metrics.widthPixels, 0f,
                arrayColor, null, Shader.TileMode.CLAMP);

        RoundRectShape roundedRect = new RoundRectShape(new float [] {0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f} , null, null);

        ShapeDrawable shape = new ShapeDrawable(roundedRect);
        shape.getPaint().setShader(rainbow);

        seekBarColor.setMax(256*6-1);
        seekBarColor.setProgressDrawable((Drawable) shape);
        seekBarColor.setOnSeekBarChangeListener(this);



        int widthInt = seekBarColor.getWidth();
        int width = colorShow.getWidth();
        float width1 = colorShow.getWidth();
        int width11 = colorShow.getWidth();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if ( fromUser ) {
            int r = 0;
            int g = 0;
            int b = 0;

            if ( progress < 256 ) {
                r = 255;
                g = progress % 256;
            } else if ( progress < 256 * 2 ) {
                r = 256 - progress % 256;
                g = 255;
            } else if ( progress < 256 * 3 ) {
                g = 255;
                b = progress % 256;
            } else if ( progress < 256 * 4 ) {
                g = 256 - progress % 256;
                b = 255;
            } else if ( progress < 256 * 5 ) {
                r = progress % 256;
                b = 255;
            } else if ( progress < 256 * 6 ) {
                r = 255;
                b = 256 - progress % 256;
            }

            colorShow.setBackgroundColor(Color.argb(255, r, g, b));
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
