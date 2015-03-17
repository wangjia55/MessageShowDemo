package com.jacob.message;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends BaseActivity {

    private Button mButtonAdd;
    private Button mButtonSecond;
    private TextView mTextView;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.textView);

        mButtonAdd = (Button) findViewById(R.id.button);
        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MessageBean message = new MessageBean("这是第：" + (count++));
                messageManager.addMessage(message);
                mTextView.setText("" + count);
            }
        });

        mButtonSecond = (Button) findViewById(R.id.button_go_other);
        mButtonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (messageManager != null) {
            messageManager.close();
        }
    }
}
