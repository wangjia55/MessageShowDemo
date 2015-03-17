package com.jacob.message;

/**
 * Created by jacob on 14-9-8.
 */

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MessageView extends LinearLayout implements View.OnClickListener {
    private Context mContext;
    private TextView mTextViewMsg;

    public MessageView(Context context) {
        super(context);
    }

    public MessageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        LayoutInflater.from(context).inflate(R.layout.layout_message, this);
        mTextViewMsg = (TextView) findViewById(R.id.textView_message);
        mTextViewMsg.setOnClickListener(this);
    }

    public MessageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textView_message:
                System.out.println("点击我了，哈哈");
                break;
            default:
                break;
        }
    }

    public void setMessage(String message) {
        mTextViewMsg.setText(message);
    }


    @Override
    public void setVisibility(int visibility) {
        if (visibility == VISIBLE) {
            Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.anim_view_show_from_top_to_bottom);
            setAnimation(animation);
            animation.start();
        } else {
            Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.anim_view_dismiss_from_bottom_to_top);
            setAnimation(animation);
            animation.start();
        }
        super.setVisibility(visibility);
    }
}