package com.example.pjgg.evernoteapp.controller;

import android.os.Bundle;
import android.util.Log;

import com.example.pjgg.evernoteapp.R;
import com.example.pjgg.evernoteapp.session.ActivityEnum;


public class MainActivity extends Controller {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, ActivityEnum.MAIN_ACTIVITY);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "Login successfully");
    }
}
