package com.jacob.message;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Package : com.jacob.message
 * Author : jacob
 * Date : 15-3-16
 * Description : 这个类是用来xxx
 */
public class SecondActivity extends BaseActivity {
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button button = (Button) findViewById(R.id.button_second);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MessageBean messageBean = new MessageBean("这个second的消息：" + (count++));
                messageManager.addMessage(messageBean);
            }
        });
    }

}
