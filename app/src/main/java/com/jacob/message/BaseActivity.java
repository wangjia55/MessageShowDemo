package com.jacob.message;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Package : com.jacob.message
 * Author : jacob
 * Date : 15-3-16
 * Description : 这个类是用来xxx
 */
public abstract class BaseActivity extends FragmentActivity {


    protected MessageManager messageManager;

    protected MessageView mMessageView;

    protected Handler mUIHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            MessageBean messageBean = (MessageBean) msg.obj;
            showMessage(messageBean);

            Log.e("wangjia:", "base message:" + messageBean.getMessage());
        }
    };

    private void showMessage(MessageBean messageBean) {
        FrameLayout container = (FrameLayout) (GlobalVariableHolder.getInstance().getCurrentActivity().getRootView());
        final MessageView  mMessageView = new MessageView(this, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100);
        mMessageView.setLayoutParams(layoutParams);
        container.addView(mMessageView);
        mMessageView.setVisibility(View.VISIBLE);
        mMessageView.setMessage(messageBean.getMessage());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mMessageView.setVisibility(View.INVISIBLE);
                ((ViewGroup) mMessageView.getParent()).removeView(mMessageView);
            }
        }, 2500);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        messageManager = MessageManager.newInstance(mUIHandler);


    }

    @Override
    protected void onStart() {
        super.onStart();
        GlobalVariableHolder.getInstance().updateCurrentActivity(this);
    }


//    public abstract View getRootView();
    public View getRootView() {
        return findViewById(android.R.id.content);
    }
}
