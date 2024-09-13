package com.example.note;

import io.realm.RealmObject;

public class Note extends RealmObject {

    String title;
    String description;
    Long createdTIme;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCreatedTIme() {
        return createdTIme;
    }

    public void setCreatedTIme(Long createdTIme) {
        this.createdTIme = createdTIme;
    }
}
