package com.fancy.mobileschool.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.fancy.mobileschool.R;

public class MessageDetailActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_detail);
        textView = (TextView) findViewById(R.id.message_detail_text);
        showText();
    }

    private void showText(){
        Intent intent = getIntent();
        String messageText = intent.getStringExtra("message");
        textView.setText(messageText);
    }
}
