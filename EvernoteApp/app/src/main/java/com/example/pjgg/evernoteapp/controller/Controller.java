package com.example.pjgg.evernoteapp.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.pjgg.evernoteapp.connector.Connector;
import com.example.pjgg.evernoteapp.connector.EvernoteConnectorImpl;
import com.example.pjgg.evernoteapp.session.ActivityEnum;
import com.example.pjgg.evernoteapp.session.Session;

public abstract class Controller extends AppCompatActivity {

    private static final String TAG = "Controller";
    private Connector evernoteConnector = new EvernoteConnectorImpl();

    public void onCreate(Bundle savedInstanceState, ActivityEnum currentActivity) {
        super.onCreate(savedInstanceState);

        Session.getInstance().setCurrentActivity(currentActivity);
        Session.getInstance().setResources(getApplication().getResources());
        Session.getInstance().setApplicationContext(getApplicationContext());

        Log.d(TAG,"checking login");
        if (!evernoteConnector.isLoggedIn()){
            startActivity(new Intent(this,LoginActivity.class));
        }
    }
}
