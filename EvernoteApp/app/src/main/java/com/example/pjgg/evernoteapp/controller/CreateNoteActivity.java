package com.example.pjgg.evernoteapp.controller;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.evernote.client.android.EvernoteUtil;
import com.evernote.edam.type.Note;
import com.example.pjgg.evernoteapp.R;
import com.example.pjgg.evernoteapp.connector.Connector;
import com.example.pjgg.evernoteapp.connector.EvernoteConnectorImpl;
import com.example.pjgg.evernoteapp.session.ActivityEnum;
import com.example.pjgg.evernoteapp.views.CreateNoteActivityView;

public class CreateNoteActivity extends Controller {

    private static final String TAG = "CreateNoteActivity";

    private Connector evernoteConnector = new EvernoteConnectorImpl();
    private CreateNoteActivityView createNoteActivityView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, ActivityEnum.CREATE_NOTE_ACTIVITY);
        setContentView(R.layout.activity_create_note);

        createNoteActivityView = new CreateNoteActivityView((EditText) findViewById(R.id.editTextBoxTitle), (EditText) findViewById(R.id.editTextBoxBody));
    }

    public void onClickbuttonCreateNote(View view){

        Note note = new Note();
        note.setTitle(createNoteActivityView.getTitleEditTextAsText());
        note.setContent(EvernoteUtil.NOTE_PREFIX + createNoteActivityView.getBodyEditTextAsText() + EvernoteUtil.NOTE_SUFFIX);

        evernoteConnector.createNote(note)
                .doOnNext(evernoteNote -> {

                    Intent i = new Intent(this,MainActivity.class);
                    startActivity(i);
                    finish();
                })
                .subscribe();

    }

}
