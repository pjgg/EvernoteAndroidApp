package com.example.pjgg.evernoteapp.model;

import java.util.Comparator;

public class AppNote implements Comparable<AppNote>{

    private String guid;
    private String title;
    private String content;
    private int contentLength;
    private long created;
    private long updated;
    private long deleted;
    private boolean active;
    private int updateSequenceNum;
    private String notebookGuid;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getContentLength() {
        return contentLength;
    }

    public void setContentLength(int contentLength) {
        this.contentLength = contentLength;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(long updated) {
        this.updated = updated;
    }

    public long getDeleted() {
        return deleted;
    }

    public void setDeleted(long deleted) {
        this.deleted = deleted;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getUpdateSequenceNum() {
        return updateSequenceNum;
    }

    public void setUpdateSequenceNum(int updateSequenceNum) {
        this.updateSequenceNum = updateSequenceNum;
    }

    public String getNotebookGuid() {
        return notebookGuid;
    }

    public void setNotebookGuid(String notebookGuid) {
        this.notebookGuid = notebookGuid;
    }

    public int compareTo(AppNote appNote) {

        String guid = ((AppNote) appNote).getGuid();

        //ascending order
        return (this.guid.equalsIgnoreCase(guid))?0:1;

    }

    public static Comparator<Object> titleComparator = new Comparator<Object>() {

        public int compare(Object appNote1, Object appNote2) {

            String title1 = ((AppNote)appNote1).getTitle().toUpperCase();
            String title2 = ((AppNote)appNote2).getTitle().toUpperCase();

            //ascending order
            return title1.compareTo(title2);

            //descending order
            //return title2.compareTo(title1);
        }

    };

    public static Comparator<Object> updateNoteComparator = new Comparator<Object>() {

        public int compare(Object one, Object another) {

            int returnVal = 0;
            AppNote t = (AppNote) one;
            AppNote t1 = (AppNote) another;

            if(t.getUpdated() < t1.getUpdated()){
                returnVal =  -1;
            }else if(t.getUpdated() > t1.getUpdated()){
                returnVal =  1;
            }else if(t.getUpdated() == t1.getUpdated()){
                returnVal =  0;
            }
            return returnVal;
        }

    };

    public static Comparator<Object> createDateComparator = new Comparator<Object>() {

        public int compare(Object one, Object another) {
            int returnVal = 0;
            AppNote t = (AppNote) one;
            AppNote t1 = (AppNote) another;

            if(t.getCreated() < t1.getCreated()){
                returnVal =  -1;
            }else if(t.getCreated() > t1.getCreated()){
                returnVal =  1;
            }else if(t.getCreated() == t1.getCreated()){
                returnVal =  0;
            }
            return returnVal;
        }

    };
}
