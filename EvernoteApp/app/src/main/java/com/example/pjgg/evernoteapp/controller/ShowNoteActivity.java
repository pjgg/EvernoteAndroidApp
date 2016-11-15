package com.example.pjgg.evernoteapp.controller;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.pjgg.evernoteapp.R;
import com.example.pjgg.evernoteapp.session.ActivityEnum;
import com.example.pjgg.evernoteapp.views.ShowNoteActivityView;

public class ShowNoteActivity extends Controller {

    private static final String TAG = "ShowNoteActivity";

    private ShowNoteActivityView showNoteActivityView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, ActivityEnum.SHOW_NOTE_ACTIVITY);
        setContentView(R.layout.activity_show_note);

        showNoteActivityView = new ShowNoteActivityView((TextView) findViewById(R.id.textViewTitle), (TextView) findViewById(R.id.textViewBody));
        String title = getIntent().getStringExtra("title").toString();
        String content = getIntent().getStringExtra("content").toString();

        showNoteActivityView.getTitle().setText(title);
        showNoteActivityView.getContent().setText(content);
    }

    public void onClickbuttonShowNoteDone(View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }
}
