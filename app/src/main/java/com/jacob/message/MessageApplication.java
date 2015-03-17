package com.jacob.message;

import android.app.Application;
import android.util.Log;

/**
 * Package : com.jacob.message
 * Author : jacob
 * Date : 15-3-16
 * Description : 这个类是用来xxx
 */
public class MessageApplication extends Application {

    private static MessageApplication applications;

    public static MessageApplication newInstance() {
        return applications;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("wangjia:","application oncreate");
        applications = new MessageApplication();
    }


}
