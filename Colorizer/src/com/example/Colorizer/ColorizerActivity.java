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

public class ColorizerActivity extends Activity implements OnSeekBarChangeListener{
    private SeekBar seekBarColor;
    private LinearLayout colorShow;
    private int[] arrayColor ={ 0xFFFF0000,
                                0xFFFFFF00,
                                0xFF00FF00,
                                0xFF00FFFF,
                                0xFF0000FF,
                                0xFFFF00FF,
                                0xFFFF0000};

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
        seekBarColor.setProgressDrawable((Drawable) shape);
        seekBarColor.setOnSeekBarChangeListener(this);
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
            float[] hsvColor = {0, 1, 1};
            hsvColor[0] = 360f * progress / seekBar.getMax();
            int lower = Color.argb(0xFF,progress*0x10000, progress*0x100, progress)+0xff000000;

            colorShow.setBackgroundColor(Color.HSVToColor(hsvColor));
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
