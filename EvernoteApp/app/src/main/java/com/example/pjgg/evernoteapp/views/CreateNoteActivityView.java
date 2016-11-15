package com.example.pjgg.evernoteapp.views;

import android.widget.EditText;

public class CreateNoteActivityView {

    EditText titleEditText;
    EditText bodyEditText;

    public CreateNoteActivityView(EditText title, EditText body){
        this.titleEditText = title;
        this.bodyEditText = body;
    }

    public EditText getTitleEditText() {
        return titleEditText;
    }

    public void setTitleEditText(EditText titleEditText) {
        this.titleEditText = titleEditText;
    }

    public EditText getBodyEditText() {
        return bodyEditText;
    }

    public void setBodyEditText(EditText bodyEditText) {
        this.bodyEditText = bodyEditText;
    }

    public String getTitleEditTextAsText(){
        return this.titleEditText.getText().toString();
    }

    public String getBodyEditTextAsText(){
        return this.bodyEditText.getText().toString();
    }
}
