package com.example.pjgg.evernoteapp.connector;


import android.util.Log;

import com.evernote.client.android.EvernoteSession;
import com.evernote.edam.notestore.NoteFilter;
import com.evernote.edam.notestore.NoteList;
import com.evernote.edam.type.Note;
import com.example.pjgg.evernoteapp.session.Session;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class EvernoteConnectorImpl implements Connector{

    private static final String TAG = "EvernoteConnectorImpl";

    private static final String CONSUMER_KEY = "pablostratio";
    private static final String CONSUMER_SECRET = "0f4fd37164723c01";
    private static final EvernoteSession.EvernoteService EVERNOTE_SERVICE = EvernoteSession.EvernoteService.SANDBOX;
    private static final boolean SUPPORT_APP_LINKED_NOTEBOOKS = true;
    private static final boolean FORCE_AUTHENTICATION_IN_THIRD_PARTY_APP = true;

    private static final int DEFAULT_OFFSET = 0;
    private static final int DEFAULT_MAXNOTES = 10;

    @Override
    public Boolean isLoggedIn() {
        Log.d(TAG, "isLoggedIn");
        return retrieveEvernoteSession().isLoggedIn();
    }

    @Override
    public Observable<Note> createNote(final Note note) {

        Observable<Note> noteEmiter =  Observable.create((Observable.OnSubscribe<Note>) subscriber -> {
                try {
                    Note data = retrieveEvernoteSession().getEvernoteClientFactory().getNoteStoreClient().createNote(note);
                    subscriber.onNext(data);
                    subscriber.onCompleted();
                }catch(Exception e){
                    subscriber.onError(e);
                }
            });

        return noteEmiter.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());

    }

    @Override
    public Observable<NoteList> retrieveNotes(){

        Observable evernoteNoteList = evernoteNoteList = fetchNotesFromEvernotes
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());

        return evernoteNoteList;
    }

    private EvernoteSession retrieveEvernoteSession(){
        EvernoteSession mEvernoteSession = new EvernoteSession.Builder(Session.getInstance().getApplicationContext())
                .setEvernoteService(EVERNOTE_SERVICE)
                .setSupportAppLinkedNotebooks(SUPPORT_APP_LINKED_NOTEBOOKS)
                .setForceAuthenticationInThirdPartyApp(FORCE_AUTHENTICATION_IN_THIRD_PARTY_APP)
                .build(CONSUMER_KEY, CONSUMER_SECRET)
                .asSingleton();

        return EvernoteSession.getInstance();
    }

    private Observable<NoteList> fetchNotesFromEvernotes = Observable.create(new Observable.OnSubscribe<NoteList>() {
        @Override
        public void call(Subscriber<? super NoteList> subscriber) {
            try {
                NoteList data = retrieveEvernoteSession().getEvernoteClientFactory().getNoteStoreClient().findNotes(new NoteFilter() ,DEFAULT_OFFSET,DEFAULT_MAXNOTES);
                subscriber.onNext(data); // Emit the contents of the URL
                subscriber.onCompleted(); // Nothing more to emit
            }catch(Exception e){
                subscriber.onError(e); // In case there are network errors
            }
        }
    });
}

