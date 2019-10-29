package com.example.retrofit_ejercicio1.model;

import com.google.gson.annotations.SerializedName;

public class Post {

    private String objectId;
    private String title;
    @SerializedName("feedLink")
    private String feed;

    public String getObjectId() {
        return objectId;
    }

    public String getTitle() {
        return title;
    }

    public String getFeed() {
        return feed;
    }
}
