package com.example.pjgg.evernoteapp.connector;


import com.evernote.edam.notestore.NoteList;

import rx.Observable;

public interface Connector {

 Boolean isLoggedIn();

 Observable<NoteList> retrieveNotes();

}
