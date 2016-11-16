package com.example.pjgg.evernoteapp.controller;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
import java.util.Collections;
import java.util.List;

import rx.Observable;


public class MainActivity extends Controller {

    private static final String TAG = "MainActivity";

    private Converter<AppNote, Note> converter = new NoteListToNoteConverter();
    private Connector evernoteConnector = new EvernoteConnectorImpl();
    private MainActivityView mainActivityView;
    private List<AppNote> appNotes;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.order_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, ActivityEnum.MAIN_ACTIVITY);
        setContentView(R.layout.activity_main);

        Log.d(TAG,"checking login");
        if (evernoteConnector.isLoggedIn()){
            Log.d(TAG, "Login successfully");
            mainActivityView = new MainActivityView((ListView) findViewById(R.id.lv));

            Observable<NoteList> evernoteNoteList = evernoteConnector.retrieveNotes();
            evernoteNoteList.doOnNext(noteList -> {
                appNotes = converter.createDataTransferObjects(noteList.getNotes());
              //  List<String> titleList = appNotes.stream().map(AppNote::getTitle).collect(Collectors.toList());
                List<String> titleList = new ArrayList<>();
                for (AppNote note : appNotes) {
                    titleList.add(note.getTitle());
                }

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, titleList);

                mainActivityView.getNoteslistView().setAdapter(arrayAdapter);
                mainActivityView.getNoteslistView().setOnItemClickListener(itemListener);

            }).subscribe();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d(TAG, "title");

            switch (item.getItemId()) {
                case R.id.title:
                    Collections.sort(appNotes, AppNote.titleComparator);
                    break;

                case R.id.creation_date:
                    Collections.sort(appNotes, AppNote.createDateComparator);
                    break;

                case R.id.update_date:
                    Collections.sort(appNotes, AppNote.updateNoteComparator);
                    break;
            }

        List<String> titleList = new ArrayList<>();
        for (AppNote note : appNotes) {
            titleList.add(note.getTitle());
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, titleList);

        mainActivityView.getNoteslistView().setAdapter(arrayAdapter);
        ((ArrayAdapter)mainActivityView.getNoteslistView().getAdapter()).notifyDataSetChanged();

        return true;
    }


    public void onClickbuttonAddNote(View view) {
        Intent i = new Intent(this, CreateNoteActivity.class);
        startActivity(i);
        finish();
    }

    private void launchShowNoteActivity(String title, String content) {
        Intent i = new Intent(Session.getInstance().getApplicationContext(), ShowNoteActivity.class);
        i.putExtra("title", title);
        i.putExtra("content", content);
        startActivity(i);
        finish();
    }

    private AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
            AppNote[] notes = appNotes.toArray(new AppNote[appNotes.size()]);
            String title = notes[position].getTitle();
            String guid = notes[position].getGuid();

            Observable<Note> evernoteNoteNote = evernoteConnector.retrieveNote(guid);
            evernoteNoteNote.doOnNext(note -> {
                AppNote appNote = converter.createDataTransferObject(note);
                launchShowNoteActivity(title, appNote.getContent());
            }).doOnError(error ->
                    Log.e(TAG, error.getMessage()))
                    .subscribe();
        }
    };

}

