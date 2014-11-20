package com.homework.chat;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;
import android.widget.LinearLayout.LayoutParams;

import java.util.Date;

/**
 * Created by Yushchenko on 02.10.2014.
 */
public class LettersActivity extends Activity implements OnClickListener {
    private Button sendButton;
    private TextView messages;
    final int MENU_LOGOUT = 2;
    final int MENU_PROFILE = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.messages_main);

        sendButton = (Button) findViewById(R.id.sendIdButton);

        sendButton.setOnClickListener(this);
        showLetters();

        registerForContextMenu(sendButton);

    }

    public void onCreateContextMenu(ContextMenu menu, View v,ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, MENU_PROFILE, 0, "Profile");
        menu.add(0, MENU_LOGOUT, 0, "Logout");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        Intent intent = null;

        switch (item.getItemId()) {
            // пункты меню для tvColor
            case MENU_PROFILE:
                intent = new Intent(this, ProfileActivity.class);

                startActivity(intent);
                break;
            case MENU_LOGOUT:
                finish();
                break;
            default:
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {

            case KeyEvent.KEYCODE_MENU:
                // Do Sometihng
                openContextMenu(sendButton);
                //Toast.makeText(this, "Нажата кнопка Cancel", Toast.LENGTH_LONG).show();
                break;

            default:
                break;
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu_letters_activity, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View view) {
        switch ( view.getId() ) {
            case R.id.sendIdButton:
            {
                EditText message = (EditText) findViewById(R.id.textMessageId);

                if ( message.getText().length() > 0 ) {
                    message.setText("");
                }
            }
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch ( item.getItemId() ) {
            case R.id.contactsId:
            {
                Intent intent = new Intent(this, UsersListActivity.class);

                startActivity(intent);
            }
            break;
            default:
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    public void showLetters() {
        Date date = new Date();
        String nickName = "X-Treem: ";
        LinearLayout llMain = (LinearLayout) findViewById(R.id.scrollLinearId);

        for ( int i =0 ; i < 25; i++ ) {
            LinearLayout layout = new LinearLayout(this);
            layout.setOrientation(LinearLayout.HORIZONTAL);
            layout.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
            TextView textTime = new TextView(this);
            TextView textNick = new TextView(this);
            TextView textMessage = new TextView(this);

            textNick.setTypeface(null, Typeface.BOLD);
            textTime.setText(String.format("[%d:%d] ", date.getHours(), date.getMinutes()));
            textNick.setText(nickName);
            textMessage.setText("Hello!");
            layout.addView(textTime);
            layout.addView(textNick);
            layout.addView(textMessage);
            llMain.addView(layout);
        }
    }
}
