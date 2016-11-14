package com.example.pjgg.evernoteapp.controller;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.evernote.client.android.EvernoteUtil;
import com.evernote.edam.type.Note;
import com.example.pjgg.evernoteapp.R;
import com.example.pjgg.evernoteapp.connector.Connector;
import com.example.pjgg.evernoteapp.connector.EvernoteConnectorImpl;
import com.example.pjgg.evernoteapp.session.ActivityEnum;

public class CreateNoteActivity extends Controller {

    private static final String TAG = "CreateNoteActivity";

    Connector evernoteConnector = new EvernoteConnectorImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, ActivityEnum.CREATE_NOTE_ACTIVITY);
        setContentView(R.layout.activity_create_note);

        // Get reference of widgets from XML layout
        final Button btn = (Button) findViewById(R.id.buttonCreateNote);

    }

    public void onClickbuttonCreateNote(View view){

        final EditText titleEditText = (EditText) findViewById(R.id.editTextBoxTitle);
        final EditText bodyEditText = (EditText) findViewById(R.id.editTextBoxBody);

        Note note = new Note();
        note.setTitle(titleEditText.getText().toString());
        note.setContent(EvernoteUtil.NOTE_PREFIX + bodyEditText.getText().toString() + EvernoteUtil.NOTE_SUFFIX);

        evernoteConnector.createNote(note)
                .doOnNext(evernoteNote -> {

                    Intent i = new Intent(this,MainActivity.class);
                    startActivity(i);
                    finish();
                })
                .subscribe();

    }

}
