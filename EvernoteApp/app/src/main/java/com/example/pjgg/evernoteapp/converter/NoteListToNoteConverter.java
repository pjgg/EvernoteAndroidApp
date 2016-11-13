package com.example.pjgg.evernoteapp.converter;

import com.evernote.edam.type.Note;
import com.example.pjgg.evernoteapp.model.AppNote;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NoteListToNoteConverter implements Converter<AppNote, Note>{


    @Override
    public AppNote createDataTransferObject(Note note) {
        AppNote appNote = new AppNote();
        appNote.setActive(note.isActive());
        appNote.setContent(note.getContent());
        appNote.setContentLength(note.getContentLength());
        appNote.setCreated(note.getCreated());
        appNote.setDeleted(note.getDeleted());
        appNote.setGuid(note.getGuid());
        appNote.setNotebookGuid(note.getNotebookGuid());
        appNote.setTitle(note.getTitle());
        appNote.setUpdated(note.getUpdated());
        appNote.setUpdateSequenceNum(note.getUpdateSequenceNum());
        return appNote;
    }

    @Override
    public Collection<AppNote> createDataTransferObjects(Collection<Note> notes) {
        List<AppNote> resultAppNotes = new ArrayList<AppNote>();
        for(Note note:notes) {
            resultAppNotes.add(createDataTransferObject(note));
        }

        return resultAppNotes;
    }
}
