package com.homework.chat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

/**
 * Created by Yushchenko on 01.10.2014.
 */
public class ProfileActivity extends Activity implements OnClickListener {
    private Button saveButton;
    private Button cancelButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.profile_main);

        cancelButton = (Button) findViewById(R.id.cancelProfId);
        saveButton = (Button) findViewById(R.id.saveProfId);

        cancelButton.setOnClickListener(this);
        saveButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch ( view.getId() ) {
            case R.id.cancelProfId:
                finish();
                break;
            default:
                break;
        }
    }
}
