package com.example.pjgg.evernoteapp.views;


import android.widget.ListView;

public class MainActivityView {

    private ListView noteslistView;

    public MainActivityView(ListView lv){
        this.noteslistView = lv;
        this.noteslistView.setClickable(true);
    }

    public ListView getNoteslistView() {
        return noteslistView;
    }

    public void setNoteslistView(ListView noteslistView) {
        this.noteslistView = noteslistView;
    }

}
