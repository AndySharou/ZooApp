package com.example.andrew.zooapp.utils;

import com.example.andrew.zooapp.models.Pin;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Andrew on 20.11.2016.
 */

public interface PinsApiInterface {

    @GET( "/ZooAppPins.json")
    void getStreams(Callback<List<Pin>> callback);
}
