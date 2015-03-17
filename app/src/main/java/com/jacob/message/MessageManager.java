package com.jacob.message;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * Package : com.jacob.message
 * Author : jacob
 * Date : 15-3-16
 * Description : 这个类是用来xxx
 */
public class MessageManager {

    private MessageManager() {
    }

    private static Handler myHandler;

    private static Handler mUIHandler;

    private MessageRunnable messageRunnable = new MessageRunnable();

    private static List<MessageBean> messageBeanList = new ArrayList<>();

    private static HandlerThread mHandlerThread = new HandlerThread("MessageLogic");

    private static MessageManager sInstance = new MessageManager();

    public static MessageManager newInstance(Handler handler) {
        mUIHandler = handler;
        if (!mHandlerThread.isAlive()) {
            try {
                mHandlerThread.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        myHandler = new Handler(mHandlerThread.getLooper());
        return sInstance;
    }

    public void addMessage(MessageBean message) {
        messageBeanList.add(message);
        myHandler.post(messageRunnable);
    }


    private class MessageRunnable implements Runnable {

        @Override
        public void run() {
            while (messageBeanList.size() > 0) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final MessageBean messageBean = messageBeanList.get(0);
                System.out.println(messageBean.getMessage());
                messageBeanList.remove(messageBean);
                Message message = mUIHandler.obtainMessage();
                message.obj = messageBean;
                mUIHandler.sendMessage(message);
                myHandler.post(this);
            }
        }
    }


    public void close() {
        messageBeanList.clear();
        myHandler.removeCallbacks(messageRunnable);
        if (mHandlerThread != null) {
            mHandlerThread.quit();
        }
    }

}