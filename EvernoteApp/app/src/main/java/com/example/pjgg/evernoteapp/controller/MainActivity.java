package com.example.pjgg.evernoteapp.controller;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.evernote.edam.notestore.NoteList;
import com.evernote.edam.type.Note;
import com.example.pjgg.evernoteapp.R;
import com.example.pjgg.evernoteapp.connector.Connector;
import com.example.pjgg.evernoteapp.connector.EvernoteConnectorImpl;
import com.example.pjgg.evernoteapp.converter.Converter;
import com.example.pjgg.evernoteapp.converter.NoteListToNoteConverter;
import com.example.pjgg.evernoteapp.model.AppNote;
import com.example.pjgg.evernoteapp.session.ActivityEnum;
import com.example.pjgg.evernoteapp.session.Session;
import com.example.pjgg.evernoteapp.views.MainActivityView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import rx.Observable;


public class MainActivity extends Controller {

    private static final String TAG = "MainActivity";

    private Converter<AppNote, Note> converter = new NoteListToNoteConverter();
    private Connector evernoteConnector = new EvernoteConnectorImpl();
    private MainActivityView mainActivityView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, ActivityEnum.MAIN_ACTIVITY);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "Login successfully");
        mainActivityView = new MainActivityView((ListView) findViewById(R.id.lv));

        Observable<NoteList> evernoteNoteList =  evernoteConnector.retrieveNotes();
        evernoteNoteList.doOnNext(noteList -> {
            final Collection<AppNote> appNotes = converter.createDataTransferObjects(noteList.getNotes());
            // min api version must be 24 in order to use Streams. :(
            //List<String> titleList = appNotes.stream().map(AppNote::getTitle).collect(Collectors.toList());
            List<String> titleList = new ArrayList<>();
            for (AppNote note : appNotes) {
                titleList.add(note.getTitle());
            }

             final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, titleList);

            AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                    AppNote[] notes = appNotes.toArray(new AppNote[appNotes.size()]);
                    String title = notes[position].getTitle();
                    String guid = notes[position].getGuid();

                    Observable<Note> evernoteNoteNote =  evernoteConnector.retrieveNote(guid);
                    evernoteNoteNote.doOnNext(note -> {
                        AppNote appNote = converter.createDataTransferObject(note);
                        launchShowNoteActivity(title, appNote.getContent());
                    }).doOnError(error ->
                            Log.e(TAG, error.getMessage()))
                            .subscribe();
                }
            };

            mainActivityView.getNoteslistView().setAdapter(arrayAdapter);

            mainActivityView.getNoteslistView().setOnItemClickListener(itemListener);


        }).subscribe();

    }

    public void onClickbuttonAddNote(View view){
        Intent i = new Intent(this,CreateNoteActivity.class);
        startActivity(i);
        finish();
    }

    private void launchShowNoteActivity(String title, String content){
        Intent i = new Intent(Session.getInstance().getApplicationContext(),ShowNoteActivity.class);
        i.putExtra("title", title);
        i.putExtra("content", content);
        startActivity(i);
        finish();
    }
}

