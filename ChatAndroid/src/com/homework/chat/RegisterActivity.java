package com.homework.chat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Yushchenko on 01.10.2014.
 */
public class RegisterActivity extends Activity implements View.OnClickListener{
    private Button registerButton;
    private Button cancelButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.register_main);

        registerButton = (Button) findViewById(R.id.registerRegId);
        cancelButton = (Button) findViewById(R.id.cancelRegId);

        registerButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch ( view.getId() ) {
            case R.id.registerRegId:
                Intent intent = new Intent(this, ProfileActivity.class);

                startActivity(intent);
                break;
            case R.id.cancelRegId:
                finish();
                break;
            default:
                break;
        }
    }
}
