package com.example.pjgg.evernoteapp.session;

import android.content.Context;
import android.content.res.Resources;

public class Session {

    private static Session INSTANCE = null;
    private static final Byte SESSIONOBJLOCK = new Byte((byte) 0);

    private Resources resources;
    private Context applicationContext;
    private ActivityEnum currentActivity = ActivityEnum.MAIN_ACTIVITY;

    private Session(){}

    public static Session getInstance() {
        if(INSTANCE == null) {
            synchronized(SESSIONOBJLOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new Session();
                }
            }
        }
        return INSTANCE;
    }

    public Resources getResources() {
        return resources;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }

    public Context getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(Context applicationContext) {
        this.applicationContext = applicationContext;
    }

    public ActivityEnum getCurrentActivity() {
        return currentActivity;
    }

    public void setCurrentActivity(ActivityEnum currentActivity) {
        this.currentActivity = currentActivity;
    }
}
