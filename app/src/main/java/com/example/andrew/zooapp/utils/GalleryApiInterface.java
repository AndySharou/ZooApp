package com.example.andrew.zooapp.utils;

import com.example.andrew.zooapp.models.GalleryImage;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Andrew on 19.11.2016.
 */

public interface GalleryApiInterface {

    @GET("/gallery.json")
    void getStreams(Callback<List<GalleryImage>> callback);
}
