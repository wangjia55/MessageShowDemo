package com.jacob.message;


/**
 * Created by jianhaohong on 9/24/14.
 */
public class GlobalVariableHolder {
    private static GlobalVariableHolder globalVariableHolder = new GlobalVariableHolder();
    private BaseActivity mCurrentActivity;

    private GlobalVariableHolder() {

    }

    public static GlobalVariableHolder getInstance() {
        return globalVariableHolder;
    }

    public void updateCurrentActivity(BaseActivity activity) {
        mCurrentActivity = activity;
    }

    public BaseActivity getCurrentActivity() {
        return mCurrentActivity;
    }

}
