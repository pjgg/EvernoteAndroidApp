package com.example.pjgg.evernoteapp.connector;


import com.evernote.edam.notestore.NoteList;
import com.evernote.edam.type.Note;

import rx.Observable;

public interface Connector {

 Boolean isLoggedIn();

 Observable<NoteList> retrieveNotes();

 Observable<Note> createNote(Note note);

 Observable<Note> retrieveNote(String guid);

}
