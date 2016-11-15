package com.example.pjgg.evernoteapp.views;


import android.widget.TextView;

public class ShowNoteActivityView {

    private TextView title;

    private TextView content;

    public ShowNoteActivityView(TextView t, TextView c){
        this.title = t;
        this.content = c;
    }

    public TextView getTitle() {
        return title;
    }

    public void setTitle(TextView title) {
        this.title = title;
    }

    public TextView getContent() {
        return content;
    }

    public void setContent(TextView content) {
        this.content = content;
    }
}
