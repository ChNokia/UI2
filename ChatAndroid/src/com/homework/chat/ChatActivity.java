package com.homework.chat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class ChatActivity extends Activity implements OnClickListener {
    /**
     * Called when the activity is first created.
     */
    private Button btnLogin;
    private Button btnRegister;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.main);

        btnRegister = (Button) findViewById(R.id.registerIdButton);
        btnLogin  = (Button) findViewById(R.id.loginIdButton);

        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;

        switch (view.getId()) {
            case R.id.registerIdButton:
                intent = new Intent(this, RegisterActivity.class);

                startActivity(intent);
                break;
            case R.id.loginIdButton:
                intent = new Intent(this, LettersActivity.class);

                startActivity(intent);
            default:
                break;
        }

    }
}
